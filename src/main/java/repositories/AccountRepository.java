package repositories;

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
}
