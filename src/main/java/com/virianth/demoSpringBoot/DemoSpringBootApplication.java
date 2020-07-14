package com.virianth.demoSpringBoot;

import com.virianth.hibernate.tests.TestEmpleados;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/hello2")
	public String hello2(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello2 %s!", name);
	}

	@GetMapping("/testEmpleados")
	public String testEmpleados(@RequestParam(value = "name", defaultValue = "World") String name) {
		boolean correct = TestEmpleados.executeAll();

		if (correct) return String.format("Hello correct %s!", name);
		return String.format("Hello INcorrect %s!", name);
	}

}
