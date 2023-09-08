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

import com.tokio.otp.model.DebugEMails;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the debug e mails service. This utility wraps <code>com.tokio.otp.service.persistence.impl.DebugEMailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DebugEMailsPersistence
 * @generated
 */
public class DebugEMailsUtil {

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
	public static void clearCache(DebugEMails debugEMails) {
		getPersistence().clearCache(debugEMails);
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
	public static Map<Serializable, DebugEMails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DebugEMails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DebugEMails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DebugEMails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DebugEMails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DebugEMails update(DebugEMails debugEMails) {
		return getPersistence().update(debugEMails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DebugEMails update(
		DebugEMails debugEMails, ServiceContext serviceContext) {

		return getPersistence().update(debugEMails, serviceContext);
	}

	/**
	 * Returns the debug e mails where email = &#63; or throws a <code>NoSuchDebugEMailsException</code> if it could not be found.
	 *
	 * @param email the email
	 * @return the matching debug e mails
	 * @throws NoSuchDebugEMailsException if a matching debug e mails could not be found
	 */
	public static DebugEMails findByEmail(String email)
		throws com.tokio.otp.exception.NoSuchDebugEMailsException {

		return getPersistence().findByEmail(email);
	}

	/**
	 * Returns the debug e mails where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching debug e mails, or <code>null</code> if a matching debug e mails could not be found
	 */
	public static DebugEMails fetchByEmail(String email) {
		return getPersistence().fetchByEmail(email);
	}

	/**
	 * Returns the debug e mails where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching debug e mails, or <code>null</code> if a matching debug e mails could not be found
	 */
	public static DebugEMails fetchByEmail(
		String email, boolean useFinderCache) {

		return getPersistence().fetchByEmail(email, useFinderCache);
	}

	/**
	 * Removes the debug e mails where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the debug e mails that was removed
	 */
	public static DebugEMails removeByEmail(String email)
		throws com.tokio.otp.exception.NoSuchDebugEMailsException {

		return getPersistence().removeByEmail(email);
	}

	/**
	 * Returns the number of debug e mailses where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching debug e mailses
	 */
	public static int countByEmail(String email) {
		return getPersistence().countByEmail(email);
	}

	/**
	 * Caches the debug e mails in the entity cache if it is enabled.
	 *
	 * @param debugEMails the debug e mails
	 */
	public static void cacheResult(DebugEMails debugEMails) {
		getPersistence().cacheResult(debugEMails);
	}

	/**
	 * Caches the debug e mailses in the entity cache if it is enabled.
	 *
	 * @param debugEMailses the debug e mailses
	 */
	public static void cacheResult(List<DebugEMails> debugEMailses) {
		getPersistence().cacheResult(debugEMailses);
	}

	/**
	 * Creates a new debug e mails with the primary key. Does not add the debug e mails to the database.
	 *
	 * @param debugEMailsId the primary key for the new debug e mails
	 * @return the new debug e mails
	 */
	public static DebugEMails create(long debugEMailsId) {
		return getPersistence().create(debugEMailsId);
	}

	/**
	 * Removes the debug e mails with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param debugEMailsId the primary key of the debug e mails
	 * @return the debug e mails that was removed
	 * @throws NoSuchDebugEMailsException if a debug e mails with the primary key could not be found
	 */
	public static DebugEMails remove(long debugEMailsId)
		throws com.tokio.otp.exception.NoSuchDebugEMailsException {

		return getPersistence().remove(debugEMailsId);
	}

	public static DebugEMails updateImpl(DebugEMails debugEMails) {
		return getPersistence().updateImpl(debugEMails);
	}

	/**
	 * Returns the debug e mails with the primary key or throws a <code>NoSuchDebugEMailsException</code> if it could not be found.
	 *
	 * @param debugEMailsId the primary key of the debug e mails
	 * @return the debug e mails
	 * @throws NoSuchDebugEMailsException if a debug e mails with the primary key could not be found
	 */
	public static DebugEMails findByPrimaryKey(long debugEMailsId)
		throws com.tokio.otp.exception.NoSuchDebugEMailsException {

		return getPersistence().findByPrimaryKey(debugEMailsId);
	}

	/**
	 * Returns the debug e mails with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param debugEMailsId the primary key of the debug e mails
	 * @return the debug e mails, or <code>null</code> if a debug e mails with the primary key could not be found
	 */
	public static DebugEMails fetchByPrimaryKey(long debugEMailsId) {
		return getPersistence().fetchByPrimaryKey(debugEMailsId);
	}

	/**
	 * Returns all the debug e mailses.
	 *
	 * @return the debug e mailses
	 */
	public static List<DebugEMails> findAll() {
		return getPersistence().findAll();
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
	public static List<DebugEMails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<DebugEMails> findAll(
		int start, int end, OrderByComparator<DebugEMails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<DebugEMails> findAll(
		int start, int end, OrderByComparator<DebugEMails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the debug e mailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of debug e mailses.
	 *
	 * @return the number of debug e mailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DebugEMailsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DebugEMailsPersistence _persistence;

}