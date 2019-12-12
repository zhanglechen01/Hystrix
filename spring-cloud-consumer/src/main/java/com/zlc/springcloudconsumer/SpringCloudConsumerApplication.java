package com.zlc.springcloudconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker //开始断路器
public class SpringCloudConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConsumerApplication.class, args);
	}

}
