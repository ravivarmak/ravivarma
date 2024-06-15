package ravi.varma.logs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MyLogController {
	@GetMapping("/hi")
	public String greet() {
		for(int i=0;i<10;i++)
		log.info("Hi How r u?");
		return "hi";
	}

}
