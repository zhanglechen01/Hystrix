package com.zlc.springcloudeureka.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @描述
 * @创建人 zhang
 * @创建时间 2019/12/9
 */
@RestController
public class ConsumerController {

	@RequestMapping("/hello")
	public String index(@RequestParam String name){
		return "hello"+name+",this is first message";
	}

	@RequestMapping("/hellotimeout")
	public String helloTimeout(@RequestParam Long count){
		try {
			Thread.sleep(count);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "helloTimeout:"+count+",this is first message";
	}

}
