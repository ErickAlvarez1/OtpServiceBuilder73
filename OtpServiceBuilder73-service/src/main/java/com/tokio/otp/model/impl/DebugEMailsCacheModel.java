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

import com.tokio.otp.model.DebugEMails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DebugEMails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DebugEMailsCacheModel
	implements CacheModel<DebugEMails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DebugEMailsCacheModel)) {
			return false;
		}

		DebugEMailsCacheModel debugEMailsCacheModel =
			(DebugEMailsCacheModel)object;

		if (debugEMailsId == debugEMailsCacheModel.debugEMailsId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, debugEMailsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{debugEMailsId=");
		sb.append(debugEMailsId);
		sb.append(", email=");
		sb.append(email);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DebugEMails toEntityModel() {
		DebugEMailsImpl debugEMailsImpl = new DebugEMailsImpl();

		debugEMailsImpl.setDebugEMailsId(debugEMailsId);

		if (email == null) {
			debugEMailsImpl.setEmail("");
		}
		else {
			debugEMailsImpl.setEmail(email);
		}

		debugEMailsImpl.resetOriginalValues();

		return debugEMailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		debugEMailsId = objectInput.readLong();
		email = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(debugEMailsId);

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}
	}

	public long debugEMailsId;
	public String email;

}