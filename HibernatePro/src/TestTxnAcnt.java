import mv.dao.TxnAcntDao;


public class TestTxnAcnt {

	public static void main(String[] args) {
		TxnAcntDao dao = new TxnAcntDao();
		//dao.createAccount("Polo", 300);
		//dao.accountDeposit(1, 200);
		//dao.accountWithdraw(1, 50);
		
		dao.createAccount("Zubair", 10000);
		dao.accountDeposit(2, 15000);
		dao.accountWithdraw(2, 100);
	}

}
