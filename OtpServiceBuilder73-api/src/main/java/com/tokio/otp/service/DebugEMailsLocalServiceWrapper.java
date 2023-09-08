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

package com.tokio.otp.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DebugEMailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DebugEMailsLocalService
 * @generated
 */
public class DebugEMailsLocalServiceWrapper
	implements DebugEMailsLocalService,
			   ServiceWrapper<DebugEMailsLocalService> {

	public DebugEMailsLocalServiceWrapper(
		DebugEMailsLocalService debugEMailsLocalService) {

		_debugEMailsLocalService = debugEMailsLocalService;
	}

	/**
	 * Adds the debug e mails to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DebugEMailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param debugEMails the debug e mails
	 * @return the debug e mails that was added
	 */
	@Override
	public com.tokio.otp.model.DebugEMails addDebugEMails(
		com.tokio.otp.model.DebugEMails debugEMails) {

		return _debugEMailsLocalService.addDebugEMails(debugEMails);
	}

	/**
	 * Creates a new debug e mails with the primary key. Does not add the debug e mails to the database.
	 *
	 * @param debugEMailsId the primary key for the new debug e mails
	 * @return the new debug e mails
	 */
	@Override
	public com.tokio.otp.model.DebugEMails createDebugEMails(
		long debugEMailsId) {

		return _debugEMailsLocalService.createDebugEMails(debugEMailsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _debugEMailsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the debug e mails from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DebugEMailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param debugEMails the debug e mails
	 * @return the debug e mails that was removed
	 */
	@Override
	public com.tokio.otp.model.DebugEMails deleteDebugEMails(
		com.tokio.otp.model.DebugEMails debugEMails) {

		return _debugEMailsLocalService.deleteDebugEMails(debugEMails);
	}

	/**
	 * Deletes the debug e mails with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DebugEMailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param debugEMailsId the primary key of the debug e mails
	 * @return the debug e mails that was removed
	 * @throws PortalException if a debug e mails with the primary key could not be found
	 */
	@Override
	public com.tokio.otp.model.DebugEMails deleteDebugEMails(long debugEMailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _debugEMailsLocalService.deleteDebugEMails(debugEMailsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _debugEMailsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _debugEMailsLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _debugEMailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokio.otp.model.impl.DebugEMailsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _debugEMailsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokio.otp.model.impl.DebugEMailsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _debugEMailsLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _debugEMailsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _debugEMailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public boolean existEMail(String email) {
		return _debugEMailsLocalService.existEMail(email);
	}

	@Override
	public com.tokio.otp.model.DebugEMails fetchDebugEMails(
		long debugEMailsId) {

		return _debugEMailsLocalService.fetchDebugEMails(debugEMailsId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _debugEMailsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the debug e mails with the primary key.
	 *
	 * @param debugEMailsId the primary key of the debug e mails
	 * @return the debug e mails
	 * @throws PortalException if a debug e mails with the primary key could not be found
	 */
	@Override
	public com.tokio.otp.model.DebugEMails getDebugEMails(long debugEMailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _debugEMailsLocalService.getDebugEMails(debugEMailsId);
	}

	/**
	 * Returns a range of all the debug e mailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokio.otp.model.impl.DebugEMailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of debug e mailses
	 * @param end the upper bound of the range of debug e mailses (not inclusive)
	 * @return the range of debug e mailses
	 */
	@Override
	public java.util.List<com.tokio.otp.model.DebugEMails> getDebugEMailses(
		int start, int end) {

		return _debugEMailsLocalService.getDebugEMailses(start, end);
	}

	/**
	 * Returns the number of debug e mailses.
	 *
	 * @return the number of debug e mailses
	 */
	@Override
	public int getDebugEMailsesCount() {
		return _debugEMailsLocalService.getDebugEMailsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _debugEMailsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _debugEMailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _debugEMailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the debug e mails in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DebugEMailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param debugEMails the debug e mails
	 * @return the debug e mails that was updated
	 */
	@Override
	public com.tokio.otp.model.DebugEMails updateDebugEMails(
		com.tokio.otp.model.DebugEMails debugEMails) {

		return _debugEMailsLocalService.updateDebugEMails(debugEMails);
	}

	@Override
	public DebugEMailsLocalService getWrappedService() {
		return _debugEMailsLocalService;
	}

	@Override
	public void setWrappedService(
		DebugEMailsLocalService debugEMailsLocalService) {

		_debugEMailsLocalService = debugEMailsLocalService;
	}

	private DebugEMailsLocalService _debugEMailsLocalService;

}