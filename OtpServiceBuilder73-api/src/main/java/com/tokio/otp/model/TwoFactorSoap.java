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
public class TwoFactorSoap implements Serializable {

	public static TwoFactorSoap toSoapModel(TwoFactor model) {
		TwoFactorSoap soapModel = new TwoFactorSoap();

		soapModel.setTwoFactorId(model.getTwoFactorId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setVerificationType(model.getVerificationType());
		soapModel.setVerificationData(model.getVerificationData());
		soapModel.setExpirationDate(model.getExpirationDate());
		soapModel.setUsed(model.isUsed());
		soapModel.setDisabled(model.isDisabled());

		return soapModel;
	}

	public static TwoFactorSoap[] toSoapModels(TwoFactor[] models) {
		TwoFactorSoap[] soapModels = new TwoFactorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TwoFactorSoap[][] toSoapModels(TwoFactor[][] models) {
		TwoFactorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TwoFactorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TwoFactorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TwoFactorSoap[] toSoapModels(List<TwoFactor> models) {
		List<TwoFactorSoap> soapModels = new ArrayList<TwoFactorSoap>(
			models.size());

		for (TwoFactor model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TwoFactorSoap[soapModels.size()]);
	}

	public TwoFactorSoap() {
	}

	public long getPrimaryKey() {
		return _twoFactorId;
	}

	public void setPrimaryKey(long pk) {
		setTwoFactorId(pk);
	}

	public long getTwoFactorId() {
		return _twoFactorId;
	}

	public void setTwoFactorId(long twoFactorId) {
		_twoFactorId = twoFactorId;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getVerificationType() {
		return _verificationType;
	}

	public void setVerificationType(String verificationType) {
		_verificationType = verificationType;
	}

	public String getVerificationData() {
		return _verificationData;
	}

	public void setVerificationData(String verificationData) {
		_verificationData = verificationData;
	}

	public Date getExpirationDate() {
		return _expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		_expirationDate = expirationDate;
	}

	public boolean getUsed() {
		return _used;
	}

	public boolean isUsed() {
		return _used;
	}

	public void setUsed(boolean used) {
		_used = used;
	}

	public boolean getDisabled() {
		return _disabled;
	}

	public boolean isDisabled() {
		return _disabled;
	}

	public void setDisabled(boolean disabled) {
		_disabled = disabled;
	}

	private long _twoFactorId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _verificationType;
	private String _verificationData;
	private Date _expirationDate;
	private boolean _used;
	private boolean _disabled;

}