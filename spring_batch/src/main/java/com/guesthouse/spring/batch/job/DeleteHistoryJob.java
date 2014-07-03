package com.guesthouse.spring.batch.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.guesthouse.spring.batch.config.BatchConfiguration;
import com.guesthouse.spring.batch.config.DataSourceConfiguration;

@Configuration
public class DeleteHistoryJob {
	
	protected static Logger log = LoggerFactory.getLogger(DeleteHistoryJob.class);

	private static final String SQL_DELETE_ITEM = "DELETE FROM powerbook_etc WHERE date = ?";

	private static final String SQL_DELETE_ACCESSORY = "DELETE FROM powerbook_accessory WHERE date = ?";

	private static final String SQL_DELETE_UNIFYITEM = "DELETE FROM powerbook_unifyitem WHERE date = ?";

	@Autowired
	private StepBuilderFactory stepBuilders;

	@Autowired
	private JobBuilderFactory jobBuilders;

	@Autowired
	private BatchConfiguration batchConfig;

	@Autowired
	private DataSourceConfiguration dataConfig;

	private JdbcTemplate jdbcTemplate;


	@Bean(name = "deleteHistoryFromDbJob")
	public Job job() {
		return jobBuilders.get("deleteHistoryFromDbJob").listener(batchConfig.customJobExecutionListener()).start(
			step()).build();
	}

	@Bean(name = "deleteHistoryFromDbStep")
	public Step step() {
		return stepBuilders.get("deleteHistoryFromDbStep").tasklet(this.tasklet()).build();
	}

	@Bean
	protected Tasklet tasklet() {
		return new Tasklet() {
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext context) {

				int totalCount = 0;
				//삭제일 기준은 3일전
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DAY_OF_MONTH, -2);
				String historyDate = convertString(calendar);

				
				JobParameters jobParameters = context.getStepContext().getStepExecution().getJobParameters();

				if (jobParameters.isEmpty()) {
					log.info("{}", "No job parameters!");
				} else {
					
					for (Map.Entry<String, JobParameter> param : jobParameters.getParameters().entrySet()) {
						
						if (param.getKey().contains("deleteDate")) {
							historyDate =  String.format("%s", param.getValue());
						}						
					}
				}
			
				log.info("{}", "######################################");
				log.info("delete history : date = {}", historyDate);

				jdbcTemplate = new JdbcTemplate(dataConfig.dataSource());

				int rowCount = jdbcTemplate.update(SQL_DELETE_ACCESSORY, historyDate);
				totalCount += rowCount;

				log.info("Accessory {}", rowCount ," rows Deleted ...");

				log.info("Item {}", rowCount, " rows Deleted ...");

				rowCount = jdbcTemplate.update(SQL_DELETE_UNIFYITEM, historyDate);
				totalCount += rowCount;

				log.info("UnifyItem {}", rowCount, " rows Deleted ...");
				log.info("{}","######################################");
				log.info("Total {}", totalCount, " rows Deleted ...");
				contribution.incrementWriteCount(totalCount);
				return RepeatStatus.FINISHED;
			}
		};

	}

	private String convertString(Calendar calendar) {
		TimeZone zone = TimeZone.getTimeZone("Asia/Seoul");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		sdf.setTimeZone(zone);
		return sdf.format(calendar.getTime());
	}

}
