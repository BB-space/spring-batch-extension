package com.guesthouse.spring.batch.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class JaxbDateAdapter extends XmlAdapter<String, Date> {
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	
	
	@Override
	public String marshal(Date date) throws Exception { 
		if (date == null) {
			date = new Date();
		}
		return dateFormat.format(date);
	}
 
	@Override
	public Date unmarshal(String date) throws Exception {
		return dateFormat.parse(date);
	}

	

}
