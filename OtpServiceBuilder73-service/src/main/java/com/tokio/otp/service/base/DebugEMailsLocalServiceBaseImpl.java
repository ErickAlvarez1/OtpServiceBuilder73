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

package com.tokio.otp.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import com.tokio.otp.model.DebugEMails;
import com.tokio.otp.service.DebugEMailsLocalService;
import com.tokio.otp.service.DebugEMailsLocalServiceUtil;
import com.tokio.otp.service.persistence.DebugEMailsPersistence;
import com.tokio.otp.service.persistence.TwoFactorConfigsPersistence;
import com.tokio.otp.service.persistence.TwoFactorPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the debug e mails local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.tokio.otp.service.impl.DebugEMailsLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.tokio.otp.service.impl.DebugEMailsLocalServiceImpl
 * @generated
 */
public abstract class DebugEMailsLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, DebugEMailsLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>DebugEMailsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>DebugEMailsLocalServiceUtil</code>.
	 */

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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DebugEMails addDebugEMails(DebugEMails debugEMails) {
		debugEMails.setNew(true);

		return debugEMailsPersistence.update(debugEMails);
	}

	/**
	 * Creates a new debug e mails with the primary key. Does not add the debug e mails to the database.
	 *
	 * @param debugEMailsId the primary key for the new debug e mails
	 * @return the new debug e mails
	 */
	@Override
	@Transactional(enabled = false)
	public DebugEMails createDebugEMails(long debugEMailsId) {
		return debugEMailsPersistence.create(debugEMailsId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DebugEMails deleteDebugEMails(long debugEMailsId)
		throws PortalException {

		return debugEMailsPersistence.remove(debugEMailsId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DebugEMails deleteDebugEMails(DebugEMails debugEMails) {
		return debugEMailsPersistence.remove(debugEMails);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			DebugEMails.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return debugEMailsPersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return debugEMailsPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return debugEMailsPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return debugEMailsPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return debugEMailsPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public DebugEMails fetchDebugEMails(long debugEMailsId) {
		return debugEMailsPersistence.fetchByPrimaryKey(debugEMailsId);
	}

	/**
	 * Returns the debug e mails with the primary key.
	 *
	 * @param debugEMailsId the primary key of the debug e mails
	 * @return the debug e mails
	 * @throws PortalException if a debug e mails with the primary key could not be found
	 */
	@Override
	public DebugEMails getDebugEMails(long debugEMailsId)
		throws PortalException {

		return debugEMailsPersistence.findByPrimaryKey(debugEMailsId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(debugEMailsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DebugEMails.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("debugEMailsId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			debugEMailsLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(DebugEMails.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"debugEMailsId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(debugEMailsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DebugEMails.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("debugEMailsId");
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return debugEMailsPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return debugEMailsLocalService.deleteDebugEMails(
			(DebugEMails)persistedModel);
	}

	public BasePersistence<DebugEMails> getBasePersistence() {
		return debugEMailsPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return debugEMailsPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<DebugEMails> getDebugEMailses(int start, int end) {
		return debugEMailsPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of debug e mailses.
	 *
	 * @return the number of debug e mailses
	 */
	@Override
	public int getDebugEMailsesCount() {
		return debugEMailsPersistence.countAll();
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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DebugEMails updateDebugEMails(DebugEMails debugEMails) {
		return debugEMailsPersistence.update(debugEMails);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			DebugEMailsLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		debugEMailsLocalService = (DebugEMailsLocalService)aopProxy;

		_setLocalServiceUtilService(debugEMailsLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DebugEMailsLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return DebugEMails.class;
	}

	protected String getModelClassName() {
		return DebugEMails.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = debugEMailsPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		DebugEMailsLocalService debugEMailsLocalService) {

		try {
			Field field = DebugEMailsLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, debugEMailsLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected DebugEMailsLocalService debugEMailsLocalService;

	@Reference
	protected DebugEMailsPersistence debugEMailsPersistence;

	@Reference
	protected TwoFactorPersistence twoFactorPersistence;

	@Reference
	protected TwoFactorConfigsPersistence twoFactorConfigsPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		DebugEMailsLocalServiceBaseImpl.class);

}