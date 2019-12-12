package com.zlc.springcloudconsumer.controller;

import com.zlc.springcloudconsumer.service.HelloRemote;
import com.zlc.springcloudconsumer.service.HelloRemoteTimeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @描述
 * @创建人 zhang
 * @创建时间 2019/12/9
 */
@RestController
public class ConsumerController {

	@Autowired
	HelloRemote helloRemote;
	@Autowired
	HelloRemoteTimeout helloRemoteTimeout;

	@RequestMapping("/hello/{name}")
	public String index(@PathVariable("name") String name){
		return helloRemote.hello2(name);
	}

	@RequestMapping("/hellotimeout/{name}")
	public String hellotimeout(@PathVariable("name") Long count){
		return helloRemoteTimeout.helloTimeout(count);
	}

}
