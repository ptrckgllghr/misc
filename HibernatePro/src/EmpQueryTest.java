
import java.util.List;

import mv.pojo.Employee;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class EmpQueryTest {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		List<Employee> employees = null;
		
		//Hibernate Query Example
		Query query = session.createQuery("from Employee where salary > 3000");
		employees = query.list();
		for (Employee emp : employees)
			System.out.println(emp.getEmpName());
		
		//Hibernate Criteria Example
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.between("salary", 3000.0, 5000.0));
		criteria.add(Restrictions.like("empName", "S%"));
		employees = criteria.list();
		for(Employee emp : employees)
			System.out.println(emp.getEmpName());
	}
}