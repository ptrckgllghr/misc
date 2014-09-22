package com.pjgallagher.bank;

public interface Banking {

	void deposit(double amout);
	
	void withdraw(double amount) throws BalanceException;
	
	void summary();
	
	void statement();
}
