package com.pjgallagher.bank;

public class Transaction {
	
	private String transactionType;
	private double transactionAmount, balance;
	/**
	 * @param transactionType
	 * @param transactionAmount
	 * @param balance
	 */
	
	public Transaction(String transactionType, double transactionAmount, double balance) 
	{
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.balance = balance;
	}
	
	public Transaction()
	{
		this("Unknown", 0, 0);
	}
	
	public void print()
	{
		System.out.println("Transaction type  : " + transactionType);
		System.out.println("Transaction amount: " + transactionAmount);
		System.out.println("New Balance       : " + balance + "\n");
	}
}
