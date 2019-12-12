package com.zlc.springcloudeureka.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.zlc.springcloudeureka.service.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @描述
 * @创建人 zhang
 * @创建时间 2019/12/9
 */
@RestController
public class ConsumerController {
	private static AtomicInteger countNumber = new AtomicInteger(1);

	@Autowired
	HelloRemote helloRemote;

	/**
	 * 测试Feign集成hystrix
	 * @param name
	 * @return
	 */
	@RequestMapping("/hello/{name}")
	public String index(@PathVariable("name") String name){
		return helloRemote.hello(name);
	}

	/**
	 * 测试超时降级
	 * @param count
	 * @return
	 */
	@RequestMapping("/test/{timeout}")
	@HystrixCommand(fallbackMethod = "timeoutFallback",
			commandProperties =
					{//设置超时时间为3秒
							@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
					})//默认超时时间是1s
	public String timeout(@PathVariable("timeout") Long count){
		try {
			Thread.sleep(count);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "正常返回的参数";
	}

	public String timeoutFallback(Long count){
		return  "请求超时之后放回的参数值";
	}

	/**
	 * 熔断测试
	 */
	@RequestMapping("/CircuitBreaker/{name}")
	@HystrixCommand(fallbackMethod = "breakerFallback",
			commandProperties = {
					//rolling windows的参数 hystrix.command.default.metrics.rollingStats.timeInMilliseconds = 10000（10s）默认值
					// 前提条件,默认10秒内请求数量达到20个就启动熔断器进行统计是否要开启熔断,这里在rolling window（10s）内至少的访问次数。
					@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD,
							value="12"),
					// 在满足上面的前提条件后，判断请求错误率大于50%（默认值）时就熔断，当请求符合熔断条件时将触发getFallback()。
					@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE,
							value="50"),
					// 当熔断策略开启后，延迟多久尝试再次允许新来的请求进行调用远程服务。默认为5秒。
					@HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS,
							value="10000")})
	public String CircuitBreaker(@PathVariable("name") String name){
		int cur = countNumber.getAndIncrement();
		System.out.println("走了一遍执行内容:"+cur);
		if(cur < 8 || cur > 18){
			System.out.println("执行错误的个数！");
			int i = 1/0;
		}
		return "正确的返回值";
	}

	public String breakerFallback(String name){
		return "熔断开始返回提示";
	}

}
