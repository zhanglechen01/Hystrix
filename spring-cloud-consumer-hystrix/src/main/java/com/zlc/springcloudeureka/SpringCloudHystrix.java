package com.zlc.springcloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * EnableEurekaClient注解和EnableDiscoveryClient注解可用可不用，
 * 不用也可以注册，只要添加了相关的依赖
 * spring-cloud-starter-netflix-eureka-client就会自动生效
 */
@SpringBootApplication
//@EnableEurekaClient //启动服务注册和发现服务
@EnableFeignClients //启动feign进行远程调用
//@EnableDiscoveryClient
@EnableCircuitBreaker //开启断路器 hystrix
public class SpringCloudHystrix {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHystrix.class, args);
	}

}
