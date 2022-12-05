/*
package com.backend.ecommerce.batch;

import com.backend.ecommerce.entity.Product;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;*/
/*
@Component
public class ProductReader extends FlatFileItemReader<Product> implements ItemReader<Product>{

    public ProductReader() {
		setResource(new FileSystemResource("data/input.csv"));
        setLinesToSkip(1);
        setLineMapper(getDefaultLineMapper());
    }

    public DefaultLineMapper<Product> getDefaultLineMapper() {
        DefaultLineMapper<Product> defaultLineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer delimitedLineTokenizer =new DelimitedLineTokenizer();
        delimitedLineTokenizer.setNames(new String[] { "name","price","quantity","category","imageUrl" });
        defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);

        BeanWrapperFieldSetMapper<Product> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(Product.class);
        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

        return defaultLineMapper;
    }
}
*/
