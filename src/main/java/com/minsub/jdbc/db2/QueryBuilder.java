package com.minsub.jdbc.db2;

public interface QueryBuilder {

	public String getQuery();
	
	public String getQuery(String StartDate, String EndDate);
}
