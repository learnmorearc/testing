package com.arc.poc.work.account.grpsrt.mapper.account;

import org.springframework.stereotype.Component;

import com.arc.datamodel.dto.DBAccountDTO;
import com.arc.datamodel.dto.ServiceAccountDTO;
import com.arc.datamodel.model.Account;
import com.arc.datamodel.model.BankingAccount;

@Component
public class BankingAccountMapper implements AccountMapper {

	@Override
	public Account buildAccount(final DBAccountDTO dbAccount, final ServiceAccountDTO serviceAccount) {
		BankingAccount account = new BankingAccount();
		setCommonFields(dbAccount, serviceAccount, account);
		account.setBalance(serviceAccount.getBalance());
		account.setName("Banking");
		return account;
	}
}
