import mv.pojo.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class GetEmp {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		Employee emp = (Employee) session.get(Employee.class, 1);
		System.out.println(emp.getEmpName());
		
		emp.setSalary(5500);
		session.update(emp);
		txn.commit();
		
		session.close();
	}
}
