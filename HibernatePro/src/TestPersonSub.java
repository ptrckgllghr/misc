import mv.dao.EmpDeptDao;
import mv.sub.Customer;
import mv.sub.Employee;

public class TestPersonSub {

	public static void main(String[] args) {
		Customer c = new Customer();
		c.setName("Polo");
		c.setCredit(3000);
		
		Employee e = new Employee();
		e.setName("Mona");
		e.setSalary(4000);
		
		EmpDeptDao dao = new EmpDeptDao();
		dao.store(c);
		dao.store(e);	
	}

}
