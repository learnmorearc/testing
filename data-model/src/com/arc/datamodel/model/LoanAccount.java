package com.arc.datamodel.model;

import java.math.BigDecimal;
import java.util.Comparator;

public class LoanAccount extends Account {
	
	private BigDecimal creditLimit;
	private BigDecimal balance;
	private String asOfDate;
	
	public BigDecimal getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public String getAsOfDate() {
		return asOfDate;
	}
	public void setAsOfDate(String asOfDate) {
		this.asOfDate = asOfDate;
	}
	@Override
	public String toString() {
		return "LoanAccount [creditLimit=" + creditLimit + ", balance=" + balance + ", asOfDate=" + asOfDate
				+ ", toString()=" + super.toString() + "]";
	}
	
	@Override
	public int compareTo(Account arg0) {
		return Comparator.comparing(LoanAccount::getName, Comparator.nullsLast(Comparator.naturalOrder()))
				.thenComparing(LoanAccount::getCreditLimit, Comparator.nullsLast(Comparator.naturalOrder()))
				.compare(this, (LoanAccount)arg0);
	}
}
