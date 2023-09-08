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

import com.tokio.otp.exception.NoSuchTwoFactorException;
import com.tokio.otp.model.TwoFactor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the two factor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TwoFactorUtil
 * @generated
 */
@ProviderType
public interface TwoFactorPersistence extends BasePersistence<TwoFactor> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TwoFactorUtil} to access the two factor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the two factor where userId = &#63; and companyId = &#63; or throws a <code>NoSuchTwoFactorException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching two factor
	 * @throws NoSuchTwoFactorException if a matching two factor could not be found
	 */
	public TwoFactor findByUserIdAndCompanyId(long userId, long companyId)
		throws NoSuchTwoFactorException;

	/**
	 * Returns the two factor where userId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching two factor, or <code>null</code> if a matching two factor could not be found
	 */
	public TwoFactor fetchByUserIdAndCompanyId(long userId, long companyId);

	/**
	 * Returns the two factor where userId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching two factor, or <code>null</code> if a matching two factor could not be found
	 */
	public TwoFactor fetchByUserIdAndCompanyId(
		long userId, long companyId, boolean useFinderCache);

	/**
	 * Removes the two factor where userId = &#63; and companyId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the two factor that was removed
	 */
	public TwoFactor removeByUserIdAndCompanyId(long userId, long companyId)
		throws NoSuchTwoFactorException;

	/**
	 * Returns the number of two factors where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the number of matching two factors
	 */
	public int countByUserIdAndCompanyId(long userId, long companyId);

	/**
	 * Caches the two factor in the entity cache if it is enabled.
	 *
	 * @param twoFactor the two factor
	 */
	public void cacheResult(TwoFactor twoFactor);

	/**
	 * Caches the two factors in the entity cache if it is enabled.
	 *
	 * @param twoFactors the two factors
	 */
	public void cacheResult(java.util.List<TwoFactor> twoFactors);

	/**
	 * Creates a new two factor with the primary key. Does not add the two factor to the database.
	 *
	 * @param twoFactorId the primary key for the new two factor
	 * @return the new two factor
	 */
	public TwoFactor create(long twoFactorId);

	/**
	 * Removes the two factor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param twoFactorId the primary key of the two factor
	 * @return the two factor that was removed
	 * @throws NoSuchTwoFactorException if a two factor with the primary key could not be found
	 */
	public TwoFactor remove(long twoFactorId) throws NoSuchTwoFactorException;

	public TwoFactor updateImpl(TwoFactor twoFactor);

	/**
	 * Returns the two factor with the primary key or throws a <code>NoSuchTwoFactorException</code> if it could not be found.
	 *
	 * @param twoFactorId the primary key of the two factor
	 * @return the two factor
	 * @throws NoSuchTwoFactorException if a two factor with the primary key could not be found
	 */
	public TwoFactor findByPrimaryKey(long twoFactorId)
		throws NoSuchTwoFactorException;

	/**
	 * Returns the two factor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param twoFactorId the primary key of the two factor
	 * @return the two factor, or <code>null</code> if a two factor with the primary key could not be found
	 */
	public TwoFactor fetchByPrimaryKey(long twoFactorId);

	/**
	 * Returns all the two factors.
	 *
	 * @return the two factors
	 */
	public java.util.List<TwoFactor> findAll();

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
	public java.util.List<TwoFactor> findAll(int start, int end);

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
	public java.util.List<TwoFactor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TwoFactor>
			orderByComparator);

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
	public java.util.List<TwoFactor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TwoFactor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the two factors from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of two factors.
	 *
	 * @return the number of two factors
	 */
	public int countAll();

}