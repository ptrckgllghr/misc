package mv.annotation;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "account")
@SequenceGenerator(name = "acntSeq", sequenceName = "ACNT_SEQ")
public class Account {

	@Id
	@GeneratedValue(generator = "acntSeq")
	@Column(name = "acnt_no")
	//@SequenceGenerator() should be used to initialize database at a certain value
	private long acntNo;

	@Column(length = 20)
	private String holder;
	private double balance;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "acnt_no")
	private Set<Transaction> transactions;

	// default constructor
	public Account() {
	}

	// parameterized constructor
	public Account(String holder, double balance) {
		this.holder = holder;
		this.balance = balance;
		// Instantiating Transaction for adding account opening transaction
		Transaction txn = new Transaction("Opening Balance", balance,
				getBalance());
		// Setting this(account) to txn object for database foreign key
		// reference
		txn.setAcnt(this);
		// Instantiating Transaction Set for the first time use
		transactions = new HashSet<Transaction>();
		// Adding txn object to Set of transaction
		getTransactions().add(txn);
	}

	// BL method to deposit amount
	public void deposit(double amount) {
		setBalance(getBalance() + amount);
		// Instantiating Transaction for adding account credit transaction
		Transaction txn = new Transaction("Credit", amount, getBalance());
		// Setting this(account) to txn object for database foreign key
		// reference
		txn.setAcnt(this);
		// Getting all transactions of this account and adding credit
		// transaction
		getTransactions().add(txn);
	}

	// BL method to withdraw amount, throw exception if exceeds balance
	public void withdraw(double amount) throws BalanceException {
		if (amount <= getBalance()) {
			setBalance(getBalance() - amount);
			// Instantiating Transaction for adding account debit transaction
			Transaction txn = new Transaction("Debit", amount, getBalance());
			// Setting this(account) to txn object for foreign key reference
			txn.setAcnt(this);
			// Getting all transactions of this account and adding debit
			// transaction
			getTransactions().add(txn);
		} else {
			// Throwing BalanceException if withdraw amount is more than balance
			BalanceException exception = new BalanceException(
					"Insufficient fund!");
			throw exception;
		}
	}

	public long getAcntNo() {
		return acntNo;
	}

	public void setAcntNo(long acntNo) {
		this.acntNo = acntNo;
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

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
}
