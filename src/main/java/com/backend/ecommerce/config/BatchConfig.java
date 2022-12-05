package com.backend.ecommerce.config;
/*
import java.io.IOException;

import com.backend.ecommerce.batch.ProductReader;
import com.backend.ecommerce.batch.ProductWriter;
import com.backend.ecommerce.entity.Product;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    ProductReader productReader;

    @Autowired
    ProductWriter productWriter;

    @Bean
    public Job readCSVFilesJob() {
        return jobBuilderFactory.get("readCSVFilesJob")
                .incrementer(new RunIdIncrementer())
                .flow(createStep()).end().build();
    }

    @Bean
    public Step createStep() {
        return stepBuilderFactory.get("SaleListStep")
                .<Product, Product>chunk(1)
                .reader(reader())
                .writer(productWriter)
                .build();
    }

    @Bean
    public ItemReader<Product> reader() {
        Resource[] resources = null;
        ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        try {
            resources = patternResolver.getResources("data/input.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        MultiResourceItemReader<Product> reader = new MultiResourceItemReader<>();
        reader.setResources(resources);
        reader.setDelegate(productReader);
        return reader;
    }
}
*/
