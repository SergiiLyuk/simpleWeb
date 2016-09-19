package com.journaldev.model.filters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProducerFilter implements SearchFilterInterface{

	public static String FILTER_ID = "PRODUCER_FILTER";
	private String actionTo;
	private String actionParamName;
	private String actionParamValue;
	private String filterName;
	private String filterNameDescription;
	private String fiterIsChecked;
	
	

	private HashMap<String, String> producerFilterConfig;
	
	public ProducerFilter() {
		producerFilterConfig = new HashMap<>();
		producerFilterConfig.put("actionTo", "ProductServletDAO");
		producerFilterConfig.put("actionParamName", "producerName");
		
		
		Map<String, HashMap<String, String>> filterConfig = new HashMap<String,  HashMap<String, String>>();
		filterConfig.put("PRODUCER_FILTER", producerFilterConfig);
		
	}
	
		
	public String getActionTo() {
		return producerFilterConfig.get("actionTo");
	}

	public String getActionParamName() {
		return producerFilterConfig.get("actionParamName");
	}
	public void setActionParamName(String actionParamName) {
		this.actionParamName = actionParamName;
	}
	public String getActionParamValue() {
		return actionParamValue;
	}
	public void setActionParamValue(String actionParamValue) {
		this.actionParamValue = actionParamValue;
	}
	public String getFilterName() {
		return filterName;
	}
	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
	
	public String getFilterNameDescription() {
		return filterNameDescription;
	}
	public void setFilterNameDescription(String filterNameDescription) {
		this.filterNameDescription = filterNameDescription;
	}
	
	
	public String getFiterIsChecked() {
		return fiterIsChecked;
	}


	public void setFiterIsChecked(String fiterIsChecked) {
		this.fiterIsChecked = fiterIsChecked;
	}


	public Map<String, String> getProducerFilterConfig(){
		return producerFilterConfig;
	}
	
	
	 
}
