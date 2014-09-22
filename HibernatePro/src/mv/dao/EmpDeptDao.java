package mv.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class EmpDeptDao {

	public void store(Object obj)
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction txn = session.getTransaction();
		
		txn.begin();
		session.saveOrUpdate(obj);
		txn.commit();
		session.close();
	}
	
}
