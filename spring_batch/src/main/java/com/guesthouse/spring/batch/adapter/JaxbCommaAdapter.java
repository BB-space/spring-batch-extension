package com.guesthouse.spring.batch.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.springframework.util.StringUtils;





public class JaxbCommaAdapter  extends XmlAdapter<List<String>, String> {
	
	
	//원문자를 String
	@Override
	public String unmarshal(List<String> list) throws Exception {
		System.out.println("#################result = " + "TEST");
		// TODO Auto-generated method stub
		return StringUtils.collectionToCommaDelimitedString(list);
		
		
	}
	
	
	//String을 변활할려는 타입으로 변경 List
	@Override
	public List<String> marshal(String str) throws Exception {
		
		List<String> result = null;
		if (str != null) {
			result = new ArrayList<String>(Arrays.asList(str.split(",")));
		}
		System.out.println("#################result = " + result);
		return result;
		
	}

	
	

}
