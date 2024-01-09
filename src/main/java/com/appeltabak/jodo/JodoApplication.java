package com.appeltabak.jodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class JodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JodoApplication.class, args);

		LabelResource labelResource = new LabelResource("green");
		System.out.println(labelResource.hashCode());
	}

	@RequestMapping("/")
	public String home() {
		return "Yolo";
	}
}
