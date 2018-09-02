package com.arc.poc.work.account.grpsrt.test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arc.datamodel.dto.DBAccountDTO;
import com.arc.datamodel.dto.ServiceAccountDTO;
import com.arc.datamodel.model.Account;
import com.arc.poc.work.account.grpsrt.factory.AccountMapperFactory;
import com.arc.poc.work.account.grpsrt.grouping.AccountCollector;
import com.arc.poc.work.account.grpsrt.mapper.account.AccountMapper;

@Service
public class AccountService {
	
	@Autowired
	private AccountMapperFactory accountFactory;
	
	@Autowired
	private AccountCollector accountCollector;
	
	public Map<String, Map<String, List<Account>>> getAccounts() {
		
		List<DBAccountDTO> listDB = AccountDTOGenerator.dummyDBAccountDTOs();
		
		final Map<String, Map<String, List<Account>>> accountMap = new LinkedHashMap<>();
		System.out.println("**************************************");
		listDB.forEach(dbAccount -> {
			
			ServiceAccountDTO serviceAccount = new ServiceAccountDTO();
			AccountMapper mapper = accountFactory.getAccountMapper(dbAccount, serviceAccount);
			Account account = mapper.buildAccount(dbAccount, serviceAccount);
			System.out.println(account);
			accountCollector.group(account, accountMap);
		});
		
		System.out.println("**************************************");
		return accountMap;
	}

	/*public Map<String, Map<String, List<Account>>> getAccounts() {
		
		Map<String, Map<String, String>> detailTypesConfig = accountGrouping.getDetailType();
		Map<String, Map<String, String>> dataSourceConfig = accountGrouping.getDataSource();
		Map<String, Map<String, String>> groupConfig = accountGrouping.getGroups();
		
		List<DBAccountDTO> listDB = AccountDTOGenerator.dummyDBAccountDTOs();
		
		final Map<String, Map<String, List<Account>>> accountMap = new LinkedHashMap<>();
		System.out.println("**************************************");
		listDB.forEach(dbAccount -> {
			
			ServiceAccountDTO serviceAccount = new ServiceAccountDTO();
			AccountMapper mapper = accountFactory.getAccountMapper(dbAccount, serviceAccount);
			
			Map<String, String> something = detailTypesConfig.get(dbAccount.getAccountDetailType());
			if(something == null) {
				something = dataSourceConfig.get(dbAccount.getDataSource().toString());
			}
			String group = null;
			if(something != null)
				group = something.get("group");
			if(StringUtils.isEmpty(group))
				group = "other";
			boolean sorting = new Boolean(groupConfig.get(group).get("sorting"));
			
			Account account = mapper.buildAccount(dbAccount, serviceAccount);
			System.out.println(account);
			
			if(sorting) {
				Map<String, List<Account>> sortableMap = accountMap.getOrDefault(group, new LinkedHashMap<>());
				List<Account> accountList = sortableMap.getOrDefault(group, new ArrayList<>());
				if(accountList.size() == 0) {
					sortableMap.put(group, accountList);
					accountMap.put(group, sortableMap);
				}
				accountList.add(account);
				
			} else {
				Map<String, List<Account>> sortableMap = accountMap.getOrDefault(group, new LinkedHashMap<>());
				List<Account> accountList = sortableMap.getOrDefault(dbAccount.getAccountDetailType(), new ArrayList<>());
				if(accountList.size() == 0) {
					sortableMap.put(dbAccount.getAccountDetailType(), accountList);
					accountMap.put(group, sortableMap);
				}
				accountList.add(account);
			}
		});
		
		System.out.println("**************************************");
		return accountMap;
	}*/
}
