package com.arc.poc.work.account.grpsrt.grouping;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.arc.datamodel.model.Account;
import com.arc.poc.work.account.grpsrt.config.AccountGrouping;

@Component
public class AccountCollector {
	
	@Autowired
	private AccountGrouping accountGrouping;
	
	public void group(final Account account, 
			final Map<String, Map<String, List<Account>>> accountMap) {
		
		Map<String, Map<String, String>> detailTypesConfig = accountGrouping.getDetailType();
		Map<String, Map<String, String>> dataSourceConfig = accountGrouping.getDataSource();
		Map<String, Map<String, String>> groupConfig = accountGrouping.getGroups();
		
		Map<String, String> something = detailTypesConfig.get(account.getDetailType());
		if(something == null) {
			something = dataSourceConfig.get(account.getDataSource().toString());
		}
		String group = null;
		if(something != null)
			group = something.get("group");
		if(StringUtils.isEmpty(group))
			group = "other";
		boolean sorting = new Boolean(groupConfig.get(group).get("sorting"));
		
		Map<String, List<Account>> sortableMap = accountMap.getOrDefault(group, new LinkedHashMap<>());
		if(sorting) {
			List<Account> accountList = sortableMap.getOrDefault(group, new ArrayList<>());
			if(accountList.size() == 0) {
				sortableMap.put(group, accountList);
				accountMap.put(group, sortableMap);
			}
			accountList.add(account);
			
		} else {
			List<Account> accountList = sortableMap.getOrDefault(account.getDetailType(), new ArrayList<>());
			if(accountList.size() == 0) {
				sortableMap.put(account.getDetailType(), accountList);
				accountMap.put(group, sortableMap);
			}
			accountList.add(account);
		}
	}
}
