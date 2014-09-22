package com.pjgallagher.bank;

public class Checking extends Account {
	private double overdraft;
	/**
	 * 
	 */
	public Checking() {
		super();
	}

	/**
	 * @param holderName
	 * @param balance
	 */
	public Checking(String holderName) {
		super(holderName, 0);
		this.overdraft = 50;
	}
	
	@Override
	public void deposit(double amount)
	{
		overdraft += amount;
		if (overdraft > 50)
		{
			setBalance(overdraft - 50);
			overdraft = 50;
		}
		recordTransaction("deposit", amount);
	}

	@Override
	public void withdraw(double amount) throws BalanceException
	{
		if(amount <= (getBalance() + overdraft))
		{
			setBalance(getBalance() - amount);
		}
		transactions.add(new Transaction("DR", amount, getBalance()));
	}

	@Override
	public void statement() {
		// TODO Auto-generated method stub
		
	}
	
}
