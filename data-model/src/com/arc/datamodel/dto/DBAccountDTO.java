package com.arc.datamodel.dto;

public class DBAccountDTO {
	
	private String accountDetailType;
	private Integer dataSource;
	private boolean isExternal;

	public String getAccountDetailType() {
		return accountDetailType;
	}

	public void setAccountDetailType(String accountDetailType) {
		this.accountDetailType = accountDetailType;
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
		return "DBAccountDTO [accountDetailType=" + accountDetailType + ", dataSource=" + dataSource + ", isExternal="
				+ isExternal + "]";
	}

}
