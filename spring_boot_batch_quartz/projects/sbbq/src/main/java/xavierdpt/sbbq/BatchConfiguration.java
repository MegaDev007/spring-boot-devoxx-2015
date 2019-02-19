package xavierdpt.sbbq;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import xavierdpt.sbbq.items.CustomItemReader;
import xavierdpt.sbbq.items.CustomItemWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public CustomItemReader reader() {
		return new CustomItemReader();
	}

	@Bean
	public CustomItemWriter writer() {
		return new CustomItemWriter();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").chunk(10).reader(reader()).writer(writer()).build();
	}
	
	@Bean
	public Job testJob() {
		return jobBuilderFactory.get("testJob").incrementer(new RunIdIncrementer()).flow(step1()).end().build();
	}
}
