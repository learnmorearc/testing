package com.arc.poc.work.account.grpsrt.factory;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arc.datamodel.dto.DBAccountDTO;
import com.arc.datamodel.dto.ServiceAccountDTO;
import com.arc.poc.work.account.grpsrt.config.AccountGrouping;
import com.arc.poc.work.account.grpsrt.mapper.account.AccountMapper;
import com.arc.poc.work.account.grpsrt.mapper.account.BankingAccountMapper;

@Component
public class AccountMapperFactory {
	
	@Autowired
	private AccountGrouping accountGrouping;
	
	@Autowired
	private Map<String, AccountMapper> accountMappers;
	
	public AccountMapper getAccountMapper(final DBAccountDTO dbAccount, final ServiceAccountDTO serviceAccount) {
		
		Map<String, Map<String, String>> detailTypesConfig = accountGrouping.getDetailType();
		Map<String, Map<String, String>> dataSourceConfig = accountGrouping.getDataSource();
		
		Map<String, String> config = detailTypesConfig.get(dbAccount.getAccountDetailType());
		if(config == null ) {
			config = dataSourceConfig.get(dbAccount.getDataSource().toString());
		}
		AccountMapper mapper = null;
		if(config != null) {
			String beanName = config.get("mapper");
			mapper = accountMappers.get(beanName);
		}
		if(mapper == null ) {
			mapper = new BankingAccountMapper();
		}
		return mapper;
	}
}
