package mv.dao;

import mv.pojo.Account;
import mv.pojo.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TxnAcntDao {

	private Session newSession() {
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		return factory.openSession();
	}

	public void createAccount(String holder, double balance) {
		Session session = newSession();
		Account ac = new Account(holder, balance);
		Transaction txn = new Transaction("OB", balance, balance);
		txn.setAcnt(ac);
		session.beginTransaction();
		session.save(ac);
		session.save(txn);
		session.getTransaction().commit();
		session.close();
	}

	public void accountDeposit(long accno, double amount) {
		Session session = newSession();
		session.beginTransaction();
		Account ac = (Account) session.load(Account.class, accno);
		ac.deposit(amount);
		Transaction txn = new Transaction("Cr", amount, ac.getBalance());
		txn.setAcnt(ac);

		session.update(ac);
		session.save(txn);
		session.getTransaction().commit();
		session.close();
	}

	public void accountWithdraw(long accno, double amount) {
		Session session = newSession();
		session.beginTransaction();
		Account ac = (Account) session.load(Account.class, accno);
		ac.withdraw(amount);
		Transaction txn = new Transaction("Dr", amount, ac.getBalance());
		txn.setAcnt(ac);

		session.update(ac);
		session.save(txn);
		session.getTransaction().commit();
		session.close();
	}
}
