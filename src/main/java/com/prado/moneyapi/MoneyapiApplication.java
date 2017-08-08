package com.prado.moneyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.prado.moneyapi.config.property.MoneyApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(MoneyApiProperty.class)
public class MoneyapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneyapiApplication.class, args);
	}
}
