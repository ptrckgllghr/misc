

public class Manager extends Employee {
	private double bonus;

	public Manager(String empName, double salary, double bonus) {
		super(empName, salary);
		this.bonus = bonus;
	}

	public Manager() {
		super();
	}

	@Override
	public void payslip() {
		super.payslip();
		System.out.println("Bonus: " + bonus);
	}
	
	public double getTotal()
	{
		return getSalary() + bonus;
	}

	public static void main(String args[])
	{
		Manager m1 = new Manager("Bob McBobinson", 50000, 5000);
		m1.payslip();
	}
	
	
}
