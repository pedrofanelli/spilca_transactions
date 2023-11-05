package controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import models.Account;
import models.TransferRequest;
import service.TransferService;

@RestController
public class AccountController {

	private final TransferService service;
	
	public AccountController(TransferService service) {
		this.service = service;
	}
	
	@PostMapping("/transfer")
	public void transferMoney(@RequestBody TransferRequest request) {
		
		service.transferMoney(request.getSenderId(), request.getReceiverId(), request.getAmount());
		
	}
	
	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		return service.getAllAccounts();
	}
}
