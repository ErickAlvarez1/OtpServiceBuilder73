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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class TwoFactorConfigsSoap implements Serializable {

	public static TwoFactorConfigsSoap toSoapModel(TwoFactorConfigs model) {
		TwoFactorConfigsSoap soapModel = new TwoFactorConfigsSoap();

		soapModel.setTwoFactorConfigsId(model.getTwoFactorConfigsId());
		soapModel.setConfigName(model.getConfigName());
		soapModel.setConfigValue(model.getConfigValue());
		soapModel.setConfigStatus(model.isConfigStatus());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static TwoFactorConfigsSoap[] toSoapModels(
		TwoFactorConfigs[] models) {

		TwoFactorConfigsSoap[] soapModels =
			new TwoFactorConfigsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TwoFactorConfigsSoap[][] toSoapModels(
		TwoFactorConfigs[][] models) {

		TwoFactorConfigsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TwoFactorConfigsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TwoFactorConfigsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TwoFactorConfigsSoap[] toSoapModels(
		List<TwoFactorConfigs> models) {

		List<TwoFactorConfigsSoap> soapModels =
			new ArrayList<TwoFactorConfigsSoap>(models.size());

		for (TwoFactorConfigs model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TwoFactorConfigsSoap[soapModels.size()]);
	}

	public TwoFactorConfigsSoap() {
	}

	public long getPrimaryKey() {
		return _twoFactorConfigsId;
	}

	public void setPrimaryKey(long pk) {
		setTwoFactorConfigsId(pk);
	}

	public long getTwoFactorConfigsId() {
		return _twoFactorConfigsId;
	}

	public void setTwoFactorConfigsId(long twoFactorConfigsId) {
		_twoFactorConfigsId = twoFactorConfigsId;
	}

	public String getConfigName() {
		return _configName;
	}

	public void setConfigName(String configName) {
		_configName = configName;
	}

	public String getConfigValue() {
		return _configValue;
	}

	public void setConfigValue(String configValue) {
		_configValue = configValue;
	}

	public boolean getConfigStatus() {
		return _configStatus;
	}

	public boolean isConfigStatus() {
		return _configStatus;
	}

	public void setConfigStatus(boolean configStatus) {
		_configStatus = configStatus;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _twoFactorConfigsId;
	private String _configName;
	private String _configValue;
	private boolean _configStatus;
	private long _groupId;
	private long _companyId;
	private Date _modifiedDate;

}