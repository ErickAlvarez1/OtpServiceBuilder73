create index IX_FC9F2470 on OTP_DebugEMails (email[$COLUMN_LENGTH:75$]);

create index IX_19D36A21 on OTP_TwoFactor (userId, companyId);

create index IX_75E9D517 on OTP_TwoFactorConfigs (configName[$COLUMN_LENGTH:75$], companyId);