/**
 * 
 */
package com.dargonbom.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author user
 * 通过加上@EnableRedisHttpSession注解，开启redis集中式session管理，所有的session都存放到了redis中
 */
@RestController
@EnableRedisHttpSession
@SpringBootApplication(scanBasePackages = { "com.dargonbom.cloud" })
@EnableTransactionManagement(proxyTargetClass = true)
public class Starter {

	public static final Logger log = LoggerFactory.getLogger(Starter.class);

	@RequestMapping("/")
	public String sayHello() {
		log.info("sssssssssssss");
		return "HELLO";
	}

	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);
	}
	
}
