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

import com.tokio.otp.model.TwoFactorConfigs;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TwoFactorConfigs in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TwoFactorConfigsCacheModel
	implements CacheModel<TwoFactorConfigs>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TwoFactorConfigsCacheModel)) {
			return false;
		}

		TwoFactorConfigsCacheModel twoFactorConfigsCacheModel =
			(TwoFactorConfigsCacheModel)object;

		if (twoFactorConfigsId ==
				twoFactorConfigsCacheModel.twoFactorConfigsId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, twoFactorConfigsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{twoFactorConfigsId=");
		sb.append(twoFactorConfigsId);
		sb.append(", configName=");
		sb.append(configName);
		sb.append(", configValue=");
		sb.append(configValue);
		sb.append(", configStatus=");
		sb.append(configStatus);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TwoFactorConfigs toEntityModel() {
		TwoFactorConfigsImpl twoFactorConfigsImpl = new TwoFactorConfigsImpl();

		twoFactorConfigsImpl.setTwoFactorConfigsId(twoFactorConfigsId);

		if (configName == null) {
			twoFactorConfigsImpl.setConfigName("");
		}
		else {
			twoFactorConfigsImpl.setConfigName(configName);
		}

		if (configValue == null) {
			twoFactorConfigsImpl.setConfigValue("");
		}
		else {
			twoFactorConfigsImpl.setConfigValue(configValue);
		}

		twoFactorConfigsImpl.setConfigStatus(configStatus);
		twoFactorConfigsImpl.setGroupId(groupId);
		twoFactorConfigsImpl.setCompanyId(companyId);

		if (modifiedDate == Long.MIN_VALUE) {
			twoFactorConfigsImpl.setModifiedDate(null);
		}
		else {
			twoFactorConfigsImpl.setModifiedDate(new Date(modifiedDate));
		}

		twoFactorConfigsImpl.resetOriginalValues();

		return twoFactorConfigsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		twoFactorConfigsId = objectInput.readLong();
		configName = objectInput.readUTF();
		configValue = objectInput.readUTF();

		configStatus = objectInput.readBoolean();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(twoFactorConfigsId);

		if (configName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(configName);
		}

		if (configValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(configValue);
		}

		objectOutput.writeBoolean(configStatus);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(modifiedDate);
	}

	public long twoFactorConfigsId;
	public String configName;
	public String configValue;
	public boolean configStatus;
	public long groupId;
	public long companyId;
	public long modifiedDate;

}