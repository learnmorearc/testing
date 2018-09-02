package com.arc.datamodel.dto;

import java.math.BigDecimal;

public class ServiceAccountDTO {
	
	public BigDecimal getBalance() {
		return new BigDecimal(Math.random()*100);
	}
	
	public BigDecimal getShares() {
		return new BigDecimal(Math.random()*10);
	}
}
