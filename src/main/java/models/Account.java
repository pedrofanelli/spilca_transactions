package models;

import java.math.BigDecimal;

public class Account {

	private long id;
	private String name;
	private BigDecimal amount;
	
	public long getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public BigDecimal getAmount() {
		return this.amount;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
}
