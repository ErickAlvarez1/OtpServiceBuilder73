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

package com.tokio.otp.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.tokio.otp.model.TwoFactorConfigs;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the two factor configs service. This utility wraps <code>com.tokio.otp.service.persistence.impl.TwoFactorConfigsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TwoFactorConfigsPersistence
 * @generated
 */
public class TwoFactorConfigsUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TwoFactorConfigs twoFactorConfigs) {
		getPersistence().clearCache(twoFactorConfigs);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, TwoFactorConfigs> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TwoFactorConfigs> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TwoFactorConfigs> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TwoFactorConfigs> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TwoFactorConfigs> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TwoFactorConfigs update(TwoFactorConfigs twoFactorConfigs) {
		return getPersistence().update(twoFactorConfigs);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TwoFactorConfigs update(
		TwoFactorConfigs twoFactorConfigs, ServiceContext serviceContext) {

		return getPersistence().update(twoFactorConfigs, serviceContext);
	}

	/**
	 * Returns the two factor configs where configName = &#63; and companyId = &#63; or throws a <code>NoSuchTwoFactorConfigsException</code> if it could not be found.
	 *
	 * @param configName the config name
	 * @param companyId the company ID
	 * @return the matching two factor configs
	 * @throws NoSuchTwoFactorConfigsException if a matching two factor configs could not be found
	 */
	public static TwoFactorConfigs findByConfigName(
			String configName, long companyId)
		throws com.tokio.otp.exception.NoSuchTwoFactorConfigsException {

		return getPersistence().findByConfigName(configName, companyId);
	}

	/**
	 * Returns the two factor configs where configName = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param configName the config name
	 * @param companyId the company ID
	 * @return the matching two factor configs, or <code>null</code> if a matching two factor configs could not be found
	 */
	public static TwoFactorConfigs fetchByConfigName(
		String configName, long companyId) {

		return getPersistence().fetchByConfigName(configName, companyId);
	}

	/**
	 * Returns the two factor configs where configName = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param configName the config name
	 * @param companyId the company ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching two factor configs, or <code>null</code> if a matching two factor configs could not be found
	 */
	public static TwoFactorConfigs fetchByConfigName(
		String configName, long companyId, boolean useFinderCache) {

		return getPersistence().fetchByConfigName(
			configName, companyId, useFinderCache);
	}

	/**
	 * Removes the two factor configs where configName = &#63; and companyId = &#63; from the database.
	 *
	 * @param configName the config name
	 * @param companyId the company ID
	 * @return the two factor configs that was removed
	 */
	public static TwoFactorConfigs removeByConfigName(
			String configName, long companyId)
		throws com.tokio.otp.exception.NoSuchTwoFactorConfigsException {

		return getPersistence().removeByConfigName(configName, companyId);
	}

	/**
	 * Returns the number of two factor configses where configName = &#63; and companyId = &#63;.
	 *
	 * @param configName the config name
	 * @param companyId the company ID
	 * @return the number of matching two factor configses
	 */
	public static int countByConfigName(String configName, long companyId) {
		return getPersistence().countByConfigName(configName, companyId);
	}

	/**
	 * Caches the two factor configs in the entity cache if it is enabled.
	 *
	 * @param twoFactorConfigs the two factor configs
	 */
	public static void cacheResult(TwoFactorConfigs twoFactorConfigs) {
		getPersistence().cacheResult(twoFactorConfigs);
	}

	/**
	 * Caches the two factor configses in the entity cache if it is enabled.
	 *
	 * @param twoFactorConfigses the two factor configses
	 */
	public static void cacheResult(List<TwoFactorConfigs> twoFactorConfigses) {
		getPersistence().cacheResult(twoFactorConfigses);
	}

	/**
	 * Creates a new two factor configs with the primary key. Does not add the two factor configs to the database.
	 *
	 * @param twoFactorConfigsId the primary key for the new two factor configs
	 * @return the new two factor configs
	 */
	public static TwoFactorConfigs create(long twoFactorConfigsId) {
		return getPersistence().create(twoFactorConfigsId);
	}

	/**
	 * Removes the two factor configs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param twoFactorConfigsId the primary key of the two factor configs
	 * @return the two factor configs that was removed
	 * @throws NoSuchTwoFactorConfigsException if a two factor configs with the primary key could not be found
	 */
	public static TwoFactorConfigs remove(long twoFactorConfigsId)
		throws com.tokio.otp.exception.NoSuchTwoFactorConfigsException {

		return getPersistence().remove(twoFactorConfigsId);
	}

	public static TwoFactorConfigs updateImpl(
		TwoFactorConfigs twoFactorConfigs) {

		return getPersistence().updateImpl(twoFactorConfigs);
	}

	/**
	 * Returns the two factor configs with the primary key or throws a <code>NoSuchTwoFactorConfigsException</code> if it could not be found.
	 *
	 * @param twoFactorConfigsId the primary key of the two factor configs
	 * @return the two factor configs
	 * @throws NoSuchTwoFactorConfigsException if a two factor configs with the primary key could not be found
	 */
	public static TwoFactorConfigs findByPrimaryKey(long twoFactorConfigsId)
		throws com.tokio.otp.exception.NoSuchTwoFactorConfigsException {

		return getPersistence().findByPrimaryKey(twoFactorConfigsId);
	}

	/**
	 * Returns the two factor configs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param twoFactorConfigsId the primary key of the two factor configs
	 * @return the two factor configs, or <code>null</code> if a two factor configs with the primary key could not be found
	 */
	public static TwoFactorConfigs fetchByPrimaryKey(long twoFactorConfigsId) {
		return getPersistence().fetchByPrimaryKey(twoFactorConfigsId);
	}

	/**
	 * Returns all the two factor configses.
	 *
	 * @return the two factor configses
	 */
	public static List<TwoFactorConfigs> findAll() {
		return getPersistence().findAll();
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
	public static List<TwoFactorConfigs> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<TwoFactorConfigs> findAll(
		int start, int end,
		OrderByComparator<TwoFactorConfigs> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<TwoFactorConfigs> findAll(
		int start, int end,
		OrderByComparator<TwoFactorConfigs> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the two factor configses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of two factor configses.
	 *
	 * @return the number of two factor configses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TwoFactorConfigsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TwoFactorConfigsPersistence _persistence;

}