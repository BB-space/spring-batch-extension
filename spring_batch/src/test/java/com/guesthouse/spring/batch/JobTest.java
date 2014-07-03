package com.guesthouse.spring.batch;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guesthouse.spring.batch.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("loc")
@ContextConfiguration(classes = {AppConfig.class})
public class JobTest {

	@Autowired
	private JobRegistry jobRegistry;

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private EntityManagerFactory emf;
	
	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	private JobParameters jobParameters;
	
	@Before
	public void setup(){
		jdbcTemplate = new JdbcTemplate(dataSource);
		jobParameters = new JobParametersBuilder().addLong("time",System.currentTimeMillis()).toJobParameters();
	}
	
	@Test
	public void testItemToDbJob() throws Exception {
		Job job = jobRegistry.getJob("itemXmlToDbJob");
		JobExecution jobExecution = jobLauncher.run(job, jobParameters);
		assertThat(BatchStatus.COMPLETED, is(jobExecution.getStatus()));

	}	

	@Test
	public void tesAccessoryToDbJob() throws Exception {
		Job job = jobRegistry.getJob("accessoryXmlToDbJob");
		JobExecution jobExecution = jobLauncher.run(job, jobParameters);
		assertThat(BatchStatus.COMPLETED, is(jobExecution.getStatus()));
	}
	
	@Test
	public void testUnifyItemToDbJob() throws Exception {
		Job job = jobRegistry.getJob("unifyItemXmlToDbJob");
		JobExecution jobExecution = jobLauncher.run(job, jobParameters);
		assertThat(BatchStatus.COMPLETED, is(jobExecution.getStatus()));		
	}		
	
	@Test
	public void testDeleteHistoryToDbJob() throws Exception {
		Job job = jobRegistry.getJob("deleteHistoryFromDbJob");
		JobExecution jobExecution = jobLauncher.run(job, jobParameters);
		assertThat(BatchStatus.COMPLETED, is(jobExecution.getStatus()));		
	}
	
}
