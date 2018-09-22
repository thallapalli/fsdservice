package com.cts.osp.kt.fsd.fsdservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cts.osp.kt.fsd.fsdservice.entity.Account;
import com.cts.osp.kt.fsd.fsdservice.repository.AccountRepository;

@RestController
public class FsdController {
	@Autowired
	AccountRepository accountRepository;
	
	@GetMapping("/fsd/{name}/greet")
	public String greetMe(@PathVariable String name) {
		return "Hello "+name;
	}
	@GetMapping("/fsd/resource/allaccounts")
	public List<Account> getAllAccounts() {
		accountRepository.findAll();
		return (List<Account>) accountRepository.findAll();
	}

}
