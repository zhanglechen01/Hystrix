package com.zlc.springcloudeureka.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.zlc.springcloudeureka.serviceImp.HelloRemoteImp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @描述
 * @创建人 zhang
 * @创建时间 2019/12/9
 */
//就是spring.application.name中的名字
@FeignClient(name="spring-cloud-producer",fallback = HelloRemoteImp.class)//name是远程提供服务器的名称
public interface HelloRemote {
	@RequestMapping(value = "/hello")
	 String hello(@RequestParam(value = "name") String name);
}
