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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class DebugEMailsSoap implements Serializable {

	public static DebugEMailsSoap toSoapModel(DebugEMails model) {
		DebugEMailsSoap soapModel = new DebugEMailsSoap();

		soapModel.setDebugEMailsId(model.getDebugEMailsId());
		soapModel.setEmail(model.getEmail());

		return soapModel;
	}

	public static DebugEMailsSoap[] toSoapModels(DebugEMails[] models) {
		DebugEMailsSoap[] soapModels = new DebugEMailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DebugEMailsSoap[][] toSoapModels(DebugEMails[][] models) {
		DebugEMailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DebugEMailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DebugEMailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DebugEMailsSoap[] toSoapModels(List<DebugEMails> models) {
		List<DebugEMailsSoap> soapModels = new ArrayList<DebugEMailsSoap>(
			models.size());

		for (DebugEMails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DebugEMailsSoap[soapModels.size()]);
	}

	public DebugEMailsSoap() {
	}

	public long getPrimaryKey() {
		return _debugEMailsId;
	}

	public void setPrimaryKey(long pk) {
		setDebugEMailsId(pk);
	}

	public long getDebugEMailsId() {
		return _debugEMailsId;
	}

	public void setDebugEMailsId(long debugEMailsId) {
		_debugEMailsId = debugEMailsId;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	private long _debugEMailsId;
	private String _email;

}