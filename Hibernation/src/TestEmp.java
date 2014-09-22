import mv.pojo.Customer;
import mv.pojo.Employee;

public class TestEmp {
	public static void main(String[] args) {
		MyDao.store(new Employee("Hank", 700));
		MyDao.store(new Customer("Skylar", 600));
	
		for (int i = 0; i < 10000; i++)
			MyDao.store(new Customer("Jon Smith is a cunt", i));
	}
}
