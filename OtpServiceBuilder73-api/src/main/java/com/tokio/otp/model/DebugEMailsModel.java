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

package com.tokio.otp.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the DebugEMails service. Represents a row in the &quot;OTP_DebugEMails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.tokio.otp.model.impl.DebugEMailsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.tokio.otp.model.impl.DebugEMailsImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DebugEMails
 * @generated
 */
@ProviderType
public interface DebugEMailsModel extends BaseModel<DebugEMails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a debug e mails model instance should use the {@link DebugEMails} interface instead.
	 */

	/**
	 * Returns the primary key of this debug e mails.
	 *
	 * @return the primary key of this debug e mails
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this debug e mails.
	 *
	 * @param primaryKey the primary key of this debug e mails
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the debug e mails ID of this debug e mails.
	 *
	 * @return the debug e mails ID of this debug e mails
	 */
	public long getDebugEMailsId();

	/**
	 * Sets the debug e mails ID of this debug e mails.
	 *
	 * @param debugEMailsId the debug e mails ID of this debug e mails
	 */
	public void setDebugEMailsId(long debugEMailsId);

	/**
	 * Returns the email of this debug e mails.
	 *
	 * @return the email of this debug e mails
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this debug e mails.
	 *
	 * @param email the email of this debug e mails
	 */
	public void setEmail(String email);

}