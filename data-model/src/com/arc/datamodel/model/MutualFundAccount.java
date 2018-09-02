package com.arc.datamodel.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;

import com.arc.datamodel.model.interfaces.AsOfDate;

public class MutualFundAccount extends Account implements AsOfDate {
	
	private BigDecimal balance;
	private BigDecimal shares;
	private LocalDate asOfDate;
	
	public BigDecimal getShares() {
		return shares;
	}
	public void setShares(BigDecimal shares) {
		this.shares = shares;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public LocalDate getAsOfDate() {
		return asOfDate;
	}
	public void setAsOfDate(LocalDate asOfDate) {
		this.asOfDate = asOfDate;
	}
	
	@Override
	public String toString() {
		return "MutualFundAccount [balance=" + balance + ", shares=" + shares + ", asOfDate=" + asOfDate
				+ ", toString()=" + super.toString() + "]";
	}
	
	@Override
	public int compareTo(Account arg0) {
		return Comparator.comparing(MutualFundAccount::getName, Comparator.nullsLast(Comparator.naturalOrder()))
				.thenComparing(MutualFundAccount::getBalance, Comparator.nullsLast(Comparator.naturalOrder()))
				.compare(this, (MutualFundAccount)arg0);
	}
}
