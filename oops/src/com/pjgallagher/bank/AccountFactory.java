package com.pjgallagher.bank;

public final class AccountFactory {

	private AccountFactory()
	{
		
	}
	
	public static Banking createAccount(String holder, String acType)
	{
		Banking account = null;
		if(acType.equalsIgnoreCase("savings"))
			account = new Saving(holder);
		else
			account = new Checking(holder);
		return account;
	}
}
