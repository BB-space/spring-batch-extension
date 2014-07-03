package com.guesthouse.spring.batch.config;

import java.util.Properties;

import javax.inject.Inject;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class JpaConfig {
	
	@Inject
	private Environment environment;
	
	@Inject
	private DataSourceConfiguration dataSourceConfig;
	

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());	
		
		return transactionManager;
	}

	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		lef.setPackagesToScan("com.guesthouse.spring.batch.model");
		lef.setDataSource(dataSourceConfig.dataSource());
		lef.setJpaProperties(additionalProperties());
		return lef;
	}

	private Properties additionalProperties() {
		Properties properties = new Properties();
		// Generated SQL
		properties.setProperty("hibernate.connection.driver_class", environment.getRequiredProperty("hibernate.connection.driver_class"));
		properties.setProperty("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		// Logging
		properties.setProperty("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		properties.setProperty("hibernate.use_sql_comments", environment.getRequiredProperty("hibernate.use_sql_comments"));
		// Etc
		//properties.setProperty("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.setProperty("hibernate.enable_lazy_load_no_trans", environment.getRequiredProperty("hibernate.enable_lazy_load_no_trans"));
		properties.setProperty("hibernate.auto_close_session", environment.getRequiredProperty("hibernate.auto_close_session"));
		properties.setProperty("hibernate.cache.use_second_level_cache", environment.getRequiredProperty("hibernate.cache.use_second_level_cache"));
		properties.setProperty("hibernate.cache.use_query_cache", environment.getRequiredProperty("hibernate.cache.use_query_cache"));
		properties.setProperty("hibernate.generate_statistics", environment.getRequiredProperty("hibernate.generate_statistics"));
		properties.setProperty("net.sf.ehcache.configurationResourceName",
			environment.getRequiredProperty("hibernate.net.sf.ehcache.configurationResourceName"));
		properties.setProperty("hibernate.cache.region.factory_class", environment.getRequiredProperty("hibernate.cache.region.factory_class"));
		properties.setProperty("hibernate.jdbc.batch_size", environment.getRequiredProperty("hibernate.jdbc.batch_size"));
		//properties.setProperty("hibernate.connection.isolation", environment.getRequiredProperty("hibernate.connection.isolation"));
		return properties;
	}

}
