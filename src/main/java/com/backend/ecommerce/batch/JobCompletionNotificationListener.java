package com.backend.ecommerce.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductItemProcessor.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        LOGGER.info("Job started at: "+ jobExecution.getStartTime());
        LOGGER.info("Status of the Job: "+jobExecution.getStatus());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        LOGGER.info("Job Ended at: "+ jobExecution.getEndTime());
        LOGGER.info("Status of the Job: "+jobExecution.getStatus());
    }
}
