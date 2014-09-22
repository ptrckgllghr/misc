package mv.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class EmployeeForm extends ActionForm {
	
	private String empName;
	private int empId;
	private double salary;
	
	/**
	 * @param empName
	 * @param salary
	 */
	public EmployeeForm(String empName, double salary) {
		this.empName = empName;
		this.salary = salary;
	}

	/**
	 * 
	 */
	public EmployeeForm() {
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		
		if(empName.length() < 1)
			errors.add("name", new ActionMessage("short.name"));
		if(salary < 2000 || salary > 5000)
			errors.add("salary", new ActionMessage("range.salary"));
		
		return errors;
	}
	
	
}
