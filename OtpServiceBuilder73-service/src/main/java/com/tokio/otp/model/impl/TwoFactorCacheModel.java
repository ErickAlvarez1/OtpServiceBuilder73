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

package com.tokio.otp.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.tokio.otp.model.TwoFactor;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TwoFactor in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TwoFactorCacheModel
	implements CacheModel<TwoFactor>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TwoFactorCacheModel)) {
			return false;
		}

		TwoFactorCacheModel twoFactorCacheModel = (TwoFactorCacheModel)object;

		if (twoFactorId == twoFactorCacheModel.twoFactorId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, twoFactorId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{twoFactorId=");
		sb.append(twoFactorId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", verificationType=");
		sb.append(verificationType);
		sb.append(", verificationData=");
		sb.append(verificationData);
		sb.append(", expirationDate=");
		sb.append(expirationDate);
		sb.append(", used=");
		sb.append(used);
		sb.append(", disabled=");
		sb.append(disabled);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TwoFactor toEntityModel() {
		TwoFactorImpl twoFactorImpl = new TwoFactorImpl();

		twoFactorImpl.setTwoFactorId(twoFactorId);
		twoFactorImpl.setGroupId(groupId);
		twoFactorImpl.setCompanyId(companyId);
		twoFactorImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			twoFactorImpl.setCreateDate(null);
		}
		else {
			twoFactorImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			twoFactorImpl.setModifiedDate(null);
		}
		else {
			twoFactorImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (verificationType == null) {
			twoFactorImpl.setVerificationType("");
		}
		else {
			twoFactorImpl.setVerificationType(verificationType);
		}

		if (verificationData == null) {
			twoFactorImpl.setVerificationData("");
		}
		else {
			twoFactorImpl.setVerificationData(verificationData);
		}

		if (expirationDate == Long.MIN_VALUE) {
			twoFactorImpl.setExpirationDate(null);
		}
		else {
			twoFactorImpl.setExpirationDate(new Date(expirationDate));
		}

		twoFactorImpl.setUsed(used);
		twoFactorImpl.setDisabled(disabled);

		twoFactorImpl.resetOriginalValues();

		return twoFactorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		twoFactorId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		verificationType = objectInput.readUTF();
		verificationData = objectInput.readUTF();
		expirationDate = objectInput.readLong();

		used = objectInput.readBoolean();

		disabled = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(twoFactorId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (verificationType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(verificationType);
		}

		if (verificationData == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(verificationData);
		}

		objectOutput.writeLong(expirationDate);

		objectOutput.writeBoolean(used);

		objectOutput.writeBoolean(disabled);
	}

	public long twoFactorId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String verificationType;
	public String verificationData;
	public long expirationDate;
	public boolean used;
	public boolean disabled;

}