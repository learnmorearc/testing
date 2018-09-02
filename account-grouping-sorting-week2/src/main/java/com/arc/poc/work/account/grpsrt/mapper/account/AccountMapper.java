package com.arc.poc.work.account.grpsrt.mapper.account;

import com.arc.datamodel.dto.DBAccountDTO;
import com.arc.datamodel.dto.ServiceAccountDTO;
import com.arc.datamodel.model.Account;

@FunctionalInterface
public interface AccountMapper {
	
	public abstract Account buildAccount(final DBAccountDTO dbAccount, final ServiceAccountDTO serviceAccount);
	
	default Account setCommonFields(final DBAccountDTO dbAccount, final ServiceAccountDTO serviceAccount, Account account) {
		account.setDetailType(dbAccount.getAccountDetailType());
		account.setDataSource(dbAccount.getDataSource());
		account.setExternal(dbAccount.isExternal());
		return account;
	}

}
