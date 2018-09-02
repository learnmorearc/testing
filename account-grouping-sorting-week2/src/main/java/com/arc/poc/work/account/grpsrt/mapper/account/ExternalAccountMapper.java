package com.arc.poc.work.account.grpsrt.mapper.account;

import org.springframework.stereotype.Component;

import com.arc.datamodel.dto.DBAccountDTO;
import com.arc.datamodel.dto.ServiceAccountDTO;
import com.arc.datamodel.model.Account;
import com.arc.datamodel.model.ExternalAccount;

@Component
public class ExternalAccountMapper implements AccountMapper {

	@Override
	public Account buildAccount(final DBAccountDTO dbAccount, final ServiceAccountDTO serviceAccount) {
		ExternalAccount account = new ExternalAccount();
		setCommonFields(dbAccount, serviceAccount, account);
		account.setName("External" + Math.random()*10);
		return account;
	}
}
