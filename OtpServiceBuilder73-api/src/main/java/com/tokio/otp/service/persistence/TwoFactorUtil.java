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

import com.tokio.otp.model.TwoFactor;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the two factor service. This utility wraps <code>com.tokio.otp.service.persistence.impl.TwoFactorPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TwoFactorPersistence
 * @generated
 */
public class TwoFactorUtil {

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
	public static void clearCache(TwoFactor twoFactor) {
		getPersistence().clearCache(twoFactor);
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
	public static Map<Serializable, TwoFactor> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TwoFactor> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TwoFactor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TwoFactor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TwoFactor> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TwoFactor update(TwoFactor twoFactor) {
		return getPersistence().update(twoFactor);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TwoFactor update(
		TwoFactor twoFactor, ServiceContext serviceContext) {

		return getPersistence().update(twoFactor, serviceContext);
	}

	/**
	 * Returns the two factor where userId = &#63; and companyId = &#63; or throws a <code>NoSuchTwoFactorException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching two factor
	 * @throws NoSuchTwoFactorException if a matching two factor could not be found
	 */
	public static TwoFactor findByUserIdAndCompanyId(
			long userId, long companyId)
		throws com.tokio.otp.exception.NoSuchTwoFactorException {

		return getPersistence().findByUserIdAndCompanyId(userId, companyId);
	}

	/**
	 * Returns the two factor where userId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching two factor, or <code>null</code> if a matching two factor could not be found
	 */
	public static TwoFactor fetchByUserIdAndCompanyId(
		long userId, long companyId) {

		return getPersistence().fetchByUserIdAndCompanyId(userId, companyId);
	}

	/**
	 * Returns the two factor where userId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching two factor, or <code>null</code> if a matching two factor could not be found
	 */
	public static TwoFactor fetchByUserIdAndCompanyId(
		long userId, long companyId, boolean useFinderCache) {

		return getPersistence().fetchByUserIdAndCompanyId(
			userId, companyId, useFinderCache);
	}

	/**
	 * Removes the two factor where userId = &#63; and companyId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the two factor that was removed
	 */
	public static TwoFactor removeByUserIdAndCompanyId(
			long userId, long companyId)
		throws com.tokio.otp.exception.NoSuchTwoFactorException {

		return getPersistence().removeByUserIdAndCompanyId(userId, companyId);
	}

	/**
	 * Returns the number of two factors where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the number of matching two factors
	 */
	public static int countByUserIdAndCompanyId(long userId, long companyId) {
		return getPersistence().countByUserIdAndCompanyId(userId, companyId);
	}

	/**
	 * Caches the two factor in the entity cache if it is enabled.
	 *
	 * @param twoFactor the two factor
	 */
	public static void cacheResult(TwoFactor twoFactor) {
		getPersistence().cacheResult(twoFactor);
	}

	/**
	 * Caches the two factors in the entity cache if it is enabled.
	 *
	 * @param twoFactors the two factors
	 */
	public static void cacheResult(List<TwoFactor> twoFactors) {
		getPersistence().cacheResult(twoFactors);
	}

	/**
	 * Creates a new two factor with the primary key. Does not add the two factor to the database.
	 *
	 * @param twoFactorId the primary key for the new two factor
	 * @return the new two factor
	 */
	public static TwoFactor create(long twoFactorId) {
		return getPersistence().create(twoFactorId);
	}

	/**
	 * Removes the two factor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param twoFactorId the primary key of the two factor
	 * @return the two factor that was removed
	 * @throws NoSuchTwoFactorException if a two factor with the primary key could not be found
	 */
	public static TwoFactor remove(long twoFactorId)
		throws com.tokio.otp.exception.NoSuchTwoFactorException {

		return getPersistence().remove(twoFactorId);
	}

	public static TwoFactor updateImpl(TwoFactor twoFactor) {
		return getPersistence().updateImpl(twoFactor);
	}

	/**
	 * Returns the two factor with the primary key or throws a <code>NoSuchTwoFactorException</code> if it could not be found.
	 *
	 * @param twoFactorId the primary key of the two factor
	 * @return the two factor
	 * @throws NoSuchTwoFactorException if a two factor with the primary key could not be found
	 */
	public static TwoFactor findByPrimaryKey(long twoFactorId)
		throws com.tokio.otp.exception.NoSuchTwoFactorException {

		return getPersistence().findByPrimaryKey(twoFactorId);
	}

	/**
	 * Returns the two factor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param twoFactorId the primary key of the two factor
	 * @return the two factor, or <code>null</code> if a two factor with the primary key could not be found
	 */
	public static TwoFactor fetchByPrimaryKey(long twoFactorId) {
		return getPersistence().fetchByPrimaryKey(twoFactorId);
	}

	/**
	 * Returns all the two factors.
	 *
	 * @return the two factors
	 */
	public static List<TwoFactor> findAll() {
		return getPersistence().findAll();
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
	public static List<TwoFactor> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<TwoFactor> findAll(
		int start, int end, OrderByComparator<TwoFactor> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<TwoFactor> findAll(
		int start, int end, OrderByComparator<TwoFactor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the two factors from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of two factors.
	 *
	 * @return the number of two factors
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TwoFactorPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TwoFactorPersistence _persistence;

}