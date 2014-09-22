import com.pjgallagher.bank.AccountFactory;
import com.pjgallagher.bank.BalanceException;
import com.pjgallagher.bank.Banking;


public class TestAccount {

	public static void main(String args[]) throws BalanceException
	{
		Banking a1 = AccountFactory.createAccount("Dude", "Saving");
		
		try{
			a1.withdraw(50);
		}
		catch (BalanceException e){
			e.printStackTrace();
			System.out.println(e);
			System.out.println(e.getMessage());
		}
	}
	
}

//