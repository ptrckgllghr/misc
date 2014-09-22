package com.pjgallagher.bank;

import java.util.ArrayList;

public abstract class Account implements Banking{
	
	private String holderName;
	private double balance;
	private int acntNum;
	protected int index;
	protected ArrayList<Transaction> transactions;
	
	private static int autogen = 101;
	
	/**
	 * @param holderName
	 * @param balance
	 */
	public Account(String holderName, double balance) 
	{
		this.holderName = holderName;
		this.balance = balance;
		this.acntNum = autogen++; 
		transactions = new ArrayList<Transaction>();
		index = 0;
		BankingLogger bl = new BankingLogger();
	}
	
	public Account()
	{
		this("Unknown", 0);
	}
	
	public void summary()
	{
		System.out.println("Account holder : " + holderName);
		System.out.println("Account number : " + acntNum);
		System.out.println("Account balance: " + getBalance());
		System.out.println("");
	}
	
	/**
	 *
	 * @param type
	 * @param amount
	 */
	public void recordTransaction(String type, double amount)
	{
		transactions.add(new Transaction(type, amount, getBalance()));
	}
	
	public void deposit(double amount)
	{
		setBalance(getBalance() + amount);
		recordTransaction("deposit", amount);
	}
	
	public abstract void withdraw(double amount) throws BalanceException;

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}
	
}
