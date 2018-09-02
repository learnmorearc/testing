package com.arc.poc.work.account.grpsrt.sorting;

import java.util.List;
import java.util.Map;

import com.arc.datamodel.model.Account;

public interface AccountSorting {
	
	Map<String, List<Account>> sortAccounts(Map<String, Map<String, List<Account>>> groupedAccounts);
	
}
