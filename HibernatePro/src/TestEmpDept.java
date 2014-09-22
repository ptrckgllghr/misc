import mv.dao.EmpDeptDao;
import mv.pojo.Department;
import mv.pojo.Employee;


public class TestEmpDept {

	public static void main(String[] args) {
		Department dept= new Department();
		dept.setDeptName("HR");
		dept.setLocation("New York");
		
		Employee emp1 = new Employee();
		emp1.setEmpName("Polo");
		emp1.setSalary(5000);
		emp1.setDept(dept);
		
		Employee emp2 = new Employee();
		emp2.setEmpName("Lili");
		emp2.setSalary(3500);
		emp2.setDept(dept);
		
		EmpDeptDao dao = new EmpDeptDao();
		dao.store(dept);
		dao.store(emp1);
		dao.store(emp2);
	}
}
