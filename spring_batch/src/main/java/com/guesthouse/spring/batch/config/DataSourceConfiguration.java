package com.guesthouse.spring.batch.config;

import javax.inject.Inject;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration(exclude={BatchAutoConfiguration.class})
@EnableTransactionManagement
@PropertySource("classpath:environment/application_${spring.profiles.active}.properties")
public class DataSourceConfiguration {

	private static final String DEFAULT_SCHEMA_LOCATION = "classpath:org/springframework/"	+ "batch/core/schema-@@platform@@.sql";

	private static final String DEFAULT_DROP_SCHEMA_LOCATION = "classpath:org/springframework/" + "batch/core/schema-drop-@@platform@@.sql";

	//private static final String POWERBOOK_SCHEMA_LOCATION = "classpath:schema-mysql-powerbook.sql";

	@Inject
	private Environment environment;

	@Inject
	private ResourceLoader resourceLoader;

	/*@PostConstruct
	protected void initialize() throws Exception {
		String platform = DatabaseType.fromMetaData(this.dataSource()).toString().toLowerCase();
		String schemaCreateLocation = this.environment.getProperty("schema",	  DEFAULT_SCHEMA_LOCATION); 
		//String schemaDropLocation = this.environment.getProperty("schema", DEFAULT_DROP_SCHEMA_LOCATION);
		//String schemaPowerBookLocation = this.environment.getProperty("schema",  POWERBOOK_SCHEMA_LOCATION); 
		schemaCreateLocation = schemaCreateLocation.replace("@@platform@@", platform);
		//schemaDropLocation = schemaDropLocation.replace("@@platform@@", platform);
		//schemaPowerBookLocation =   schemaPowerBookLocation.replace("@@platform@@", platform);
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		//populator.addScript(this.resourceLoader.getResource(schemaDropLocation));

		populator.addScript(this.resourceLoader.getResource(schemaCreateLocation));
		//populator.addScript(this.resourceLoader.getResource(schemaPowerBookLocation  )); 
		populator.setContinueOnError(true);
		DatabasePopulatorUtils.execute(populator, dataSource());
	}*/

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource dataSource = new DataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("default.ds.jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("default.ds.jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("default.ds.jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("default.ds.jdbc.password"));
		dataSource.setMaxActive(environment.getRequiredProperty("default.ds.jdbc.maxActive", int.class));
		dataSource.setMinIdle(environment.getRequiredProperty("default.ds.jdbc.minIdle", int.class));
		dataSource.setMaxIdle(environment.getRequiredProperty("default.ds.jdbc.maxIdle", int.class));
		dataSource.setMaxWait(environment.getRequiredProperty("default.ds.jdbc.maxWait", int.class));
		dataSource.setInitialSize(environment.getRequiredProperty("default.ds.jdbc.initialSize", int.class));
		dataSource.setValidationQuery(environment.getRequiredProperty("default.ds.jdbc.validationQuery"));
		dataSource.setValidationInterval(environment.getRequiredProperty("default.ds.jdbc.validationInterval",
			long.class));
		dataSource.setTestOnBorrow(environment.getRequiredProperty("default.ds.jdbc.testOnBorrow", boolean.class));
		dataSource.setTestWhileIdle(environment.getRequiredProperty("default.ds.jdbc.testWhileIdle", boolean.class));
		dataSource.setTimeBetweenEvictionRunsMillis(environment.getRequiredProperty(
			"default.ds.jdbc.timeBetweenEvictionRunsMillis", int.class));
		dataSource.setRemoveAbandoned(environment.getRequiredProperty("default.ds.jdbc.removeAbandoned", boolean.class));
		dataSource.setRemoveAbandonedTimeout(environment.getRequiredProperty("default.ds.jdbc.removeAbandonedTimeout",
			int.class));
		dataSource.setLogAbandoned(environment.getRequiredProperty("default.ds.jdbc.logAbandoned", boolean.class));
		dataSource.setAbandonWhenPercentageFull(environment.getRequiredProperty(
			"default.ds.jdbc.abandonWhenPercentageFull", int.class));
		dataSource.setJdbcInterceptors(environment.getRequiredProperty("default.ds.jdbc.jdbcInterceptors"));
		dataSource.setConnectionProperties(environment.getRequiredProperty("default.ds.jdbc.connectionProperties"));

		return dataSource;
	}
	
/*	@Bean
	public PlatformTransactionManager getTransactionManager() throws Exception {
		return new DataSourceTransactionManager(dataSource());
		//return new WebSphereUowTransactionManager();
	}*/




}
