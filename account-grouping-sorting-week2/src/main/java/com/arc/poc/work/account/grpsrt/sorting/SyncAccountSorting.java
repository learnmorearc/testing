package com.arc.poc.work.account.grpsrt.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arc.datamodel.model.Account;
import com.arc.poc.work.account.grpsrt.config.AccountGrouping;

@Component
public class SyncAccountSorting implements AccountSorting {

	@Autowired
	private AccountGrouping accountGrouping;
	
	@Override
	public Map<String, List<Account>> sortAccounts(Map<String, Map<String, List<Account>>> groupedAccounts) {
		
		final Map<String, Map<String, String>> groupConfig = accountGrouping.getGroups();
		
		Map<String, List<Account>> sortedAccounts = new LinkedHashMap<>();
		
		groupedAccounts.keySet().forEach(key -> {
			sortedAccounts.put(key, new ArrayList<>());
		});
		
		groupedAccounts.forEach((key, map) -> {
			boolean sorting = new Boolean(groupConfig.get(key).get("sorting"));
			
			List<Account> accountsList = new ArrayList<>();
			if(sorting) {
				map.values().forEach(list -> {
					accountsList.addAll(list);
				});
				Collections.sort(accountsList);
				sortedAccounts.put(key, accountsList);
			} else {
				map.values().forEach(list -> {
					Collections.sort(list);
				});
				map.values().forEach(list -> {
					accountsList.addAll(list);
				});
				sortedAccounts.put(key, accountsList);
			}
		});
		return sortedAccounts;
	}

}
