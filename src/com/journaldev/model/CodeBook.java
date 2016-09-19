package com.journaldev.model;

import java.util.HashMap;
import java.util.Map;

public class CodeBook {

	private String key;
	private String value;
	private Map<String, String> codebook;
	private CodeBook codebuBookObj = null;
	
	public CodeBook(){
		 codebook = new HashMap<>();
	}
	
	public CodeBook(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	public CodeBook init(){
		if(codebuBookObj == null){
			
			codebuBookObj = new CodeBook();
		}
		
		Map<String, String> tempCodeboock = new HashMap();
		tempCodeboock.put("MenuMobPhone", "Мобільні телефони");
		tempCodeboock.put("MenuPC", "ПК");
		codebuBookObj.addTEmpCodebook(tempCodeboock);
		return codebuBookObj;
	}
	
	public void addTEmpCodebook(Map<String, String> tempCodeboock){
		System.out.println("TempCodeboock" + tempCodeboock);
		codebook.putAll(tempCodeboock);
	}
	
	
	public void addKeyValue (String key, String value){
		/*codebook = new HashMap<String, String>();*/
		codebook.put(key, value);
	}
	
	public String getKey (String value){
		String key="";
		if(!codebook.isEmpty()){
			for(String currentKey : codebook.keySet()){
				if(currentKey.equals(value));
					key = currentKey;
					return key;
			}
			
		}
		//Зробити черех exception
		return "";
	}
	
	public String getValue (String key){
		String value=codebook.get(key);
		
		if(!codebook.isEmpty()){
			value=codebook.get(key);
			return value;
			
		}
		//Зробити черех exception
		return "";
	}
	
	
	
	
	
	
	
	
}
