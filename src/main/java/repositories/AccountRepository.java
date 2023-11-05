package repositories;

import java.math.BigDecimal;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import models.Account;

@Repository
public class AccountRepository {

	private final JdbcTemplate jdbc;
	
	public AccountRepository(JdbcTemplate template) {
		this.jdbc = template;
	}
	
	public Account findAccountById(long id) {
		
		String sql = "SELECT * FROM account WHERE id = ?";
		
		return jdbc.queryForObject(sql, new AccountRowMapper(), id);
		
	}
	
	public void changeAmount(long id, BigDecimal amount) {
		
		String sql = "UPDATE account SET amount = ? WHERE id = ?";
		
		jdbc.update(sql,amount,id);
		
	}
}
