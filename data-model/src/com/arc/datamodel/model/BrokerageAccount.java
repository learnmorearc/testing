package com.arc.datamodel.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;

import com.arc.datamodel.model.interfaces.AsOfDate;

public class BrokerageAccount extends Account implements AsOfDate  {
	
	private BigDecimal balance;
	private BigDecimal marketValue;
	private LocalDate asOfDate;
	
	public BigDecimal getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(BigDecimal marketValue) {
		this.marketValue = marketValue;
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
		return "BrokerageAccount [balance=" + balance + ", marketValue=" + marketValue + ", asOfDate=" + asOfDate
				+ ", toString()=" + super.toString() + "]";
	}
	
	@Override
	public int compareTo(Account arg0) {
		return Comparator.comparing(BrokerageAccount::getName, Comparator.nullsLast(Comparator.naturalOrder()))
				.thenComparing(BrokerageAccount::getBalance, Comparator.nullsLast(Comparator.naturalOrder()))
				.compare(this, (BrokerageAccount)arg0);
	}
}
