package com.arc.datamodel.model;

import java.math.BigDecimal;
import java.util.Comparator;

public class BankingAccount extends Account {
	
	private BigDecimal balance;

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankingAccount [balance=" + balance + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int compareTo(Account arg0) {
		return Comparator.comparing(BankingAccount::getName, Comparator.nullsLast(Comparator.naturalOrder()))
				.thenComparing(BankingAccount::getBalance, Comparator.nullsLast(Comparator.naturalOrder()))
				.compare(this, (BankingAccount)arg0);
	}
}
