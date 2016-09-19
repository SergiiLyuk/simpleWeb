package com.journaldev.model;

public class FilterImpl {

	private String filterName;
	private String filterDescription;
	private String filterRequestTo;
	private String filterRequestParam;
	
	public FilterImpl(String filterName, String filterDescription,
			String filterRequestTo, String filterRequestParam) {
		super();
		this.filterName = filterName;
		this.filterDescription = filterDescription;
		this.filterRequestTo = filterRequestTo;
		this.filterRequestParam = filterRequestParam;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public String getFilterDescription() {
		return filterDescription;
	}

	public void setFilterDescription(String filterDescription) {
		this.filterDescription = filterDescription;
	}

	public String getFilterRequestTo() {
		return filterRequestTo;
	}

	public void setFilterRequestTo(String filterRequestTo) {
		this.filterRequestTo = filterRequestTo;
	}

	public String getFilterRequestParam() {
		return filterRequestParam;
	}

	public void setFilterRequestParam(String filterRequestParam) {
		this.filterRequestParam = filterRequestParam;
	}

	@Override
	public String toString() {
		return "FilterImpl [filterName=" + filterName + ", filterDescription="
				+ filterDescription + ", filterRequestTo=" + filterRequestTo
				+ ", filterRequestParam=" + filterRequestParam + "]";
	}
	
	
	
	
	
	
}
