package com.arc.poc.work.account.grpsrt.mapper.account;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.stereotype.Component;

import com.arc.datamodel.dto.DBAccountDTO;
import com.arc.datamodel.dto.ServiceAccountDTO;
import com.arc.datamodel.model.Account;
import com.arc.datamodel.model.BrokerageAccount;

@Component
public class BrokerageAccountMapper implements AccountMapper {

	@Override
	public Account buildAccount(final DBAccountDTO dbAccount, final ServiceAccountDTO serviceAccount) {
		BrokerageAccount account = new BrokerageAccount();
		setCommonFields(dbAccount, serviceAccount, account);
		account.setBalance(serviceAccount.getBalance());
		account.setMarketValue(serviceAccount.getBalance());
		account.setName("Brokerage" + account.getBalance().toString());
		LocalDate d = LocalDate.of(2018, Month.SEPTEMBER, (int)((Math.random()*30)));
		account.setAsOfDate(d);
		return account;
	}
}
