/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.tokio.otp.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.tokio.otp.exception.NoSuchDebugEMailsException;
import com.tokio.otp.model.DebugEMails;
import com.tokio.otp.model.impl.DebugEMailsImpl;
import com.tokio.otp.model.impl.DebugEMailsModelImpl;
import com.tokio.otp.service.persistence.DebugEMailsPersistence;
import com.tokio.otp.service.persistence.DebugEMailsUtil;
import com.tokio.otp.service.persistence.impl.constants.OTPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the debug e mails service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DebugEMailsPersistence.class)
public class DebugEMailsPersistenceImpl
	extends BasePersistenceImpl<DebugEMails> implements DebugEMailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DebugEMailsUtil</code> to access the debug e mails persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DebugEMailsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByEmail;
	private FinderPath _finderPathCountByEmail;

	/**
	 * Returns the debug e mails where email = &#63; or throws a <code>NoSuchDebugEMailsException</code> if it could not be found.
	 *
	 * @param email the email
	 * @return the matching debug e mails
	 * @throws NoSuchDebugEMailsException if a matching debug e mails could not be found
	 */
	@Override
	public DebugEMails findByEmail(String email)
		throws NoSuchDebugEMailsException {

		DebugEMails debugEMails = fetchByEmail(email);

		if (debugEMails == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("email=");
			sb.append(email);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDebugEMailsException(sb.toString());
		}

		return debugEMails;
	}

	/**
	 * Returns the debug e mails where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching debug e mails, or <code>null</code> if a matching debug e mails could not be found
	 */
	@Override
	public DebugEMails fetchByEmail(String email) {
		return fetchByEmail(email, true);
	}

	/**
	 * Returns the debug e mails where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching debug e mails, or <code>null</code> if a matching debug e mails could not be found
	 */
	@Override
	public DebugEMails fetchByEmail(String email, boolean useFinderCache) {
		email = Objects.toString(email, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {email};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByEmail, finderArgs, this);
		}

		if (result instanceof DebugEMails) {
			DebugEMails debugEMails = (DebugEMails)result;

			if (!Objects.equals(email, debugEMails.getEmail())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DEBUGEMAILS_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmail) {
					queryPos.add(email);
				}

				List<DebugEMails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByEmail, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {email};
							}

							_log.warn(
								"DebugEMailsPersistenceImpl.fetchByEmail(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DebugEMails debugEMails = list.get(0);

					result = debugEMails;

					cacheResult(debugEMails);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DebugEMails)result;
		}
	}

	/**
	 * Removes the debug e mails where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the debug e mails that was removed
	 */
	@Override
	public DebugEMails removeByEmail(String email)
		throws NoSuchDebugEMailsException {

		DebugEMails debugEMails = findByEmail(email);

		return remove(debugEMails);
	}

	/**
	 * Returns the number of debug e mailses where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching debug e mailses
	 */
	@Override
	public int countByEmail(String email) {
		email = Objects.toString(email, "");

		FinderPath finderPath = _finderPathCountByEmail;

		Object[] finderArgs = new Object[] {email};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DEBUGEMAILS_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmail) {
					queryPos.add(email);
				}

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 =
		"debugEMails.email = ?";

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 =
		"(debugEMails.email IS NULL OR debugEMails.email = '')";

	public DebugEMailsPersistenceImpl() {
		setModelClass(DebugEMails.class);

		setModelImplClass(DebugEMailsImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the debug e mails in the entity cache if it is enabled.
	 *
	 * @param debugEMails the debug e mails
	 */
	@Override
	public void cacheResult(DebugEMails debugEMails) {
		dummyEntityCache.putResult(
			DebugEMailsImpl.class, debugEMails.getPrimaryKey(), debugEMails);

		dummyFinderCache.putResult(
			_finderPathFetchByEmail, new Object[] {debugEMails.getEmail()},
			debugEMails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the debug e mailses in the entity cache if it is enabled.
	 *
	 * @param debugEMailses the debug e mailses
	 */
	@Override
	public void cacheResult(List<DebugEMails> debugEMailses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (debugEMailses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DebugEMails debugEMails : debugEMailses) {
			if (dummyEntityCache.getResult(
					DebugEMailsImpl.class, debugEMails.getPrimaryKey()) ==
						null) {

				cacheResult(debugEMails);
			}
		}
	}

	/**
	 * Clears the cache for all debug e mailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(DebugEMailsImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the debug e mails.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DebugEMails debugEMails) {
		dummyEntityCache.removeResult(DebugEMailsImpl.class, debugEMails);
	}

	@Override
	public void clearCache(List<DebugEMails> debugEMailses) {
		for (DebugEMails debugEMails : debugEMailses) {
			dummyEntityCache.removeResult(DebugEMailsImpl.class, debugEMails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(DebugEMailsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DebugEMailsModelImpl debugEMailsModelImpl) {

		Object[] args = new Object[] {debugEMailsModelImpl.getEmail()};

		dummyFinderCache.putResult(
			_finderPathCountByEmail, args, Long.valueOf(1), false);
		dummyFinderCache.putResult(
			_finderPathFetchByEmail, args, debugEMailsModelImpl, false);
	}

	/**
	 * Creates a new debug e mails with the primary key. Does not add the debug e mails to the database.
	 *
	 * @param debugEMailsId the primary key for the new debug e mails
	 * @return the new debug e mails
	 */
	@Override
	public DebugEMails create(long debugEMailsId) {
		DebugEMails debugEMails = new DebugEMailsImpl();

		debugEMails.setNew(true);
		debugEMails.setPrimaryKey(debugEMailsId);

		return debugEMails;
	}

	/**
	 * Removes the debug e mails with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param debugEMailsId the primary key of the debug e mails
	 * @return the debug e mails that was removed
	 * @throws NoSuchDebugEMailsException if a debug e mails with the primary key could not be found
	 */
	@Override
	public DebugEMails remove(long debugEMailsId)
		throws NoSuchDebugEMailsException {

		return remove((Serializable)debugEMailsId);
	}

	/**
	 * Removes the debug e mails with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the debug e mails
	 * @return the debug e mails that was removed
	 * @throws NoSuchDebugEMailsException if a debug e mails with the primary key could not be found
	 */
	@Override
	public DebugEMails remove(Serializable primaryKey)
		throws NoSuchDebugEMailsException {

		Session session = null;

		try {
			session = openSession();

			DebugEMails debugEMails = (DebugEMails)session.get(
				DebugEMailsImpl.class, primaryKey);

			if (debugEMails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDebugEMailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(debugEMails);
		}
		catch (NoSuchDebugEMailsException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected DebugEMails removeImpl(DebugEMails debugEMails) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(debugEMails)) {
				debugEMails = (DebugEMails)session.get(
					DebugEMailsImpl.class, debugEMails.getPrimaryKeyObj());
			}

			if (debugEMails != null) {
				session.delete(debugEMails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (debugEMails != null) {
			clearCache(debugEMails);
		}

		return debugEMails;
	}

	@Override
	public DebugEMails updateImpl(DebugEMails debugEMails) {
		boolean isNew = debugEMails.isNew();

		if (!(debugEMails instanceof DebugEMailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(debugEMails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(debugEMails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in debugEMails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DebugEMails implementation " +
					debugEMails.getClass());
		}

		DebugEMailsModelImpl debugEMailsModelImpl =
			(DebugEMailsModelImpl)debugEMails;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(debugEMails);
			}
			else {
				debugEMails = (DebugEMails)session.merge(debugEMails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			DebugEMailsImpl.class, debugEMailsModelImpl, false, true);

		cacheUniqueFindersCache(debugEMailsModelImpl);

		if (isNew) {
			debugEMails.setNew(false);
		}

		debugEMails.resetOriginalValues();

		return debugEMails;
	}

	/**
	 * Returns the debug e mails with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the debug e mails
	 * @return the debug e mails
	 * @throws NoSuchDebugEMailsException if a debug e mails with the primary key could not be found
	 */
	@Override
	public DebugEMails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDebugEMailsException {

		DebugEMails debugEMails = fetchByPrimaryKey(primaryKey);

		if (debugEMails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDebugEMailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return debugEMails;
	}

	/**
	 * Returns the debug e mails with the primary key or throws a <code>NoSuchDebugEMailsException</code> if it could not be found.
	 *
	 * @param debugEMailsId the primary key of the debug e mails
	 * @return the debug e mails
	 * @throws NoSuchDebugEMailsException if a debug e mails with the primary key could not be found
	 */
	@Override
	public DebugEMails findByPrimaryKey(long debugEMailsId)
		throws NoSuchDebugEMailsException {

		return findByPrimaryKey((Serializable)debugEMailsId);
	}

	/**
	 * Returns the debug e mails with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param debugEMailsId the primary key of the debug e mails
	 * @return the debug e mails, or <code>null</code> if a debug e mails with the primary key could not be found
	 */
	@Override
	public DebugEMails fetchByPrimaryKey(long debugEMailsId) {
		return fetchByPrimaryKey((Serializable)debugEMailsId);
	}

	/**
	 * Returns all the debug e mailses.
	 *
	 * @return the debug e mailses
	 */
	@Override
	public List<DebugEMails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the debug e mailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DebugEMailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of debug e mailses
	 * @param end the upper bound of the range of debug e mailses (not inclusive)
	 * @return the range of debug e mailses
	 */
	@Override
	public List<DebugEMails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the debug e mailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DebugEMailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of debug e mailses
	 * @param end the upper bound of the range of debug e mailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of debug e mailses
	 */
	@Override
	public List<DebugEMails> findAll(
		int start, int end, OrderByComparator<DebugEMails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the debug e mailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DebugEMailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of debug e mailses
	 * @param end the upper bound of the range of debug e mailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of debug e mailses
	 */
	@Override
	public List<DebugEMails> findAll(
		int start, int end, OrderByComparator<DebugEMails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<DebugEMails> list = null;

		if (useFinderCache) {
			list = (List<DebugEMails>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DEBUGEMAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DEBUGEMAILS;

				sql = sql.concat(DebugEMailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DebugEMails>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the debug e mailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DebugEMails debugEMails : findAll()) {
			remove(debugEMails);
		}
	}

	/**
	 * Returns the number of debug e mailses.
	 *
	 * @return the number of debug e mailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DEBUGEMAILS);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return dummyEntityCache;
	}

	@Override
	protected String getPKDBName() {
		return "debugEMailsId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DEBUGEMAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DebugEMailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the debug e mails persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new DebugEMailsModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", DebugEMails.class.getName()));

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByEmail = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByEmail",
			new String[] {String.class.getName()}, new String[] {"email"},
			true);

		_finderPathCountByEmail = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
			new String[] {String.class.getName()}, new String[] {"email"},
			false);

		_setDebugEMailsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDebugEMailsUtilPersistence(null);

		dummyEntityCache.removeCache(DebugEMailsImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setDebugEMailsUtilPersistence(
		DebugEMailsPersistence debugEMailsPersistence) {

		try {
			Field field = DebugEMailsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, debugEMailsPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = OTPPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = OTPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = OTPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	private static final String _SQL_SELECT_DEBUGEMAILS =
		"SELECT debugEMails FROM DebugEMails debugEMails";

	private static final String _SQL_SELECT_DEBUGEMAILS_WHERE =
		"SELECT debugEMails FROM DebugEMails debugEMails WHERE ";

	private static final String _SQL_COUNT_DEBUGEMAILS =
		"SELECT COUNT(debugEMails) FROM DebugEMails debugEMails";

	private static final String _SQL_COUNT_DEBUGEMAILS_WHERE =
		"SELECT COUNT(debugEMails) FROM DebugEMails debugEMails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "debugEMails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DebugEMails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DebugEMails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DebugEMailsPersistenceImpl.class);

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class DebugEMailsModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return new Object[0];
				}

				return null;
			}

			DebugEMailsModelImpl debugEMailsModelImpl =
				(DebugEMailsModelImpl)baseModel;

			long columnBitmask = debugEMailsModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(debugEMailsModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						debugEMailsModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(debugEMailsModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			DebugEMailsModelImpl debugEMailsModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = debugEMailsModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = debugEMailsModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}