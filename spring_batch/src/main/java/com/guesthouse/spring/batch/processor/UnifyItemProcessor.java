package com.guesthouse.spring.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.guesthouse.spring.batch.Encrypter;
import com.guesthouse.spring.batch.model.UnifyItem;

public class UnifyItemProcessor implements ItemProcessor<UnifyItem, UnifyItem> {

	@Override
	public UnifyItem process(UnifyItem item) throws Exception {
		item.setMd5(Encrypter.generateMd5(item.getId()));
		item.setQualityOrder(getQualityOrderNo(item.getQuality()));	
		item.setItemCateogry(getItemCategoryNo(item.getId()));
		item.setReplaceName(getPrefixItemName(item.getName()));
		
		return item;
	}
	
	public int getQualityOrderNo(String quality) {
		//임시값 세팅
		return 1;	
	}
	
	public String getItemCategoryNo(String id) {
		//임시값 세팅
		return id;
	}
	
	public String getPrefixItemName(String name) {
		
		if (name.startsWith("도안:")) {
			return name.replaceFirst("도안:", "").trim();
		}
		
		if (name.startsWith("마석 도안:")) {
			return name.replaceFirst("마석 도안:", "").trim();
		}
		
		if (name.startsWith("드라코닉 도안:")) {
			return name.replaceFirst("드라코닉 도안:", "").trim();
		}
		
		if (name.startsWith("요리법:")) {
			return name.replaceFirst("요리법:", "").trim();
		}
		
		if (name.startsWith("드라코닉 요리법:")) {
			return name.replaceFirst("드라코닉 요리법:", "").trim();
		}
		
		return name;
	}

}
