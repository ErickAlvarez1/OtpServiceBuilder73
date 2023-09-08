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

import com.tokio.otp.exception.NoSuchDebugEMailsException;
import com.tokio.otp.model.DebugEMails;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the debug e mails service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DebugEMailsUtil
 * @generated
 */
@ProviderType
public interface DebugEMailsPersistence extends BasePersistence<DebugEMails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DebugEMailsUtil} to access the debug e mails persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the debug e mails where email = &#63; or throws a <code>NoSuchDebugEMailsException</code> if it could not be found.
	 *
	 * @param email the email
	 * @return the matching debug e mails
	 * @throws NoSuchDebugEMailsException if a matching debug e mails could not be found
	 */
	public DebugEMails findByEmail(String email)
		throws NoSuchDebugEMailsException;

	/**
	 * Returns the debug e mails where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching debug e mails, or <code>null</code> if a matching debug e mails could not be found
	 */
	public DebugEMails fetchByEmail(String email);

	/**
	 * Returns the debug e mails where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching debug e mails, or <code>null</code> if a matching debug e mails could not be found
	 */
	public DebugEMails fetchByEmail(String email, boolean useFinderCache);

	/**
	 * Removes the debug e mails where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the debug e mails that was removed
	 */
	public DebugEMails removeByEmail(String email)
		throws NoSuchDebugEMailsException;

	/**
	 * Returns the number of debug e mailses where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching debug e mailses
	 */
	public int countByEmail(String email);

	/**
	 * Caches the debug e mails in the entity cache if it is enabled.
	 *
	 * @param debugEMails the debug e mails
	 */
	public void cacheResult(DebugEMails debugEMails);

	/**
	 * Caches the debug e mailses in the entity cache if it is enabled.
	 *
	 * @param debugEMailses the debug e mailses
	 */
	public void cacheResult(java.util.List<DebugEMails> debugEMailses);

	/**
	 * Creates a new debug e mails with the primary key. Does not add the debug e mails to the database.
	 *
	 * @param debugEMailsId the primary key for the new debug e mails
	 * @return the new debug e mails
	 */
	public DebugEMails create(long debugEMailsId);

	/**
	 * Removes the debug e mails with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param debugEMailsId the primary key of the debug e mails
	 * @return the debug e mails that was removed
	 * @throws NoSuchDebugEMailsException if a debug e mails with the primary key could not be found
	 */
	public DebugEMails remove(long debugEMailsId)
		throws NoSuchDebugEMailsException;

	public DebugEMails updateImpl(DebugEMails debugEMails);

	/**
	 * Returns the debug e mails with the primary key or throws a <code>NoSuchDebugEMailsException</code> if it could not be found.
	 *
	 * @param debugEMailsId the primary key of the debug e mails
	 * @return the debug e mails
	 * @throws NoSuchDebugEMailsException if a debug e mails with the primary key could not be found
	 */
	public DebugEMails findByPrimaryKey(long debugEMailsId)
		throws NoSuchDebugEMailsException;

	/**
	 * Returns the debug e mails with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param debugEMailsId the primary key of the debug e mails
	 * @return the debug e mails, or <code>null</code> if a debug e mails with the primary key could not be found
	 */
	public DebugEMails fetchByPrimaryKey(long debugEMailsId);

	/**
	 * Returns all the debug e mailses.
	 *
	 * @return the debug e mailses
	 */
	public java.util.List<DebugEMails> findAll();

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
	public java.util.List<DebugEMails> findAll(int start, int end);

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
	public java.util.List<DebugEMails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DebugEMails>
			orderByComparator);

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
	public java.util.List<DebugEMails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DebugEMails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the debug e mailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of debug e mailses.
	 *
	 * @return the number of debug e mailses
	 */
	public int countAll();

}