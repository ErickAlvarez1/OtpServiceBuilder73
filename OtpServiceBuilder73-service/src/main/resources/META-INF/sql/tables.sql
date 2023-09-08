create table OTP_DebugEMails (
	debugEMailsId LONG not null primary key,
	email VARCHAR(75) null
);

create table OTP_TwoFactor (
	twoFactorId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	verificationType VARCHAR(75) null,
	verificationData VARCHAR(75) null,
	expirationDate DATE null,
	used BOOLEAN,
	disabled BOOLEAN
);

create table OTP_TwoFactorConfigs (
	twoFactorConfigsId LONG not null primary key,
	configName VARCHAR(75) null,
	configValue VARCHAR(75) null,
	configStatus BOOLEAN,
	groupId LONG,
	companyId LONG,
	modifiedDate DATE null
);