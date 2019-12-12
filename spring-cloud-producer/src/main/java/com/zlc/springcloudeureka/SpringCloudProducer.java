package com.zlc.springcloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient //启动服务注册和发现服务
//@EnableDiscoveryClient
public class SpringCloudProducer {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudProducer.class, args);
	}

}
