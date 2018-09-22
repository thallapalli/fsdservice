package com.cts.osp.kt.fsd.fsdservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FsdController {
	@GetMapping("/fsd/{name}/greet")
	public String greetMe(@PathVariable String name) {
		return "Hello "+name;
	}

}
