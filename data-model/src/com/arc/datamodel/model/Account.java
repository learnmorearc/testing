package com.arc.datamodel.model;

import java.util.Comparator;

public abstract class Account implements Comparable<Account> {
	
	private String name;
	private String detailType;
	private Integer dataSource;
	private boolean isExternal;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetailType() {
		return detailType;
	}
	public void setDetailType(String detailType) {
		this.detailType = detailType;
	}
	public Integer getDataSource() {
		return dataSource;
	}
	public void setDataSource(Integer dataSource) {
		this.dataSource = dataSource;
	}
	public boolean isExternal() {
		return isExternal;
	}
	public void setExternal(boolean isExternal) {
		this.isExternal = isExternal;
	}
	@Override
	public String toString() {
		return "Account [name=" + name + ", detailType=" + detailType + ", dataSource=" + dataSource + ", isExternal="
				+ isExternal + "]";
	}
	
	@Override
	public int compareTo(Account arg0) {
		return Comparator.comparing(Account::getName, Comparator.nullsLast(Comparator.naturalOrder()))
				.compare(this, arg0);
	}
}
