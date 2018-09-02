package com.arc.poc.work.account.grpsrt.mapper.account;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.stereotype.Component;

import com.arc.datamodel.dto.DBAccountDTO;
import com.arc.datamodel.dto.ServiceAccountDTO;
import com.arc.datamodel.model.Account;
import com.arc.datamodel.model.MutualFundAccount;

@Component
public class MutualFundAccountMapper implements AccountMapper {

	@Override
	public Account buildAccount(final DBAccountDTO dbAccount, final ServiceAccountDTO serviceAccount) {
		MutualFundAccount account = new MutualFundAccount();
		setCommonFields(dbAccount, serviceAccount, account);
		account.setBalance(serviceAccount.getBalance());
		account.setShares(serviceAccount.getShares());
		account.setName("MutualFund");
		LocalDate d = LocalDate.of(2018, Month.SEPTEMBER, (int)((Math.random()*30)));
		account.setAsOfDate(d);
		return account;
	}
}
