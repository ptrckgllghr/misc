import java.util.Random;

import mv.pojo.Customer;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestCust {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();

		Session session = factory.openSession();
		for (int i = 0; i < 10000; i++) {
			Random rand = new Random();
			Customer cust = new Customer("DudeNumber" + rand.nextInt(), rand.nextInt());

			Transaction txn = session.getTransaction();

			// save, persist, update, delete, load, get, saveorupdate
			// other useful methods

			try {
				txn.begin();
				session.save(cust);
				txn.commit();
			} catch (HibernateException e) {
				e.printStackTrace();
				txn.rollback();
			} finally {
				session.close();
			}
		}
	}
}
