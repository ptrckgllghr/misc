

public abstract class Employee {
	private int empNo;
	private String empName;
	private double salary;

	private static int autogen = 101;
	
	/**
	 * @param empNo
	 * @param empName
	 * @param salary
	 */
	public Employee(String empName, double salary) 
	{
		this.empNo = autogen++;
		this.empName = empName;
		this.salary = salary;
	}
	
	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee() 
	{
		this("Unknown", -1.0);
	}
	
	public void payslip()
	{
		System.out.println("Employee ID Number : " + empNo);
		System.out.println("Employee Name      : " + empName);
		System.out.println("Employee salary    : " + salary);
	}
	

}
