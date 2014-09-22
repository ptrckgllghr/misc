import mv.annotation.Employee2;
import mv.dao.EmpDeptDao;

public class TestEmployeeSub {

	public static void main(String[] args) {
		
		Employee2 e = new Employee2();
		e.setEmpname("Jim Miller");
		e.setSalary(2000);
		
		EmpDeptDao dao = new EmpDeptDao();
		dao.store(e);
	}
}
