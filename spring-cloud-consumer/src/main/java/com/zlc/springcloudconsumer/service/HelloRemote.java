package com.zlc.springcloudconsumer.service;

import com.zlc.springcloudconsumer.serviceImp.HelloRemoteImp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @描述
 * @创建人 zhang
 * @创建时间 2019/12/9
 */
@FeignClient(name="spring-cloud-producer2",fallback = HelloRemoteImp.class)//name是远程提供服务器的名称
//就是spring.application.name中的名字
public interface HelloRemote {
	@RequestMapping(value = "/hello")
	public String hello2(@RequestParam(value = "name") String name);
}
