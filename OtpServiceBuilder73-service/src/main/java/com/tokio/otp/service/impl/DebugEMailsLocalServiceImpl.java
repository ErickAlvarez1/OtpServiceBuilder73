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
import com.liferay.portal.kernel.util.Validator;
import com.tokio.otp.service.base.DebugEMailsLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the debug e mails local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.tokio.otp.service.DebugEMailsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DebugEMailsLocalServiceBaseImpl
 */

@Component(
	property = "model.class.name=com.tokio.otp.model.DebugEMails",
	service = AopService.class
)

public class DebugEMailsLocalServiceImpl
	extends DebugEMailsLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.tokio.otp.service.DebugEMailsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.tokio.otp.service.DebugEMailsLocalServiceUtil</code>.
	 */
	
	public boolean existEMail(String email) {
		return Validator.isNotNull(debugEMailsPersistence.fetchByEmail(email));
	}
}