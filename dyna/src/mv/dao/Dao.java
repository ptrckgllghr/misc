package mv.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Dao {

	public static void store(Object obj) {
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();

		Session session = factory.openSession();
	
		Transaction txn = session.getTransaction();

		// save, persist, update, delete, load, get, saveorupdate
		// other useful methods

		try {
			txn.begin();
			session.save(obj);
			txn.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			txn.rollback();
		} finally {
			session.close();
		}
	}

}
