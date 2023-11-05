package service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import models.Account;
import repositories.AccountRepository;

@Service
public class TransferService {

	private final AccountRepository repo;
	
	public TransferService(AccountRepository repo) {
		this.repo = repo;
	}
	
	@Transactional(rollbackFor=SQLException.class)
	public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {

		Account sender = repo.findAccountById(idSender);
		Account receiver = repo.findAccountById(idReceiver);
		
		BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
		BigDecimal receiverNewAmount = receiver.getAmount().add(amount);
		
		repo.changeAmount(idSender, senderNewAmount);
		repo.changeAmount(idReceiver, receiverNewAmount);
		
	}
	
	public List<Account> getAllAccounts() {
		return repo.findAllAccounts();
	}
}
