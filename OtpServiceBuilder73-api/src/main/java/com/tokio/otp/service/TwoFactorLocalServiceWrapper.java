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
 * Provides a wrapper for {@link TwoFactorLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TwoFactorLocalService
 * @generated
 */
public class TwoFactorLocalServiceWrapper
	implements ServiceWrapper<TwoFactorLocalService>, TwoFactorLocalService {

	public TwoFactorLocalServiceWrapper(
		TwoFactorLocalService twoFactorLocalService) {

		_twoFactorLocalService = twoFactorLocalService;
	}

	/**
	 * Adds the two factor to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TwoFactorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param twoFactor the two factor
	 * @return the two factor that was added
	 */
	@Override
	public com.tokio.otp.model.TwoFactor addTwoFactor(
		com.tokio.otp.model.TwoFactor twoFactor) {

		return _twoFactorLocalService.addTwoFactor(twoFactor);
	}

	@Override
	public com.tokio.otp.model.TwoFactor addTwoFactorUser(
		long userId, long companyId, long groupId) {

		return _twoFactorLocalService.addTwoFactorUser(
			userId, companyId, groupId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _twoFactorLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new two factor with the primary key. Does not add the two factor to the database.
	 *
	 * @param twoFactorId the primary key for the new two factor
	 * @return the new two factor
	 */
	@Override
	public com.tokio.otp.model.TwoFactor createTwoFactor(long twoFactorId) {
		return _twoFactorLocalService.createTwoFactor(twoFactorId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _twoFactorLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the two factor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TwoFactorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param twoFactorId the primary key of the two factor
	 * @return the two factor that was removed
	 * @throws PortalException if a two factor with the primary key could not be found
	 */
	@Override
	public com.tokio.otp.model.TwoFactor deleteTwoFactor(long twoFactorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _twoFactorLocalService.deleteTwoFactor(twoFactorId);
	}

	/**
	 * Deletes the two factor from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TwoFactorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param twoFactor the two factor
	 * @return the two factor that was removed
	 */
	@Override
	public com.tokio.otp.model.TwoFactor deleteTwoFactor(
		com.tokio.otp.model.TwoFactor twoFactor) {

		return _twoFactorLocalService.deleteTwoFactor(twoFactor);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _twoFactorLocalService.dynamicQuery();
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

		return _twoFactorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokio.otp.model.impl.TwoFactorModelImpl</code>.
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

		return _twoFactorLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokio.otp.model.impl.TwoFactorModelImpl</code>.
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

		return _twoFactorLocalService.dynamicQuery(
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

		return _twoFactorLocalService.dynamicQueryCount(dynamicQuery);
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

		return _twoFactorLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.tokio.otp.model.TwoFactor fetchTwoFactor(long twoFactorId) {
		return _twoFactorLocalService.fetchTwoFactor(twoFactorId);
	}

	@Override
	public com.tokio.otp.model.TwoFactor generateToken(
		long userId, long companyId, long groupId, int expirationMinutes) {

		return _twoFactorLocalService.generateToken(
			userId, companyId, groupId, expirationMinutes);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _twoFactorLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _twoFactorLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _twoFactorLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _twoFactorLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.tokio.otp.model.TwoFactor getTokenByUsuario(
		long userId, long companyId, long groupId) {

		return _twoFactorLocalService.getTokenByUsuario(
			userId, companyId, groupId);
	}

	/**
	 * Returns the two factor with the primary key.
	 *
	 * @param twoFactorId the primary key of the two factor
	 * @return the two factor
	 * @throws PortalException if a two factor with the primary key could not be found
	 */
	@Override
	public com.tokio.otp.model.TwoFactor getTwoFactor(long twoFactorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _twoFactorLocalService.getTwoFactor(twoFactorId);
	}

	/**
	 * Returns a range of all the two factors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tokio.otp.model.impl.TwoFactorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of two factors
	 * @param end the upper bound of the range of two factors (not inclusive)
	 * @return the range of two factors
	 */
	@Override
	public java.util.List<com.tokio.otp.model.TwoFactor> getTwoFactors(
		int start, int end) {

		return _twoFactorLocalService.getTwoFactors(start, end);
	}

	/**
	 * Returns the number of two factors.
	 *
	 * @return the number of two factors
	 */
	@Override
	public int getTwoFactorsCount() {
		return _twoFactorLocalService.getTwoFactorsCount();
	}

	@Override
	public com.tokio.otp.model.TwoFactor updateTokenUser(
		long twoFactorId, String token, int expirationMinutes) {

		return _twoFactorLocalService.updateTokenUser(
			twoFactorId, token, expirationMinutes);
	}

	/**
	 * Updates the two factor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TwoFactorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param twoFactor the two factor
	 * @return the two factor that was updated
	 */
	@Override
	public com.tokio.otp.model.TwoFactor updateTwoFactor(
		com.tokio.otp.model.TwoFactor twoFactor) {

		return _twoFactorLocalService.updateTwoFactor(twoFactor);
	}

	@Override
	public TwoFactorLocalService getWrappedService() {
		return _twoFactorLocalService;
	}

	@Override
	public void setWrappedService(TwoFactorLocalService twoFactorLocalService) {
		_twoFactorLocalService = twoFactorLocalService;
	}

	private TwoFactorLocalService _twoFactorLocalService;

}