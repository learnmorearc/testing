package com.arc.poc.work.account.grpsrt.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arc.datamodel.model.Account;
import com.arc.datamodel.model.interfaces.AsOfDate;
import com.arc.poc.work.account.grpsrt.config.AccountGrouping;
import com.arc.poc.work.account.grpsrt.model.AccountGroup;
import com.arc.poc.work.account.grpsrt.sorting.AsyncAccountSorting;
import com.arc.poc.work.account.grpsrt.sorting.SyncAccountSorting;

@Service
public class TransferActivityService {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountGrouping accountGrouping;
	
	@Autowired
	private AsyncAccountSorting asyncAccountSorting;
	
	@Autowired
	private SyncAccountSorting syncAccountSorting;
	
	public List<AccountGroup> getAccounts() {
		List<AccountGroup> responseAccounts = new ArrayList<>();
		
		//final Map<String, Map<String, String>> detailTypesConfig = accountGrouping.getDetailType();
		final Map<String, Map<String, String>> groupConfig = accountGrouping.getGroups();
		
		Map<String, Map<String, List<Account>>> accountServiceAccounts = accountService.getAccounts();
		
		System.out.println("Before Sorting >>>>>>"+System.currentTimeMillis());
		Map<String, List<Account>> groupedAccounts = asyncAccountSorting.sortAccounts(accountServiceAccounts);
		//Map<String, List<Account>> groupedAccounts = syncAccountSorting.sortAccounts(accountServiceAccounts);
		System.out.println("After Sorting >>>>>>"+System.currentTimeMillis());
		
		groupedAccounts.forEach((group, list) -> {
			String name = groupConfig.get(group).get("name");
			boolean asOfDate = new Boolean(groupConfig.get(group).get("asOfDate"));
			
			String maxAsOfDate = null;
			if(asOfDate) {
				Optional<Account> opt = list.stream()
						.max((o1, o2) -> {
							AsOfDate d1 = (AsOfDate)o1;
							AsOfDate d2 = (AsOfDate)o2;
							return Comparator.comparing(AsOfDate::getAsOfDate).compare(d1, d2);
						});
				if(opt.isPresent()){
					maxAsOfDate = ((AsOfDate)(opt.get())).getAsOfDate().toString();
				}
			}
			AccountGroup accountGroup = new AccountGroup();
			accountGroup.setGroupName(name);
			accountGroup.setAsOfDate(maxAsOfDate);
			accountGroup.getAccounts().addAll(list);
			responseAccounts.add(accountGroup);
		});
		
		responseAccounts.forEach(action -> {
			System.out.println(action.getGroupName());
			System.out.println(action.getAsOfDate());
			action.getAccounts().forEach(account -> {
				System.out.println(account);
			});
			System.out.println("--------------------------------------");
		});
		
		return responseAccounts;
	}
}
