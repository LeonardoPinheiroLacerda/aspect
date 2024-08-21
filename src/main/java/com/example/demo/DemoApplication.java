package com.example.demo;

import com.example.demo.dummy.DummyService;
import com.example.demo.hello.HelloService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	ApplicationRunner applicationRunner(HelloService helloService, DummyService dummyService) {
		return args -> {
			helloService.hello();
			dummyService.dummy();
		};
	}

}
