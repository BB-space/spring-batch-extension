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
import org.springframework.batch.item.file.MultiResourceItemReader;
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
import com.guesthouse.spring.batch.model.UnifyItem;
import com.guesthouse.spring.batch.processor.UnifyItemProcessor;

@Configuration
public class UnifyItemJobConfiguration {
	
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

	@Bean(name = "unifyItemXmlReader")
	public ItemReader<UnifyItem> reader() {
		MultiResourceItemReader<UnifyItem> multiResourceReader = new MultiResourceItemReader<UnifyItem>();
		StaxEventItemReader<UnifyItem> reader = new StaxEventItemReader<UnifyItem>();
		reader.setFragmentRootElementName("item");
		reader.setUnmarshaller(itemMarshaller());
		
		String accessory = environment.getRequiredProperty("resource.input.accessory");			
		String item = environment.getRequiredProperty("resource.input.item");	
		Resource r1 = JobUtil.getResource(accessory);		
		Resource r2 = JobUtil.getResource(item);		

		multiResourceReader.setResources(new Resource[] {r1, r2});
		multiResourceReader.setDelegate(reader);		
		
		return multiResourceReader;
	}
	

	@Bean(name = "unifyItemMarshaller")
	public Unmarshaller itemMarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(UnifyItem.class);
		return marshaller;
	}

	@Bean(name = "unifyItemXmlToDbJob")
	public Job job() {
		return jobBuilders.get("unifyItemXmlToDbJob")
			.listener(batchConfig.customJobExecutionListener())
			.start(step()).build();
	}

	@Bean(name = "unifyItemXmlToDbStep")
	public Step step() {
		return stepBuilders.get("unifyItemXmlToDbStep").<UnifyItem, UnifyItem> chunk(420)
			.reader(reader())		
			.processor(new UnifyItemProcessor())
			.writer(writer())
			.build();
	}

	@Bean(name = "unifyItemDbWriter")
	public ItemWriter<UnifyItem> writer() {
		JpaItemWriter<UnifyItem> writer = new JpaItemWriter<UnifyItem>();
		writer.setEntityManagerFactory(emf);
		return writer;
	}
}
