package com.guesthouse.spring.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.guesthouse.spring.batch.Encrypter;
import com.guesthouse.spring.batch.model.Accessory;

public class AccessoryJobProcessor implements ItemProcessor<Accessory, Accessory> {

	@Override
	public Accessory process(final Accessory item) throws Exception {
		item.setMd5(Encrypter.generateMd5(item.getId()));
		return item;
	}

}
