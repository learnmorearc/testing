package com.arc.poc.work.account.grpsrt.model;

import java.util.ArrayList;
import java.util.List;

import com.arc.datamodel.model.Account;

public class AccountGroup {

	private String groupName;
	private String asOfDate;
	private List<Account> accounts = new ArrayList<>();
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getAsOfDate() {
		return asOfDate;
	}
	public void setAsOfDate(String asOfDate) {
		this.asOfDate = asOfDate;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}
