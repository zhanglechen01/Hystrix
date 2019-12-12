package com.zlc.springcloudconsumer.serviceImp;

import com.zlc.springcloudconsumer.service.HelloRemote;
import org.springframework.stereotype.Component;

/**
 * @描述
 * @创建人 zhang
 * @创建时间 2019/12/10
 */
@Component
public class HelloRemoteImp implements HelloRemote {
	@Override
	public String hello2(String name) {
		return "出错了，hystrix机制进行控制";
	}
}
