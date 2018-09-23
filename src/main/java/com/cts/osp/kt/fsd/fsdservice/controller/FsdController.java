package com.cts.osp.kt.fsd.fsdservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.osp.kt.fsd.fsdservice.entity.Account;
import com.cts.osp.kt.fsd.fsdservice.entity.FsdUser;
import com.cts.osp.kt.fsd.fsdservice.exception.FSDResourceNotFoundException;
import com.cts.osp.kt.fsd.fsdservice.repository.AccountRepository;

import com.cts.osp.kt.fsd.fsdservice.validator.UserValidator;


public class FsdController {
	@Autowired
	AccountRepository accountRepository;
	
	
	@GetMapping("/{name}/greet")
	public String greetMe(@PathVariable String name) {
		return "Hello "+name;
	}
	@GetMapping("/allaccounts")
	public List<Account> getAllAccounts() {
		accountRepository.findAll();
		return (List<Account>) accountRepository.findAll();
	}
	@PutMapping("/account/save")
	public Account saveAll(@Valid @RequestBody Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}
	@PostMapping("/account/update")
	public Account updateAccount(@Valid @RequestBody Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}
	@GetMapping("/account/{id}")
	public Account getAccountById(@PathVariable(value = "id") Long id) {
	    return accountRepository.findById(id)
	            .orElseThrow(() -> new FSDResourceNotFoundException("Account", "id", id));
	}
	



}
