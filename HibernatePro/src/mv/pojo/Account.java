package mv.pojo;

import java.util.Set;

public class Account {
	private long accNo;
	private String holder;
	private double balance;

	private Set<Transaction> txns;

	public Account() {
	}

	public Account(String holder, double balance) {
		this.holder = holder;
		this.balance = balance;
	}

	// getters/setters
	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Set<Transaction> getTxns() {
		return txns;
	}

	public void setTxns(Set<Transaction> txns) {
		this.txns = txns;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {
		if (balance >= amount)
			balance -= amount;
		else
			System.out.println("Insufficient fund!!!");
	}
}
