package mv.annotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empx")
public class Employee2 {

	@Id
	@GeneratedValue
	private long emp_id;
	
	@Column(name = "empname", length = 20)
	private String empname;
	
	@Column(name = "salary")
	private double salary;

	public long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(long emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return empname;
	}

	public void setEmpname(String emp_name) {
		this.empname = emp_name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
