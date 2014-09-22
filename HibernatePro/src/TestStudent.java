
import mv.annotation.Student;
import mv.dao.EmpDeptDao;

public class TestStudent {

	public static void main(String[] args) {
		
		Student s = new Student();
		s.setName("Andy");
		
		EmpDeptDao dao = new EmpDeptDao();
		dao.store(s);
	}

}
