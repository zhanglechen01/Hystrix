package com.zlc.springcloudconsumer.serviceImp;

import com.zlc.springcloudconsumer.service.HelloRemote;
import com.zlc.springcloudconsumer.service.HelloRemoteTimeout;
import org.springframework.stereotype.Component;

/**
 * @描述
 * @创建人 zhang
 * @创建时间 2019/12/10
 */
@Component
public class HelloRemoteTimeoutImp implements HelloRemoteTimeout {
	@Override
	public String helloTimeout(Long name) {
		return "helloTimeOut出错了，hystrix机制进行控制";
	}
}
