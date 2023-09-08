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
 * Provides a wrapper for {@link TwoFactorConfigsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TwoFactorConfigsLocalService
 * @generated
 */
public class TwoFactorConfigsLocalServiceWrapper
	implements ServiceWrapper<TwoFactorConfigsLocalService>,
			   TwoFactorConfigsLocalService {

	public TwoFactorConfigsLocalServiceWrapper(
		TwoFactorConfigsLocalService twoFactorConfigsLocalService) {

		_twoFactorConfigsLocalService = twoFactorConfigsLocalService;
	}

	/**
	 * Adds the two factor configs to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TwoFactorConfigsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param twoFactorConfigs the two factor configs
	 * @return the two factor configs that was added
	 */
	@Override
	public com.tokio.otp.model.TwoFactorConfigs addTwoFactorConfigs(
		com.tokio.otp.model.TwoFactorConfigs twoFactorConfigs) {

		return _twoFactorConfigsLocalService.addTwoFactorConfigs(
			twoFactorConfigs);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _twoFactorConfigsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new two factor configs with the primary key. Does not add the two factor configs to the database.
	 *
	 * @param twoFactorConfigsId the primary key for the new two factor configs
	 * @return the new two factor configs
	 */
	@Override
	public com.tokio.otp.model.TwoFactorConfigs createTwoFactorConfigs(
		long twoFactorConfigsId) {

		return _twoFactorConfigsLocalService.createTwoFactorConfigs(
			twoFactorConfigsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _twoFactorConfigsLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the two factor configs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TwoFactorConfigsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param twoFactorConfigsId the primary key of the two factor configs
	 * @return the two factor configs that was removed
	 * @throws PortalException if a two factor configs with the primary key could not be found
	 */
	@Override
	public com.tokio.otp.model.TwoFactorConfigs deleteTwoFactorConfigs(
			long twoFactorConfigsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _twoFactorConfigsLocalService.deleteTwoFactorConfigs(
			twoFactorConfigsId);
	}

	/**
	 * Deletes the two factor configs from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TwoFactorConfigsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param twoFactorConfigs the two factor configs
	 * @return the two factor configs that was removed
	 */
	@Override
	public com.tokio.otp.model.TwoFactorConfigs deleteTwoFactorConfigs(
		com.tokio.otp.model.TwoFactorConfigs twoFactorConfigs) {

		return _twoFactorConfigsLocalService.deleteTwoFactorConfigs(
			twoFactorConfigs);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _twoFactorConfigsLocalService.dynamicQuery();
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

		return _twoFactorConfigsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokio.otp.model.impl.TwoFactorConfigsModelImpl</code>.
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

		return _twoFactorConfigsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokio.otp.model.impl.TwoFactorConfigsModelImpl</code>.
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

		return _twoFactorConfigsLocalService.dynamicQuery(
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

		return _twoFactorConfigsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _twoFactorConfigsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.tokio.otp.model.TwoFactorConfigs fetchTwoFactorConfigs(
		long twoFactorConfigsId) {

		return _twoFactorConfigsLocalService.fetchTwoFactorConfigs(
			twoFactorConfigsId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _twoFactorConfigsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _twoFactorConfigsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _twoFactorConfigsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _twoFactorConfigsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the two factor configs with the primary key.
	 *
	 * @param twoFactorConfigsId the primary key of the two factor configs
	 * @return the two factor configs
	 * @throws PortalException if a two factor configs with the primary key could not be found
	 */
	@Override
	public com.tokio.otp.model.TwoFactorConfigs getTwoFactorConfigs(
			long twoFactorConfigsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _twoFactorConfigsLocalService.getTwoFactorConfigs(
			twoFactorConfigsId);
	}

	/**
	 * Returns a range of all the two factor configses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokio.otp.model.impl.TwoFactorConfigsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of two factor configses
	 * @param end the upper bound of the range of two factor configses (not inclusive)
	 * @return the range of two factor configses
	 */
	@Override
	public java.util.List<com.tokio.otp.model.TwoFactorConfigs>
		getTwoFactorConfigses(int start, int end) {

		return _twoFactorConfigsLocalService.getTwoFactorConfigses(start, end);
	}

	/**
	 * Returns the number of two factor configses.
	 *
	 * @return the number of two factor configses
	 */
	@Override
	public int getTwoFactorConfigsesCount() {
		return _twoFactorConfigsLocalService.getTwoFactorConfigsesCount();
	}

	@Override
	public boolean isActiveConfig(
		String configName, long companyId, long groupId) {

		return _twoFactorConfigsLocalService.isActiveConfig(
			configName, companyId, groupId);
	}

	/**
	 * Updates the two factor configs in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TwoFactorConfigsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param twoFactorConfigs the two factor configs
	 * @return the two factor configs that was updated
	 */
	@Override
	public com.tokio.otp.model.TwoFactorConfigs updateTwoFactorConfigs(
		com.tokio.otp.model.TwoFactorConfigs twoFactorConfigs) {

		return _twoFactorConfigsLocalService.updateTwoFactorConfigs(
			twoFactorConfigs);
	}

	@Override
	public TwoFactorConfigsLocalService getWrappedService() {
		return _twoFactorConfigsLocalService;
	}

	@Override
	public void setWrappedService(
		TwoFactorConfigsLocalService twoFactorConfigsLocalService) {

		_twoFactorConfigsLocalService = twoFactorConfigsLocalService;
	}

	private TwoFactorConfigsLocalService _twoFactorConfigsLocalService;

}