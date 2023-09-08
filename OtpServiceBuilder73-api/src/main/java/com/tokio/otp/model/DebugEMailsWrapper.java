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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DebugEMails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DebugEMails
 * @generated
 */
public class DebugEMailsWrapper
	extends BaseModelWrapper<DebugEMails>
	implements DebugEMails, ModelWrapper<DebugEMails> {

	public DebugEMailsWrapper(DebugEMails debugEMails) {
		super(debugEMails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("debugEMailsId", getDebugEMailsId());
		attributes.put("email", getEmail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long debugEMailsId = (Long)attributes.get("debugEMailsId");

		if (debugEMailsId != null) {
			setDebugEMailsId(debugEMailsId);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}
	}

	/**
	 * Returns the debug e mails ID of this debug e mails.
	 *
	 * @return the debug e mails ID of this debug e mails
	 */
	@Override
	public long getDebugEMailsId() {
		return model.getDebugEMailsId();
	}

	/**
	 * Returns the email of this debug e mails.
	 *
	 * @return the email of this debug e mails
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the primary key of this debug e mails.
	 *
	 * @return the primary key of this debug e mails
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the debug e mails ID of this debug e mails.
	 *
	 * @param debugEMailsId the debug e mails ID of this debug e mails
	 */
	@Override
	public void setDebugEMailsId(long debugEMailsId) {
		model.setDebugEMailsId(debugEMailsId);
	}

	/**
	 * Sets the email of this debug e mails.
	 *
	 * @param email the email of this debug e mails
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the primary key of this debug e mails.
	 *
	 * @param primaryKey the primary key of this debug e mails
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected DebugEMailsWrapper wrap(DebugEMails debugEMails) {
		return new DebugEMailsWrapper(debugEMails);
	}

}