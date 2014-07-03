package com.guesthouse.spring.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.guesthouse.spring.batch.Encrypter;
import com.guesthouse.spring.batch.model.Item;

public class ItemJobProcessor implements ItemProcessor<Item, Item>{

	@Override
	public Item process(final Item item) throws Exception {
		item.setMd5(Encrypter.generateMd5(item.getId()));
		return item;
	}

}
