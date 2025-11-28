package com.example.zej;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class })
@EnableMongoRepositories
public class ZejApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZejApplication.class, args);
	}

}
