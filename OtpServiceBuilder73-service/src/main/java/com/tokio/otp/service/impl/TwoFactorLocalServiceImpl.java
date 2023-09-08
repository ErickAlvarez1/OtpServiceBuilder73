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

package com.tokio.otp.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.security.SecureRandomUtil;
import com.liferay.portal.kernel.util.Validator;
import com.tokio.otp.exception.NoSuchTwoFactorException;
import com.tokio.otp.model.TwoFactor;
import com.tokio.otp.service.base.TwoFactorLocalServiceBaseImpl;

import java.sql.Date;
import java.time.Instant;
import java.util.Calendar;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the two factor local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.tokio.otp.service.TwoFactorLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TwoFactorLocalServiceBaseImpl
 */

@Component(
	property = "model.class.name=com.tokio.otp.model.TwoFactor",
	service = AopService.class
)

public class TwoFactorLocalServiceImpl extends TwoFactorLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.tokio.otp.service.TwoFactorLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.tokio.otp.service.TwoFactorLocalServiceUtil</code>.
	 */
	
	public TwoFactor getTokenByUsuario(long userId, long companyId, long groupId ) {
		try {
			return twoFactorPersistence.findByUserIdAndCompanyId(userId, companyId);
		} catch (NoSuchTwoFactorException e) {
			//e.printStackTrace();
			System.out.println("Sin coincidencias: "+userId+"-"+companyId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public TwoFactor generateToken(long userId, long companyId, long groupId, int expirationMinutes) {
		TwoFactor user = twoFactorPersistence.fetchByUserIdAndCompanyId(userId, companyId);
		if (Validator.isNull(user)) {
			user = addTwoFactorUser(userId, companyId, groupId);
		}
		
		return updateTokenUser(user.getTwoFactorId(), generateToken(), expirationMinutes);
	}
	
	public TwoFactor addTwoFactorUser(long userId, long companyId, long groupId) {
		final TwoFactor twoFactor = createTwoFactor(counterLocalService.increment(TwoFactor.class.getName()));
		
		twoFactor.setUserId(userId);
		twoFactor.setCompanyId(companyId);
		twoFactor.setGroupId(groupId);
		twoFactor.setCreateDate(Date.from(Instant.now()));
		twoFactor.setModifiedDate(Date.from(Instant.now()));
		twoFactor.setDisabled(false);
		
		return addTwoFactor(twoFactor);
	}
	
	public TwoFactor updateTokenUser(long twoFactorId, String token, int expirationMinutes) {
		
		TwoFactor twoFactor = null;
		
		try {
			twoFactor = twoFactorPersistence.findByPrimaryKey(twoFactorId);
			
			twoFactor.setVerificationData(token);
			twoFactor.setVerificationType("email");
			twoFactor.setUsed(false);
			twoFactor.setModifiedDate(Date.from(Instant.now()));
			
			Calendar c = Calendar.getInstance();
			c.setTime(Date.from(Instant.now()));
			c.add(Calendar.MINUTE, expirationMinutes);
			
			twoFactor.setExpirationDate(c.getTime());
		} catch (NoSuchTwoFactorException e) {
			// TODO Auto-generated catch block
			System.out.println("No Such Two Factor");
		}
		
		return twoFactor;
	}
	
	private String generateToken() {
		return String.format("%1$6.6s", Math.abs(SecureRandomUtil.nextInt()) ).replace(' ', '0');
	}
}