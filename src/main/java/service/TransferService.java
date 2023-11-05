package service;

import org.springframework.stereotype.Service;

import repositories.AccountRepository;

@Service
public class TransferService {

	private final AccountRepository repo;
	
	public TransferService(AccountRepository repo) {
		this.repo = repo;
	}
	
	
}
