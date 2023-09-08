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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.tokio.otp.exception.NoSuchTwoFactorException;
import com.tokio.otp.model.TwoFactor;
import com.tokio.otp.model.impl.TwoFactorImpl;
import com.tokio.otp.model.impl.TwoFactorModelImpl;
import com.tokio.otp.service.persistence.TwoFactorPersistence;
import com.tokio.otp.service.persistence.TwoFactorUtil;
import com.tokio.otp.service.persistence.impl.constants.OTPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
 * The persistence implementation for the two factor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TwoFactorPersistence.class)
public class TwoFactorPersistenceImpl
	extends BasePersistenceImpl<TwoFactor> implements TwoFactorPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TwoFactorUtil</code> to access the two factor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TwoFactorImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByUserIdAndCompanyId;
	private FinderPath _finderPathCountByUserIdAndCompanyId;

	/**
	 * Returns the two factor where userId = &#63; and companyId = &#63; or throws a <code>NoSuchTwoFactorException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching two factor
	 * @throws NoSuchTwoFactorException if a matching two factor could not be found
	 */
	@Override
	public TwoFactor findByUserIdAndCompanyId(long userId, long companyId)
		throws NoSuchTwoFactorException {

		TwoFactor twoFactor = fetchByUserIdAndCompanyId(userId, companyId);

		if (twoFactor == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append(", companyId=");
			sb.append(companyId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTwoFactorException(sb.toString());
		}

		return twoFactor;
	}

	/**
	 * Returns the two factor where userId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching two factor, or <code>null</code> if a matching two factor could not be found
	 */
	@Override
	public TwoFactor fetchByUserIdAndCompanyId(long userId, long companyId) {
		return fetchByUserIdAndCompanyId(userId, companyId, true);
	}

	/**
	 * Returns the two factor where userId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching two factor, or <code>null</code> if a matching two factor could not be found
	 */
	@Override
	public TwoFactor fetchByUserIdAndCompanyId(
		long userId, long companyId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId, companyId};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByUserIdAndCompanyId, finderArgs, this);
		}

		if (result instanceof TwoFactor) {
			TwoFactor twoFactor = (TwoFactor)result;

			if ((userId != twoFactor.getUserId()) ||
				(companyId != twoFactor.getCompanyId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TWOFACTOR_WHERE);

			sb.append(_FINDER_COLUMN_USERIDANDCOMPANYID_USERID_2);

			sb.append(_FINDER_COLUMN_USERIDANDCOMPANYID_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(companyId);

				List<TwoFactor> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByUserIdAndCompanyId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {userId, companyId};
							}

							_log.warn(
								"TwoFactorPersistenceImpl.fetchByUserIdAndCompanyId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TwoFactor twoFactor = list.get(0);

					result = twoFactor;

					cacheResult(twoFactor);
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
			return (TwoFactor)result;
		}
	}

	/**
	 * Removes the two factor where userId = &#63; and companyId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the two factor that was removed
	 */
	@Override
	public TwoFactor removeByUserIdAndCompanyId(long userId, long companyId)
		throws NoSuchTwoFactorException {

		TwoFactor twoFactor = findByUserIdAndCompanyId(userId, companyId);

		return remove(twoFactor);
	}

	/**
	 * Returns the number of two factors where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the number of matching two factors
	 */
	@Override
	public int countByUserIdAndCompanyId(long userId, long companyId) {
		FinderPath finderPath = _finderPathCountByUserIdAndCompanyId;

		Object[] finderArgs = new Object[] {userId, companyId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TWOFACTOR_WHERE);

			sb.append(_FINDER_COLUMN_USERIDANDCOMPANYID_USERID_2);

			sb.append(_FINDER_COLUMN_USERIDANDCOMPANYID_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_USERIDANDCOMPANYID_USERID_2 =
		"twoFactor.userId = ? AND ";

	private static final String _FINDER_COLUMN_USERIDANDCOMPANYID_COMPANYID_2 =
		"twoFactor.companyId = ?";

	public TwoFactorPersistenceImpl() {
		setModelClass(TwoFactor.class);

		setModelImplClass(TwoFactorImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the two factor in the entity cache if it is enabled.
	 *
	 * @param twoFactor the two factor
	 */
	@Override
	public void cacheResult(TwoFactor twoFactor) {
		dummyEntityCache.putResult(
			TwoFactorImpl.class, twoFactor.getPrimaryKey(), twoFactor);

		dummyFinderCache.putResult(
			_finderPathFetchByUserIdAndCompanyId,
			new Object[] {twoFactor.getUserId(), twoFactor.getCompanyId()},
			twoFactor);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the two factors in the entity cache if it is enabled.
	 *
	 * @param twoFactors the two factors
	 */
	@Override
	public void cacheResult(List<TwoFactor> twoFactors) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (twoFactors.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TwoFactor twoFactor : twoFactors) {
			if (dummyEntityCache.getResult(
					TwoFactorImpl.class, twoFactor.getPrimaryKey()) == null) {

				cacheResult(twoFactor);
			}
		}
	}

	/**
	 * Clears the cache for all two factors.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(TwoFactorImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the two factor.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TwoFactor twoFactor) {
		dummyEntityCache.removeResult(TwoFactorImpl.class, twoFactor);
	}

	@Override
	public void clearCache(List<TwoFactor> twoFactors) {
		for (TwoFactor twoFactor : twoFactors) {
			dummyEntityCache.removeResult(TwoFactorImpl.class, twoFactor);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(TwoFactorImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TwoFactorModelImpl twoFactorModelImpl) {

		Object[] args = new Object[] {
			twoFactorModelImpl.getUserId(), twoFactorModelImpl.getCompanyId()
		};

		dummyFinderCache.putResult(
			_finderPathCountByUserIdAndCompanyId, args, Long.valueOf(1), false);
		dummyFinderCache.putResult(
			_finderPathFetchByUserIdAndCompanyId, args, twoFactorModelImpl,
			false);
	}

	/**
	 * Creates a new two factor with the primary key. Does not add the two factor to the database.
	 *
	 * @param twoFactorId the primary key for the new two factor
	 * @return the new two factor
	 */
	@Override
	public TwoFactor create(long twoFactorId) {
		TwoFactor twoFactor = new TwoFactorImpl();

		twoFactor.setNew(true);
		twoFactor.setPrimaryKey(twoFactorId);

		twoFactor.setCompanyId(CompanyThreadLocal.getCompanyId());

		return twoFactor;
	}

	/**
	 * Removes the two factor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param twoFactorId the primary key of the two factor
	 * @return the two factor that was removed
	 * @throws NoSuchTwoFactorException if a two factor with the primary key could not be found
	 */
	@Override
	public TwoFactor remove(long twoFactorId) throws NoSuchTwoFactorException {
		return remove((Serializable)twoFactorId);
	}

	/**
	 * Removes the two factor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the two factor
	 * @return the two factor that was removed
	 * @throws NoSuchTwoFactorException if a two factor with the primary key could not be found
	 */
	@Override
	public TwoFactor remove(Serializable primaryKey)
		throws NoSuchTwoFactorException {

		Session session = null;

		try {
			session = openSession();

			TwoFactor twoFactor = (TwoFactor)session.get(
				TwoFactorImpl.class, primaryKey);

			if (twoFactor == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTwoFactorException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(twoFactor);
		}
		catch (NoSuchTwoFactorException noSuchEntityException) {
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
	protected TwoFactor removeImpl(TwoFactor twoFactor) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(twoFactor)) {
				twoFactor = (TwoFactor)session.get(
					TwoFactorImpl.class, twoFactor.getPrimaryKeyObj());
			}

			if (twoFactor != null) {
				session.delete(twoFactor);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (twoFactor != null) {
			clearCache(twoFactor);
		}

		return twoFactor;
	}

	@Override
	public TwoFactor updateImpl(TwoFactor twoFactor) {
		boolean isNew = twoFactor.isNew();

		if (!(twoFactor instanceof TwoFactorModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(twoFactor.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(twoFactor);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in twoFactor proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TwoFactor implementation " +
					twoFactor.getClass());
		}

		TwoFactorModelImpl twoFactorModelImpl = (TwoFactorModelImpl)twoFactor;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (twoFactor.getCreateDate() == null)) {
			if (serviceContext == null) {
				twoFactor.setCreateDate(date);
			}
			else {
				twoFactor.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!twoFactorModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				twoFactor.setModifiedDate(date);
			}
			else {
				twoFactor.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(twoFactor);
			}
			else {
				twoFactor = (TwoFactor)session.merge(twoFactor);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			TwoFactorImpl.class, twoFactorModelImpl, false, true);

		cacheUniqueFindersCache(twoFactorModelImpl);

		if (isNew) {
			twoFactor.setNew(false);
		}

		twoFactor.resetOriginalValues();

		return twoFactor;
	}

	/**
	 * Returns the two factor with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the two factor
	 * @return the two factor
	 * @throws NoSuchTwoFactorException if a two factor with the primary key could not be found
	 */
	@Override
	public TwoFactor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTwoFactorException {

		TwoFactor twoFactor = fetchByPrimaryKey(primaryKey);

		if (twoFactor == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTwoFactorException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return twoFactor;
	}

	/**
	 * Returns the two factor with the primary key or throws a <code>NoSuchTwoFactorException</code> if it could not be found.
	 *
	 * @param twoFactorId the primary key of the two factor
	 * @return the two factor
	 * @throws NoSuchTwoFactorException if a two factor with the primary key could not be found
	 */
	@Override
	public TwoFactor findByPrimaryKey(long twoFactorId)
		throws NoSuchTwoFactorException {

		return findByPrimaryKey((Serializable)twoFactorId);
	}

	/**
	 * Returns the two factor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param twoFactorId the primary key of the two factor
	 * @return the two factor, or <code>null</code> if a two factor with the primary key could not be found
	 */
	@Override
	public TwoFactor fetchByPrimaryKey(long twoFactorId) {
		return fetchByPrimaryKey((Serializable)twoFactorId);
	}

	/**
	 * Returns all the two factors.
	 *
	 * @return the two factors
	 */
	@Override
	public List<TwoFactor> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the two factors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TwoFactorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of two factors
	 * @param end the upper bound of the range of two factors (not inclusive)
	 * @return the range of two factors
	 */
	@Override
	public List<TwoFactor> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the two factors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TwoFactorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of two factors
	 * @param end the upper bound of the range of two factors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of two factors
	 */
	@Override
	public List<TwoFactor> findAll(
		int start, int end, OrderByComparator<TwoFactor> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the two factors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TwoFactorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of two factors
	 * @param end the upper bound of the range of two factors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of two factors
	 */
	@Override
	public List<TwoFactor> findAll(
		int start, int end, OrderByComparator<TwoFactor> orderByComparator,
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

		List<TwoFactor> list = null;

		if (useFinderCache) {
			list = (List<TwoFactor>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TWOFACTOR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TWOFACTOR;

				sql = sql.concat(TwoFactorModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TwoFactor>)QueryUtil.list(
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
	 * Removes all the two factors from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TwoFactor twoFactor : findAll()) {
			remove(twoFactor);
		}
	}

	/**
	 * Returns the number of two factors.
	 *
	 * @return the number of two factors
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TWOFACTOR);

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
		return "twoFactorId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TWOFACTOR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TwoFactorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the two factor persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new TwoFactorModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", TwoFactor.class.getName()));

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

		_finderPathFetchByUserIdAndCompanyId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUserIdAndCompanyId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"userId", "companyId"}, true);

		_finderPathCountByUserIdAndCompanyId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndCompanyId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"userId", "companyId"}, false);

		_setTwoFactorUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTwoFactorUtilPersistence(null);

		dummyEntityCache.removeCache(TwoFactorImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setTwoFactorUtilPersistence(
		TwoFactorPersistence twoFactorPersistence) {

		try {
			Field field = TwoFactorUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, twoFactorPersistence);
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

	private static final String _SQL_SELECT_TWOFACTOR =
		"SELECT twoFactor FROM TwoFactor twoFactor";

	private static final String _SQL_SELECT_TWOFACTOR_WHERE =
		"SELECT twoFactor FROM TwoFactor twoFactor WHERE ";

	private static final String _SQL_COUNT_TWOFACTOR =
		"SELECT COUNT(twoFactor) FROM TwoFactor twoFactor";

	private static final String _SQL_COUNT_TWOFACTOR_WHERE =
		"SELECT COUNT(twoFactor) FROM TwoFactor twoFactor WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "twoFactor.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TwoFactor exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TwoFactor exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TwoFactorPersistenceImpl.class);

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

	private static class TwoFactorModelArgumentsResolver
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

			TwoFactorModelImpl twoFactorModelImpl =
				(TwoFactorModelImpl)baseModel;

			long columnBitmask = twoFactorModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(twoFactorModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						twoFactorModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(twoFactorModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			TwoFactorModelImpl twoFactorModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = twoFactorModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = twoFactorModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}