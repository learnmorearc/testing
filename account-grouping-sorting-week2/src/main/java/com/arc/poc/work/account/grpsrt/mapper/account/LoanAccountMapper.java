package com.arc.poc.work.account.grpsrt.mapper.account;

import org.springframework.stereotype.Component;

import com.arc.datamodel.dto.DBAccountDTO;
import com.arc.datamodel.dto.ServiceAccountDTO;
import com.arc.datamodel.model.Account;
import com.arc.datamodel.model.LoanAccount;

@Component
public class LoanAccountMapper implements AccountMapper {

	@Override
	public Account buildAccount(final DBAccountDTO dbAccount, final ServiceAccountDTO serviceAccount) {
		LoanAccount account = new LoanAccount();
		setCommonFields(dbAccount, serviceAccount, account);
		account.setBalance(serviceAccount.getBalance());
		account.setCreditLimit(serviceAccount.getBalance());
		account.setName("Loan" + account.getBalance().toString());
		return account;
	}
}
