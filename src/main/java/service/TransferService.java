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
	
	
	/*
	 * Las transacciones en Spring toman toda runtimeException, pero NO checkedException.
	 * Las checked son las de compilación, que normalmente se declaran y se hacen throw o en try/catch.
	 * Si uno quisiera hacer rollback también en esos casos debemos declararlo expresamente como hicimos con SQLExceptions.
	 * Además, el método debe lanzarlo!
	 * Si no lo agregamos a la notation, no funciona el rollback.
	 */
	@Transactional(rollbackFor= {SQLException.class,Exception.class})
	public void transferMoney(long idSender, long idReceiver, BigDecimal amount) throws SQLException {

		Account sender = repo.findAccountById(idSender);
		Account receiver = repo.findAccountById(idReceiver);
		
		BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
		BigDecimal receiverNewAmount = receiver.getAmount().add(amount);
		
		repo.changeAmount(idSender, senderNewAmount);
		repo.changeAmount(idReceiver, receiverNewAmount);
		
		//throw new RuntimeException("OH NO! UNA RUNTIME EXCEPTION! ROLLBACK!!!");
		
	}
	
	public List<Account> getAllAccounts() {
		return repo.findAllAccounts();
	}
}
