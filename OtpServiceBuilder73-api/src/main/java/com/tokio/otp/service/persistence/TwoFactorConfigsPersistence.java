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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.tokio.otp.exception.NoSuchTwoFactorConfigsException;
import com.tokio.otp.model.TwoFactorConfigs;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the two factor configs service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TwoFactorConfigsUtil
 * @generated
 */
@ProviderType
public interface TwoFactorConfigsPersistence
	extends BasePersistence<TwoFactorConfigs> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TwoFactorConfigsUtil} to access the two factor configs persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the two factor configs where configName = &#63; and companyId = &#63; or throws a <code>NoSuchTwoFactorConfigsException</code> if it could not be found.
	 *
	 * @param configName the config name
	 * @param companyId the company ID
	 * @return the matching two factor configs
	 * @throws NoSuchTwoFactorConfigsException if a matching two factor configs could not be found
	 */
	public TwoFactorConfigs findByConfigName(String configName, long companyId)
		throws NoSuchTwoFactorConfigsException;

	/**
	 * Returns the two factor configs where configName = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param configName the config name
	 * @param companyId the company ID
	 * @return the matching two factor configs, or <code>null</code> if a matching two factor configs could not be found
	 */
	public TwoFactorConfigs fetchByConfigName(
		String configName, long companyId);

	/**
	 * Returns the two factor configs where configName = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param configName the config name
	 * @param companyId the company ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching two factor configs, or <code>null</code> if a matching two factor configs could not be found
	 */
	public TwoFactorConfigs fetchByConfigName(
		String configName, long companyId, boolean useFinderCache);

	/**
	 * Removes the two factor configs where configName = &#63; and companyId = &#63; from the database.
	 *
	 * @param configName the config name
	 * @param companyId the company ID
	 * @return the two factor configs that was removed
	 */
	public TwoFactorConfigs removeByConfigName(
			String configName, long companyId)
		throws NoSuchTwoFactorConfigsException;

	/**
	 * Returns the number of two factor configses where configName = &#63; and companyId = &#63;.
	 *
	 * @param configName the config name
	 * @param companyId the company ID
	 * @return the number of matching two factor configses
	 */
	public int countByConfigName(String configName, long companyId);

	/**
	 * Caches the two factor configs in the entity cache if it is enabled.
	 *
	 * @param twoFactorConfigs the two factor configs
	 */
	public void cacheResult(TwoFactorConfigs twoFactorConfigs);

	/**
	 * Caches the two factor configses in the entity cache if it is enabled.
	 *
	 * @param twoFactorConfigses the two factor configses
	 */
	public void cacheResult(
		java.util.List<TwoFactorConfigs> twoFactorConfigses);

	/**
	 * Creates a new two factor configs with the primary key. Does not add the two factor configs to the database.
	 *
	 * @param twoFactorConfigsId the primary key for the new two factor configs
	 * @return the new two factor configs
	 */
	public TwoFactorConfigs create(long twoFactorConfigsId);

	/**
	 * Removes the two factor configs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param twoFactorConfigsId the primary key of the two factor configs
	 * @return the two factor configs that was removed
	 * @throws NoSuchTwoFactorConfigsException if a two factor configs with the primary key could not be found
	 */
	public TwoFactorConfigs remove(long twoFactorConfigsId)
		throws NoSuchTwoFactorConfigsException;

	public TwoFactorConfigs updateImpl(TwoFactorConfigs twoFactorConfigs);

	/**
	 * Returns the two factor configs with the primary key or throws a <code>NoSuchTwoFactorConfigsException</code> if it could not be found.
	 *
	 * @param twoFactorConfigsId the primary key of the two factor configs
	 * @return the two factor configs
	 * @throws NoSuchTwoFactorConfigsException if a two factor configs with the primary key could not be found
	 */
	public TwoFactorConfigs findByPrimaryKey(long twoFactorConfigsId)
		throws NoSuchTwoFactorConfigsException;

	/**
	 * Returns the two factor configs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param twoFactorConfigsId the primary key of the two factor configs
	 * @return the two factor configs, or <code>null</code> if a two factor configs with the primary key could not be found
	 */
	public TwoFactorConfigs fetchByPrimaryKey(long twoFactorConfigsId);

	/**
	 * Returns all the two factor configses.
	 *
	 * @return the two factor configses
	 */
	public java.util.List<TwoFactorConfigs> findAll();

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
	public java.util.List<TwoFactorConfigs> findAll(int start, int end);

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
	public java.util.List<TwoFactorConfigs> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TwoFactorConfigs>
			orderByComparator);

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
	public java.util.List<TwoFactorConfigs> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TwoFactorConfigs>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the two factor configses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of two factor configses.
	 *
	 * @return the number of two factor configses
	 */
	public int countAll();

}