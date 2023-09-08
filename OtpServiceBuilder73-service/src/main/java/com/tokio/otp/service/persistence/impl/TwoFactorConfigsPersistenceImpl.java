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

import com.tokio.otp.exception.NoSuchTwoFactorConfigsException;
import com.tokio.otp.model.TwoFactorConfigs;
import com.tokio.otp.model.impl.TwoFactorConfigsImpl;
import com.tokio.otp.model.impl.TwoFactorConfigsModelImpl;
import com.tokio.otp.service.persistence.TwoFactorConfigsPersistence;
import com.tokio.otp.service.persistence.TwoFactorConfigsUtil;
import com.tokio.otp.service.persistence.impl.constants.OTPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
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
 * The persistence implementation for the two factor configs service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TwoFactorConfigsPersistence.class)
public class TwoFactorConfigsPersistenceImpl
	extends BasePersistenceImpl<TwoFactorConfigs>
	implements TwoFactorConfigsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TwoFactorConfigsUtil</code> to access the two factor configs persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TwoFactorConfigsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByConfigName;
	private FinderPath _finderPathCountByConfigName;

	/**
	 * Returns the two factor configs where configName = &#63; and companyId = &#63; or throws a <code>NoSuchTwoFactorConfigsException</code> if it could not be found.
	 *
	 * @param configName the config name
	 * @param companyId the company ID
	 * @return the matching two factor configs
	 * @throws NoSuchTwoFactorConfigsException if a matching two factor configs could not be found
	 */
	@Override
	public TwoFactorConfigs findByConfigName(String configName, long companyId)
		throws NoSuchTwoFactorConfigsException {

		TwoFactorConfigs twoFactorConfigs = fetchByConfigName(
			configName, companyId);

		if (twoFactorConfigs == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("configName=");
			sb.append(configName);

			sb.append(", companyId=");
			sb.append(companyId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTwoFactorConfigsException(sb.toString());
		}

		return twoFactorConfigs;
	}

	/**
	 * Returns the two factor configs where configName = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param configName the config name
	 * @param companyId the company ID
	 * @return the matching two factor configs, or <code>null</code> if a matching two factor configs could not be found
	 */
	@Override
	public TwoFactorConfigs fetchByConfigName(
		String configName, long companyId) {

		return fetchByConfigName(configName, companyId, true);
	}

	/**
	 * Returns the two factor configs where configName = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param configName the config name
	 * @param companyId the company ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching two factor configs, or <code>null</code> if a matching two factor configs could not be found
	 */
	@Override
	public TwoFactorConfigs fetchByConfigName(
		String configName, long companyId, boolean useFinderCache) {

		configName = Objects.toString(configName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {configName, companyId};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByConfigName, finderArgs, this);
		}

		if (result instanceof TwoFactorConfigs) {
			TwoFactorConfigs twoFactorConfigs = (TwoFactorConfigs)result;

			if (!Objects.equals(configName, twoFactorConfigs.getConfigName()) ||
				(companyId != twoFactorConfigs.getCompanyId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TWOFACTORCONFIGS_WHERE);

			boolean bindConfigName = false;

			if (configName.isEmpty()) {
				sb.append(_FINDER_COLUMN_CONFIGNAME_CONFIGNAME_3);
			}
			else {
				bindConfigName = true;

				sb.append(_FINDER_COLUMN_CONFIGNAME_CONFIGNAME_2);
			}

			sb.append(_FINDER_COLUMN_CONFIGNAME_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindConfigName) {
					queryPos.add(configName);
				}

				queryPos.add(companyId);

				List<TwoFactorConfigs> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByConfigName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									configName, companyId
								};
							}

							_log.warn(
								"TwoFactorConfigsPersistenceImpl.fetchByConfigName(String, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TwoFactorConfigs twoFactorConfigs = list.get(0);

					result = twoFactorConfigs;

					cacheResult(twoFactorConfigs);
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
			return (TwoFactorConfigs)result;
		}
	}

	/**
	 * Removes the two factor configs where configName = &#63; and companyId = &#63; from the database.
	 *
	 * @param configName the config name
	 * @param companyId the company ID
	 * @return the two factor configs that was removed
	 */
	@Override
	public TwoFactorConfigs removeByConfigName(
			String configName, long companyId)
		throws NoSuchTwoFactorConfigsException {

		TwoFactorConfigs twoFactorConfigs = findByConfigName(
			configName, companyId);

		return remove(twoFactorConfigs);
	}

	/**
	 * Returns the number of two factor configses where configName = &#63; and companyId = &#63;.
	 *
	 * @param configName the config name
	 * @param companyId the company ID
	 * @return the number of matching two factor configses
	 */
	@Override
	public int countByConfigName(String configName, long companyId) {
		configName = Objects.toString(configName, "");

		FinderPath finderPath = _finderPathCountByConfigName;

		Object[] finderArgs = new Object[] {configName, companyId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TWOFACTORCONFIGS_WHERE);

			boolean bindConfigName = false;

			if (configName.isEmpty()) {
				sb.append(_FINDER_COLUMN_CONFIGNAME_CONFIGNAME_3);
			}
			else {
				bindConfigName = true;

				sb.append(_FINDER_COLUMN_CONFIGNAME_CONFIGNAME_2);
			}

			sb.append(_FINDER_COLUMN_CONFIGNAME_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindConfigName) {
					queryPos.add(configName);
				}

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

	private static final String _FINDER_COLUMN_CONFIGNAME_CONFIGNAME_2 =
		"twoFactorConfigs.configName = ? AND ";

	private static final String _FINDER_COLUMN_CONFIGNAME_CONFIGNAME_3 =
		"(twoFactorConfigs.configName IS NULL OR twoFactorConfigs.configName = '') AND ";

	private static final String _FINDER_COLUMN_CONFIGNAME_COMPANYID_2 =
		"twoFactorConfigs.companyId = ?";

	public TwoFactorConfigsPersistenceImpl() {
		setModelClass(TwoFactorConfigs.class);

		setModelImplClass(TwoFactorConfigsImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the two factor configs in the entity cache if it is enabled.
	 *
	 * @param twoFactorConfigs the two factor configs
	 */
	@Override
	public void cacheResult(TwoFactorConfigs twoFactorConfigs) {
		dummyEntityCache.putResult(
			TwoFactorConfigsImpl.class, twoFactorConfigs.getPrimaryKey(),
			twoFactorConfigs);

		dummyFinderCache.putResult(
			_finderPathFetchByConfigName,
			new Object[] {
				twoFactorConfigs.getConfigName(),
				twoFactorConfigs.getCompanyId()
			},
			twoFactorConfigs);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the two factor configses in the entity cache if it is enabled.
	 *
	 * @param twoFactorConfigses the two factor configses
	 */
	@Override
	public void cacheResult(List<TwoFactorConfigs> twoFactorConfigses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (twoFactorConfigses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TwoFactorConfigs twoFactorConfigs : twoFactorConfigses) {
			if (dummyEntityCache.getResult(
					TwoFactorConfigsImpl.class,
					twoFactorConfigs.getPrimaryKey()) == null) {

				cacheResult(twoFactorConfigs);
			}
		}
	}

	/**
	 * Clears the cache for all two factor configses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(TwoFactorConfigsImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the two factor configs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TwoFactorConfigs twoFactorConfigs) {
		dummyEntityCache.removeResult(
			TwoFactorConfigsImpl.class, twoFactorConfigs);
	}

	@Override
	public void clearCache(List<TwoFactorConfigs> twoFactorConfigses) {
		for (TwoFactorConfigs twoFactorConfigs : twoFactorConfigses) {
			dummyEntityCache.removeResult(
				TwoFactorConfigsImpl.class, twoFactorConfigs);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				TwoFactorConfigsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TwoFactorConfigsModelImpl twoFactorConfigsModelImpl) {

		Object[] args = new Object[] {
			twoFactorConfigsModelImpl.getConfigName(),
			twoFactorConfigsModelImpl.getCompanyId()
		};

		dummyFinderCache.putResult(
			_finderPathCountByConfigName, args, Long.valueOf(1), false);
		dummyFinderCache.putResult(
			_finderPathFetchByConfigName, args, twoFactorConfigsModelImpl,
			false);
	}

	/**
	 * Creates a new two factor configs with the primary key. Does not add the two factor configs to the database.
	 *
	 * @param twoFactorConfigsId the primary key for the new two factor configs
	 * @return the new two factor configs
	 */
	@Override
	public TwoFactorConfigs create(long twoFactorConfigsId) {
		TwoFactorConfigs twoFactorConfigs = new TwoFactorConfigsImpl();

		twoFactorConfigs.setNew(true);
		twoFactorConfigs.setPrimaryKey(twoFactorConfigsId);

		twoFactorConfigs.setCompanyId(CompanyThreadLocal.getCompanyId());

		return twoFactorConfigs;
	}

	/**
	 * Removes the two factor configs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param twoFactorConfigsId the primary key of the two factor configs
	 * @return the two factor configs that was removed
	 * @throws NoSuchTwoFactorConfigsException if a two factor configs with the primary key could not be found
	 */
	@Override
	public TwoFactorConfigs remove(long twoFactorConfigsId)
		throws NoSuchTwoFactorConfigsException {

		return remove((Serializable)twoFactorConfigsId);
	}

	/**
	 * Removes the two factor configs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the two factor configs
	 * @return the two factor configs that was removed
	 * @throws NoSuchTwoFactorConfigsException if a two factor configs with the primary key could not be found
	 */
	@Override
	public TwoFactorConfigs remove(Serializable primaryKey)
		throws NoSuchTwoFactorConfigsException {

		Session session = null;

		try {
			session = openSession();

			TwoFactorConfigs twoFactorConfigs = (TwoFactorConfigs)session.get(
				TwoFactorConfigsImpl.class, primaryKey);

			if (twoFactorConfigs == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTwoFactorConfigsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(twoFactorConfigs);
		}
		catch (NoSuchTwoFactorConfigsException noSuchEntityException) {
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
	protected TwoFactorConfigs removeImpl(TwoFactorConfigs twoFactorConfigs) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(twoFactorConfigs)) {
				twoFactorConfigs = (TwoFactorConfigs)session.get(
					TwoFactorConfigsImpl.class,
					twoFactorConfigs.getPrimaryKeyObj());
			}

			if (twoFactorConfigs != null) {
				session.delete(twoFactorConfigs);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (twoFactorConfigs != null) {
			clearCache(twoFactorConfigs);
		}

		return twoFactorConfigs;
	}

	@Override
	public TwoFactorConfigs updateImpl(TwoFactorConfigs twoFactorConfigs) {
		boolean isNew = twoFactorConfigs.isNew();

		if (!(twoFactorConfigs instanceof TwoFactorConfigsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(twoFactorConfigs.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					twoFactorConfigs);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in twoFactorConfigs proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TwoFactorConfigs implementation " +
					twoFactorConfigs.getClass());
		}

		TwoFactorConfigsModelImpl twoFactorConfigsModelImpl =
			(TwoFactorConfigsModelImpl)twoFactorConfigs;

		if (!twoFactorConfigsModelImpl.hasSetModifiedDate()) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				twoFactorConfigs.setModifiedDate(date);
			}
			else {
				twoFactorConfigs.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(twoFactorConfigs);
			}
			else {
				twoFactorConfigs = (TwoFactorConfigs)session.merge(
					twoFactorConfigs);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			TwoFactorConfigsImpl.class, twoFactorConfigsModelImpl, false, true);

		cacheUniqueFindersCache(twoFactorConfigsModelImpl);

		if (isNew) {
			twoFactorConfigs.setNew(false);
		}

		twoFactorConfigs.resetOriginalValues();

		return twoFactorConfigs;
	}

	/**
	 * Returns the two factor configs with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the two factor configs
	 * @return the two factor configs
	 * @throws NoSuchTwoFactorConfigsException if a two factor configs with the primary key could not be found
	 */
	@Override
	public TwoFactorConfigs findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTwoFactorConfigsException {

		TwoFactorConfigs twoFactorConfigs = fetchByPrimaryKey(primaryKey);

		if (twoFactorConfigs == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTwoFactorConfigsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return twoFactorConfigs;
	}

	/**
	 * Returns the two factor configs with the primary key or throws a <code>NoSuchTwoFactorConfigsException</code> if it could not be found.
	 *
	 * @param twoFactorConfigsId the primary key of the two factor configs
	 * @return the two factor configs
	 * @throws NoSuchTwoFactorConfigsException if a two factor configs with the primary key could not be found
	 */
	@Override
	public TwoFactorConfigs findByPrimaryKey(long twoFactorConfigsId)
		throws NoSuchTwoFactorConfigsException {

		return findByPrimaryKey((Serializable)twoFactorConfigsId);
	}

	/**
	 * Returns the two factor configs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param twoFactorConfigsId the primary key of the two factor configs
	 * @return the two factor configs, or <code>null</code> if a two factor configs with the primary key could not be found
	 */
	@Override
	public TwoFactorConfigs fetchByPrimaryKey(long twoFactorConfigsId) {
		return fetchByPrimaryKey((Serializable)twoFactorConfigsId);
	}

	/**
	 * Returns all the two factor configses.
	 *
	 * @return the two factor configses
	 */
	@Override
	public List<TwoFactorConfigs> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the two factor configses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TwoFactorConfigsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of two factor configses
	 * @param end the upper bound of the range of two factor configses (not inclusive)
	 * @return the range of two factor configses
	 */
	@Override
	public List<TwoFactorConfigs> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the two factor configses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TwoFactorConfigsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of two factor configses
	 * @param end the upper bound of the range of two factor configses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of two factor configses
	 */
	@Override
	public List<TwoFactorConfigs> findAll(
		int start, int end,
		OrderByComparator<TwoFactorConfigs> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the two factor configses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TwoFactorConfigsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of two factor configses
	 * @param end the upper bound of the range of two factor configses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of two factor configses
	 */
	@Override
	public List<TwoFactorConfigs> findAll(
		int start, int end,
		OrderByComparator<TwoFactorConfigs> orderByComparator,
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

		List<TwoFactorConfigs> list = null;

		if (useFinderCache) {
			list = (List<TwoFactorConfigs>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TWOFACTORCONFIGS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TWOFACTORCONFIGS;

				sql = sql.concat(TwoFactorConfigsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TwoFactorConfigs>)QueryUtil.list(
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
	 * Removes all the two factor configses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TwoFactorConfigs twoFactorConfigs : findAll()) {
			remove(twoFactorConfigs);
		}
	}

	/**
	 * Returns the number of two factor configses.
	 *
	 * @return the number of two factor configses
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TWOFACTORCONFIGS);

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
		return "twoFactorConfigsId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TWOFACTORCONFIGS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TwoFactorConfigsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the two factor configs persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new TwoFactorConfigsModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", TwoFactorConfigs.class.getName()));

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

		_finderPathFetchByConfigName = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByConfigName",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"configName", "companyId"}, true);

		_finderPathCountByConfigName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByConfigName",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"configName", "companyId"}, false);

		_setTwoFactorConfigsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTwoFactorConfigsUtilPersistence(null);

		dummyEntityCache.removeCache(TwoFactorConfigsImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setTwoFactorConfigsUtilPersistence(
		TwoFactorConfigsPersistence twoFactorConfigsPersistence) {

		try {
			Field field = TwoFactorConfigsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, twoFactorConfigsPersistence);
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

	private static final String _SQL_SELECT_TWOFACTORCONFIGS =
		"SELECT twoFactorConfigs FROM TwoFactorConfigs twoFactorConfigs";

	private static final String _SQL_SELECT_TWOFACTORCONFIGS_WHERE =
		"SELECT twoFactorConfigs FROM TwoFactorConfigs twoFactorConfigs WHERE ";

	private static final String _SQL_COUNT_TWOFACTORCONFIGS =
		"SELECT COUNT(twoFactorConfigs) FROM TwoFactorConfigs twoFactorConfigs";

	private static final String _SQL_COUNT_TWOFACTORCONFIGS_WHERE =
		"SELECT COUNT(twoFactorConfigs) FROM TwoFactorConfigs twoFactorConfigs WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "twoFactorConfigs.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TwoFactorConfigs exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TwoFactorConfigs exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TwoFactorConfigsPersistenceImpl.class);

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

	private static class TwoFactorConfigsModelArgumentsResolver
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

			TwoFactorConfigsModelImpl twoFactorConfigsModelImpl =
				(TwoFactorConfigsModelImpl)baseModel;

			long columnBitmask = twoFactorConfigsModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					twoFactorConfigsModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						twoFactorConfigsModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					twoFactorConfigsModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			TwoFactorConfigsModelImpl twoFactorConfigsModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						twoFactorConfigsModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = twoFactorConfigsModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}