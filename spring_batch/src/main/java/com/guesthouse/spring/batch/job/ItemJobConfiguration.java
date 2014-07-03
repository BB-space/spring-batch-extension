package com.guesthouse.spring.batch.job;



import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.guesthouse.spring.batch.JobUtil;
import com.guesthouse.spring.batch.config.BatchConfiguration;
import com.guesthouse.spring.batch.config.DataSourceConfiguration;
import com.guesthouse.spring.batch.model.Item;
import com.guesthouse.spring.batch.processor.ItemJobProcessor;

@Configuration
public class ItemJobConfiguration  {
	
	@Autowired
	private StepBuilderFactory stepBuilders;

	@Autowired
	private JobBuilderFactory jobBuilders;
	
	@Autowired
	private EntityManagerFactory emf;
	
	@Autowired
	private BatchConfiguration batchConfig;
	
	@Inject
	private Environment environment;
		
	@Bean(name="itemXmlReader")
	public ItemReader<Item> reader() {
		StaxEventItemReader<Item> reader = new StaxEventItemReader<Item>();
		String resourcePath = environment.getRequiredProperty("resource.input.item");		
		Resource resource = JobUtil.getResource(resourcePath);	
		reader.setResource(resource); 		
		reader.setFragmentRootElementName("item");
		reader.setUnmarshaller(itemMarshaller());
		return reader;
	}
	
	@Bean(name="itemMarshaller")
	public Unmarshaller itemMarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Item.class);
		return marshaller;
	}
	
	
	
	@Bean(name="itemXmlToDbJob")
	public Job job() {
		return jobBuilders.get("itemXmlToDbJob")		
			.listener(batchConfig.customJobExecutionListener())
			.start(step())
			.build();
	}

	@Bean(name="itemXmlToDbStep")
	public Step step() {
		return stepBuilders.get("itemXmlToDbStep").<Item, Item> chunk(420)
			.reader(reader())		
			.processor(new ItemJobProcessor())
			.writer(writer())	
			.build();
	}
	
	@Bean(name="itemDbWriter")
	public ItemWriter<Item> writer() {
		/*JdbcBatchItemWriter<Item> writer = new JdbcBatchItemWriter<Item>();
		writer.setDataSource(dataSourceConfig.dataSource());
		
		
		StringBuffer sbf = new StringBuffer();
		sbf.append(" INSERT INTO item (id, image, name, label, level, desc_long, price, quality, lore, can_exchange ");
		sbf.append(", can_sell_to_npc, gender_permitted, can_deposit_to_character_warehouse ");
		sbf.append(", can_deposit_to_account_warehouse, can_deposit_to_guild_warehouse ");
		sbf.append(", breakable, soul_bind, remove_when_logout, race_permitted, quest, item_type ");
		sbf.append(", equipment_slots, bonus_apply, can_split, cash_item, activation_skill, activation_level ");
		sbf.append(", attribute, bonus_attr, abyss_point, price2, can_buy_from_npc, craft_recipe_info ");
		sbf.append(", level_desc, use_delay, public )");
		sbf.append("  VALUES (:id, :image, :name, :label, :level, :descLong, :price, :quality, :lore, :canExchange ");
		sbf.append(", :canSellToNpc, :genderPermitted, :canDepositTocharacterWarehouse ");
		sbf.append(", :canDepositToAccountWarehouse, :canDepositToGuildWarehouse");
		sbf.append(", :breakable, :soulBind, :removeWhenLogout, :racePermitted, :quest, :itemType ");
		sbf.append(", :equipmentSlots, :bonusApply, :canSplit, :cashItem, :activationSkill, :activationLevel ");
		sbf.append(", :attribute, :bonusAttr, :abyssPoint, :price2, :canBuyFromNpc, :craftRecipeInfo ");
		sbf.append(", :levelDesc, :useDelay, :isPublic )");
		writer.setSql(sbf.toString());
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Item>());
		return writer;*/
		
		JpaItemWriter<Item> writer = new JpaItemWriter<Item>();
		writer.setEntityManagerFactory(emf);
		return writer;
	}

}
