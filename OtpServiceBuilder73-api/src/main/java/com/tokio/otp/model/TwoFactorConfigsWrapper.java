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
 * This class is a wrapper for {@link TwoFactorConfigs}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TwoFactorConfigs
 * @generated
 */
public class TwoFactorConfigsWrapper
	extends BaseModelWrapper<TwoFactorConfigs>
	implements ModelWrapper<TwoFactorConfigs>, TwoFactorConfigs {

	public TwoFactorConfigsWrapper(TwoFactorConfigs twoFactorConfigs) {
		super(twoFactorConfigs);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("twoFactorConfigsId", getTwoFactorConfigsId());
		attributes.put("configName", getConfigName());
		attributes.put("configValue", getConfigValue());
		attributes.put("configStatus", isConfigStatus());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long twoFactorConfigsId = (Long)attributes.get("twoFactorConfigsId");

		if (twoFactorConfigsId != null) {
			setTwoFactorConfigsId(twoFactorConfigsId);
		}

		String configName = (String)attributes.get("configName");

		if (configName != null) {
			setConfigName(configName);
		}

		String configValue = (String)attributes.get("configValue");

		if (configValue != null) {
			setConfigValue(configValue);
		}

		Boolean configStatus = (Boolean)attributes.get("configStatus");

		if (configStatus != null) {
			setConfigStatus(configStatus);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	 * Returns the company ID of this two factor configs.
	 *
	 * @return the company ID of this two factor configs
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the config name of this two factor configs.
	 *
	 * @return the config name of this two factor configs
	 */
	@Override
	public String getConfigName() {
		return model.getConfigName();
	}

	/**
	 * Returns the config status of this two factor configs.
	 *
	 * @return the config status of this two factor configs
	 */
	@Override
	public boolean getConfigStatus() {
		return model.getConfigStatus();
	}

	/**
	 * Returns the config value of this two factor configs.
	 *
	 * @return the config value of this two factor configs
	 */
	@Override
	public String getConfigValue() {
		return model.getConfigValue();
	}

	/**
	 * Returns the group ID of this two factor configs.
	 *
	 * @return the group ID of this two factor configs
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this two factor configs.
	 *
	 * @return the modified date of this two factor configs
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this two factor configs.
	 *
	 * @return the primary key of this two factor configs
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the two factor configs ID of this two factor configs.
	 *
	 * @return the two factor configs ID of this two factor configs
	 */
	@Override
	public long getTwoFactorConfigsId() {
		return model.getTwoFactorConfigsId();
	}

	/**
	 * Returns <code>true</code> if this two factor configs is config status.
	 *
	 * @return <code>true</code> if this two factor configs is config status; <code>false</code> otherwise
	 */
	@Override
	public boolean isConfigStatus() {
		return model.isConfigStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this two factor configs.
	 *
	 * @param companyId the company ID of this two factor configs
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the config name of this two factor configs.
	 *
	 * @param configName the config name of this two factor configs
	 */
	@Override
	public void setConfigName(String configName) {
		model.setConfigName(configName);
	}

	/**
	 * Sets whether this two factor configs is config status.
	 *
	 * @param configStatus the config status of this two factor configs
	 */
	@Override
	public void setConfigStatus(boolean configStatus) {
		model.setConfigStatus(configStatus);
	}

	/**
	 * Sets the config value of this two factor configs.
	 *
	 * @param configValue the config value of this two factor configs
	 */
	@Override
	public void setConfigValue(String configValue) {
		model.setConfigValue(configValue);
	}

	/**
	 * Sets the group ID of this two factor configs.
	 *
	 * @param groupId the group ID of this two factor configs
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this two factor configs.
	 *
	 * @param modifiedDate the modified date of this two factor configs
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this two factor configs.
	 *
	 * @param primaryKey the primary key of this two factor configs
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the two factor configs ID of this two factor configs.
	 *
	 * @param twoFactorConfigsId the two factor configs ID of this two factor configs
	 */
	@Override
	public void setTwoFactorConfigsId(long twoFactorConfigsId) {
		model.setTwoFactorConfigsId(twoFactorConfigsId);
	}

	@Override
	protected TwoFactorConfigsWrapper wrap(TwoFactorConfigs twoFactorConfigs) {
		return new TwoFactorConfigsWrapper(twoFactorConfigs);
	}

}