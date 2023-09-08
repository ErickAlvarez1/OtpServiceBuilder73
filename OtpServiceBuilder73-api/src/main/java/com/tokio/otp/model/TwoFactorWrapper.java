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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TwoFactor}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TwoFactor
 * @generated
 */
public class TwoFactorWrapper
	extends BaseModelWrapper<TwoFactor>
	implements ModelWrapper<TwoFactor>, TwoFactor {

	public TwoFactorWrapper(TwoFactor twoFactor) {
		super(twoFactor);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("twoFactorId", getTwoFactorId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("verificationType", getVerificationType());
		attributes.put("verificationData", getVerificationData());
		attributes.put("expirationDate", getExpirationDate());
		attributes.put("used", isUsed());
		attributes.put("disabled", isDisabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long twoFactorId = (Long)attributes.get("twoFactorId");

		if (twoFactorId != null) {
			setTwoFactorId(twoFactorId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String verificationType = (String)attributes.get("verificationType");

		if (verificationType != null) {
			setVerificationType(verificationType);
		}

		String verificationData = (String)attributes.get("verificationData");

		if (verificationData != null) {
			setVerificationData(verificationData);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
		}

		Boolean used = (Boolean)attributes.get("used");

		if (used != null) {
			setUsed(used);
		}

		Boolean disabled = (Boolean)attributes.get("disabled");

		if (disabled != null) {
			setDisabled(disabled);
		}
	}

	/**
	 * Returns the company ID of this two factor.
	 *
	 * @return the company ID of this two factor
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this two factor.
	 *
	 * @return the create date of this two factor
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the disabled of this two factor.
	 *
	 * @return the disabled of this two factor
	 */
	@Override
	public boolean getDisabled() {
		return model.getDisabled();
	}

	/**
	 * Returns the expiration date of this two factor.
	 *
	 * @return the expiration date of this two factor
	 */
	@Override
	public Date getExpirationDate() {
		return model.getExpirationDate();
	}

	/**
	 * Returns the group ID of this two factor.
	 *
	 * @return the group ID of this two factor
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this two factor.
	 *
	 * @return the modified date of this two factor
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this two factor.
	 *
	 * @return the primary key of this two factor
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the two factor ID of this two factor.
	 *
	 * @return the two factor ID of this two factor
	 */
	@Override
	public long getTwoFactorId() {
		return model.getTwoFactorId();
	}

	/**
	 * Returns the used of this two factor.
	 *
	 * @return the used of this two factor
	 */
	@Override
	public boolean getUsed() {
		return model.getUsed();
	}

	/**
	 * Returns the user ID of this two factor.
	 *
	 * @return the user ID of this two factor
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this two factor.
	 *
	 * @return the user uuid of this two factor
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the verification data of this two factor.
	 *
	 * @return the verification data of this two factor
	 */
	@Override
	public String getVerificationData() {
		return model.getVerificationData();
	}

	/**
	 * Returns the verification type of this two factor.
	 *
	 * @return the verification type of this two factor
	 */
	@Override
	public String getVerificationType() {
		return model.getVerificationType();
	}

	/**
	 * Returns <code>true</code> if this two factor is disabled.
	 *
	 * @return <code>true</code> if this two factor is disabled; <code>false</code> otherwise
	 */
	@Override
	public boolean isDisabled() {
		return model.isDisabled();
	}

	/**
	 * Returns <code>true</code> if this two factor is used.
	 *
	 * @return <code>true</code> if this two factor is used; <code>false</code> otherwise
	 */
	@Override
	public boolean isUsed() {
		return model.isUsed();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this two factor.
	 *
	 * @param companyId the company ID of this two factor
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this two factor.
	 *
	 * @param createDate the create date of this two factor
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this two factor is disabled.
	 *
	 * @param disabled the disabled of this two factor
	 */
	@Override
	public void setDisabled(boolean disabled) {
		model.setDisabled(disabled);
	}

	/**
	 * Sets the expiration date of this two factor.
	 *
	 * @param expirationDate the expiration date of this two factor
	 */
	@Override
	public void setExpirationDate(Date expirationDate) {
		model.setExpirationDate(expirationDate);
	}

	/**
	 * Sets the group ID of this two factor.
	 *
	 * @param groupId the group ID of this two factor
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this two factor.
	 *
	 * @param modifiedDate the modified date of this two factor
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this two factor.
	 *
	 * @param primaryKey the primary key of this two factor
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the two factor ID of this two factor.
	 *
	 * @param twoFactorId the two factor ID of this two factor
	 */
	@Override
	public void setTwoFactorId(long twoFactorId) {
		model.setTwoFactorId(twoFactorId);
	}

	/**
	 * Sets whether this two factor is used.
	 *
	 * @param used the used of this two factor
	 */
	@Override
	public void setUsed(boolean used) {
		model.setUsed(used);
	}

	/**
	 * Sets the user ID of this two factor.
	 *
	 * @param userId the user ID of this two factor
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this two factor.
	 *
	 * @param userUuid the user uuid of this two factor
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the verification data of this two factor.
	 *
	 * @param verificationData the verification data of this two factor
	 */
	@Override
	public void setVerificationData(String verificationData) {
		model.setVerificationData(verificationData);
	}

	/**
	 * Sets the verification type of this two factor.
	 *
	 * @param verificationType the verification type of this two factor
	 */
	@Override
	public void setVerificationType(String verificationType) {
		model.setVerificationType(verificationType);
	}

	@Override
	protected TwoFactorWrapper wrap(TwoFactor twoFactor) {
		return new TwoFactorWrapper(twoFactor);
	}

}