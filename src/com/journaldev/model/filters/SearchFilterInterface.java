package com.journaldev.model.filters;

public interface SearchFilterInterface {

	public String getActionTo();
	public String getActionParamName() ;
	public void setActionParamName(String actionParamName);
	public String getActionParamValue();
	public void setActionParamValue(String actionParamValue);
	public String getFilterName();
	public void setFilterName(String filterName);
	public String getFilterNameDescription();
	public void setFilterNameDescription(String filterNameDescription);
	public String getFiterIsChecked();
	public void setFiterIsChecked(String fiterIsChecked);
}
