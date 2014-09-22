package mv.annotation;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public final class BankingService {
	private SessionFactory factory;

	// Constructor building SessionFactory
	private BankingService() {
		factory = new Configuration().configure().buildSessionFactory();
	}

	// Factory method to get BankingService object
	public static BankingService getService() {
		return new BankingService();
	}

	// Method to open account
	public void openAccount(String holder, double balance) {
		Session session = factory.openSession();
		Transaction hibTxn = session.getTransaction();
		try {
			hibTxn.begin();

			Account acnt = new Account(holder, balance);

			session.save(acnt);
			hibTxn.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			hibTxn.rollback();
		} finally {
			session.close();
		}
	}

	// Method to deposit amount in account
	public void depositAmount(long acntNo, double amount) {
		Session session = factory.openSession();
		Transaction hibTxn = (Transaction) session.getTransaction();

		try {
			hibTxn.begin();

			Account acnt = (Account) session.load(Account.class, acntNo);
			acnt.deposit(amount);

			session.save(acnt);
			hibTxn.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			hibTxn.rollback();
		} finally {
			session.close();
		}
	}

	// Method to withdraw amount from account
	public void withdrawAmount(long acntNo, double amount) {
		Session session = factory.openSession();
		Transaction hibTxn = session.getTransaction();

		try {
			hibTxn.begin();

			Account acnt = (Account) session.load(Account.class, acntNo);
			acnt.withdraw(amount);

			session.save(acnt);
			hibTxn.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			hibTxn.rollback();
		} catch (BalanceException e) {
			e.printStackTrace();
			hibTxn.rollback();
		} finally {
			session.close();
		}
	}
}
