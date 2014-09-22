package com.pjgallagher.bank;
/**
 * 
 */

/**
 * @author Patrick Gallagher
 *
 */
public class Saving extends Account {

	/**
	 * @param holderName
	 * @param balance
	 */
	public Saving(String holderName) {
		super(holderName, 50);
	}

	@Override
	public void withdraw(double amount) throws BalanceException 
	{
		if (testMinBalance(amount))
			setBalance(getBalance() - amount);
		else
			System.out.println("Withdrawl this size would put balance under minimum");
		transactions.add(new Transaction("DR", amount, getBalance()));
	}
	
	private boolean testMinBalance(double amount)
	{
		if (getBalance() - amount >= 50)//if the balance minus the amount is greater than the min balance
			return true;
		return false;
	
	}

	@Override
	public void statement() {
		// TODO Auto-generated method stub
		
	}

}
