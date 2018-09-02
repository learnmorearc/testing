package com.arc.poc.work.account.grpsrt.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arc.datamodel.model.Account;
import com.arc.poc.work.account.grpsrt.config.AccountGrouping;

@Component
public class AsyncAccountSorting implements AccountSorting {

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
			try {
				CompletableFuture.runAsync(()-> {
					//String group = groupConfig.get(key).get("group");
					boolean sorting = new Boolean(groupConfig.get(key).get("sorting"));
					
					List<Account> accountsList = new ArrayList<>();
					if(sorting) {
						map.values().forEach(list -> {
							accountsList.addAll(list);
						});
						CompletableFuture.runAsync(() -> Collections.sort(accountsList))
						.thenRun(() -> sortedAccounts.put(key, accountsList));
					} else {
						final List<CompletableFuture<Void>> completableFutureList = new ArrayList<>();
						map.values().forEach(list -> {
							completableFutureList.add(CompletableFuture.runAsync(() -> Collections.sort(list)));
						});
						/*map.values().forEach(list -> {
							accountsList.addAll(list);
						});*/
						CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[map.size()]))
						.thenRun(() -> {
							map.values().forEach(list -> {
								accountsList.addAll(list);
							});
						})
						.thenRun(() -> sortedAccounts.put(key, accountsList));
					}
				}).get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		return sortedAccounts;
	}

}
