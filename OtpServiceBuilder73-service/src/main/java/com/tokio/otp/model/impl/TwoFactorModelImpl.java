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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.tokio.otp.model.TwoFactor;
import com.tokio.otp.model.TwoFactorModel;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the TwoFactor service. Represents a row in the &quot;OTP_TwoFactor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>TwoFactorModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TwoFactorImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TwoFactorImpl
 * @generated
 */
public class TwoFactorModelImpl
	extends BaseModelImpl<TwoFactor> implements TwoFactorModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a two factor model instance should use the <code>TwoFactor</code> interface instead.
	 */
	public static final String TABLE_NAME = "OTP_TwoFactor";

	public static final Object[][] TABLE_COLUMNS = {
		{"twoFactorId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"verificationType", Types.VARCHAR},
		{"verificationData", Types.VARCHAR},
		{"expirationDate", Types.TIMESTAMP}, {"used", Types.BOOLEAN},
		{"disabled", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("twoFactorId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("verificationType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("verificationData", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("expirationDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("used", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("disabled", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table OTP_TwoFactor (twoFactorId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,verificationType VARCHAR(75) null,verificationData VARCHAR(75) null,expirationDate DATE null,used BOOLEAN,disabled BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table OTP_TwoFactor";

	public static final String ORDER_BY_JPQL =
		" ORDER BY twoFactor.twoFactorId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY OTP_TwoFactor.twoFactorId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TWOFACTORID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public TwoFactorModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _twoFactorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTwoFactorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _twoFactorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TwoFactor.class;
	}

	@Override
	public String getModelClassName() {
		return TwoFactor.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<TwoFactor, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<TwoFactor, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TwoFactor, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((TwoFactor)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<TwoFactor, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<TwoFactor, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(TwoFactor)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<TwoFactor, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TwoFactor, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<TwoFactor, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<TwoFactor, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<TwoFactor, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<TwoFactor, Object>>();
		Map<String, BiConsumer<TwoFactor, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<TwoFactor, ?>>();

		attributeGetterFunctions.put("twoFactorId", TwoFactor::getTwoFactorId);
		attributeSetterBiConsumers.put(
			"twoFactorId",
			(BiConsumer<TwoFactor, Long>)TwoFactor::setTwoFactorId);
		attributeGetterFunctions.put("groupId", TwoFactor::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<TwoFactor, Long>)TwoFactor::setGroupId);
		attributeGetterFunctions.put("companyId", TwoFactor::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<TwoFactor, Long>)TwoFactor::setCompanyId);
		attributeGetterFunctions.put("userId", TwoFactor::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<TwoFactor, Long>)TwoFactor::setUserId);
		attributeGetterFunctions.put("createDate", TwoFactor::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<TwoFactor, Date>)TwoFactor::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", TwoFactor::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<TwoFactor, Date>)TwoFactor::setModifiedDate);
		attributeGetterFunctions.put(
			"verificationType", TwoFactor::getVerificationType);
		attributeSetterBiConsumers.put(
			"verificationType",
			(BiConsumer<TwoFactor, String>)TwoFactor::setVerificationType);
		attributeGetterFunctions.put(
			"verificationData", TwoFactor::getVerificationData);
		attributeSetterBiConsumers.put(
			"verificationData",
			(BiConsumer<TwoFactor, String>)TwoFactor::setVerificationData);
		attributeGetterFunctions.put(
			"expirationDate", TwoFactor::getExpirationDate);
		attributeSetterBiConsumers.put(
			"expirationDate",
			(BiConsumer<TwoFactor, Date>)TwoFactor::setExpirationDate);
		attributeGetterFunctions.put("used", TwoFactor::getUsed);
		attributeSetterBiConsumers.put(
			"used", (BiConsumer<TwoFactor, Boolean>)TwoFactor::setUsed);
		attributeGetterFunctions.put("disabled", TwoFactor::getDisabled);
		attributeSetterBiConsumers.put(
			"disabled", (BiConsumer<TwoFactor, Boolean>)TwoFactor::setDisabled);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getTwoFactorId() {
		return _twoFactorId;
	}

	@Override
	public void setTwoFactorId(long twoFactorId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_twoFactorId = twoFactorId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalUserId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("userId"));
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getVerificationType() {
		if (_verificationType == null) {
			return "";
		}
		else {
			return _verificationType;
		}
	}

	@Override
	public void setVerificationType(String verificationType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_verificationType = verificationType;
	}

	@Override
	public String getVerificationData() {
		if (_verificationData == null) {
			return "";
		}
		else {
			return _verificationData;
		}
	}

	@Override
	public void setVerificationData(String verificationData) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_verificationData = verificationData;
	}

	@Override
	public Date getExpirationDate() {
		return _expirationDate;
	}

	@Override
	public void setExpirationDate(Date expirationDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_expirationDate = expirationDate;
	}

	@Override
	public boolean getUsed() {
		return _used;
	}

	@Override
	public boolean isUsed() {
		return _used;
	}

	@Override
	public void setUsed(boolean used) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_used = used;
	}

	@Override
	public boolean getDisabled() {
		return _disabled;
	}

	@Override
	public boolean isDisabled() {
		return _disabled;
	}

	@Override
	public void setDisabled(boolean disabled) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_disabled = disabled;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), TwoFactor.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TwoFactor toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, TwoFactor>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TwoFactorImpl twoFactorImpl = new TwoFactorImpl();

		twoFactorImpl.setTwoFactorId(getTwoFactorId());
		twoFactorImpl.setGroupId(getGroupId());
		twoFactorImpl.setCompanyId(getCompanyId());
		twoFactorImpl.setUserId(getUserId());
		twoFactorImpl.setCreateDate(getCreateDate());
		twoFactorImpl.setModifiedDate(getModifiedDate());
		twoFactorImpl.setVerificationType(getVerificationType());
		twoFactorImpl.setVerificationData(getVerificationData());
		twoFactorImpl.setExpirationDate(getExpirationDate());
		twoFactorImpl.setUsed(isUsed());
		twoFactorImpl.setDisabled(isDisabled());

		twoFactorImpl.resetOriginalValues();

		return twoFactorImpl;
	}

	@Override
	public int compareTo(TwoFactor twoFactor) {
		long primaryKey = twoFactor.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TwoFactor)) {
			return false;
		}

		TwoFactor twoFactor = (TwoFactor)object;

		long primaryKey = twoFactor.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<TwoFactor> toCacheModel() {
		TwoFactorCacheModel twoFactorCacheModel = new TwoFactorCacheModel();

		twoFactorCacheModel.twoFactorId = getTwoFactorId();

		twoFactorCacheModel.groupId = getGroupId();

		twoFactorCacheModel.companyId = getCompanyId();

		twoFactorCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			twoFactorCacheModel.createDate = createDate.getTime();
		}
		else {
			twoFactorCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			twoFactorCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			twoFactorCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		twoFactorCacheModel.verificationType = getVerificationType();

		String verificationType = twoFactorCacheModel.verificationType;

		if ((verificationType != null) && (verificationType.length() == 0)) {
			twoFactorCacheModel.verificationType = null;
		}

		twoFactorCacheModel.verificationData = getVerificationData();

		String verificationData = twoFactorCacheModel.verificationData;

		if ((verificationData != null) && (verificationData.length() == 0)) {
			twoFactorCacheModel.verificationData = null;
		}

		Date expirationDate = getExpirationDate();

		if (expirationDate != null) {
			twoFactorCacheModel.expirationDate = expirationDate.getTime();
		}
		else {
			twoFactorCacheModel.expirationDate = Long.MIN_VALUE;
		}

		twoFactorCacheModel.used = isUsed();

		twoFactorCacheModel.disabled = isDisabled();

		return twoFactorCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<TwoFactor, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<TwoFactor, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TwoFactor, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((TwoFactor)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<TwoFactor, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<TwoFactor, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TwoFactor, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((TwoFactor)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, TwoFactor>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					TwoFactor.class, ModelWrapper.class);

	}

	private long _twoFactorId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _verificationType;
	private String _verificationData;
	private Date _expirationDate;
	private boolean _used;
	private boolean _disabled;

	public <T> T getColumnValue(String columnName) {
		Function<TwoFactor, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((TwoFactor)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("twoFactorId", _twoFactorId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("verificationType", _verificationType);
		_columnOriginalValues.put("verificationData", _verificationData);
		_columnOriginalValues.put("expirationDate", _expirationDate);
		_columnOriginalValues.put("used", _used);
		_columnOriginalValues.put("disabled", _disabled);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("twoFactorId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("createDate", 16L);

		columnBitmasks.put("modifiedDate", 32L);

		columnBitmasks.put("verificationType", 64L);

		columnBitmasks.put("verificationData", 128L);

		columnBitmasks.put("expirationDate", 256L);

		columnBitmasks.put("used", 512L);

		columnBitmasks.put("disabled", 1024L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private TwoFactor _escapedModel;

}