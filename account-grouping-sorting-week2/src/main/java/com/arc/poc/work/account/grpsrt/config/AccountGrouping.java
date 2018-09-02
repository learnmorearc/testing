package com.arc.poc.work.account.grpsrt.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties("com.arc.ui.grouping")
@RefreshScope
public class AccountGrouping {

	private final Map<String, Map<String, String>> detailType = new HashMap<>();
	private final Map<String, Map<String, String>> dataSource = new HashMap<>();
	private final Map<String, Map<String, String>> groups = new HashMap<>();
	
	public Map<String, Map<String, String>> getDetailType() {
		return detailType;
	}
	
	public Map<String, Map<String, String>> getDataSource() {
		return dataSource;
	}

	public Map<String, Map<String, String>> getGroups() {
		return groups;
	}
}
