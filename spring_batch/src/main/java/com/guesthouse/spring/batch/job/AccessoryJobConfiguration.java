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
import org.springframework.core.io.Resource;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.guesthouse.spring.batch.JobUtil;
import com.guesthouse.spring.batch.config.BatchConfiguration;
import com.guesthouse.spring.batch.model.Accessory;
import com.guesthouse.spring.batch.processor.AccessoryJobProcessor;

@Configuration
public class AccessoryJobConfiguration {	

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

	@Bean(name = "accessoryXmlReader")
	public ItemReader<Accessory> reader() {
		StaxEventItemReader<Accessory> reader = new StaxEventItemReader<Accessory>();
		String resourcePath = environment.getRequiredProperty("resource.input.accessory");		
		Resource resource = JobUtil.getResource(resourcePath);	
		reader.setResource(resource); 		
		reader.setFragmentRootElementName("item");
		reader.setUnmarshaller(itemMarshaller());
		return reader;
	}

	@Bean(name = "accessoryMarshaller")
	public Unmarshaller itemMarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Accessory.class);
		return marshaller;
	}

	@Bean(name = "accessoryXmlToDbJob")
	public Job job() {
		return jobBuilders.get("accessoryXmlToDbJob")
			.listener(batchConfig.customJobExecutionListener())
			.start(step()).build();
	}

	@Bean(name = "accessoryXmlToDbStep")
	public Step step() {
		return stepBuilders.get("accessoryXmlToDbStep").<Accessory, Accessory> chunk(420)
			.reader(reader())
			.processor(new AccessoryJobProcessor())
			.writer(writer())
			.build();
	}

	@Bean(name = "accessoryDbWriter")
	public ItemWriter<Accessory> writer() {
		JpaItemWriter<Accessory> writer = new JpaItemWriter<Accessory>();
		writer.setEntityManagerFactory(emf);
		return writer;
	}

}
