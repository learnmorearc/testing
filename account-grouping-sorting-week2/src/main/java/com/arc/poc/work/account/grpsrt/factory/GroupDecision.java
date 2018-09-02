package com.arc.poc.work.account.grpsrt.factory;

import java.util.Map;

public class GroupDecision {
	
	public static <T> T decideGroup(final String detailedType, final Integer dataSource, final boolean isExternal, 
			Map<String, T> detailedTypeMap, Map<Integer, T> dataSourceMap, Map<Boolean, T> isExternalMap) {
		T returnObject = detailedTypeMap.get(detailedType);
		if(returnObject == null)
			returnObject = dataSourceMap.get(dataSource);
		if(returnObject == null)
			returnObject = isExternalMap.get(isExternal);
		return returnObject;
	}
}
