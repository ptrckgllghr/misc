

public class TestEmployee {

	public static void main(String args[])
	{
		Manager ex = new Manager("Polo", 5000, 1200);
		
		
		
		showSalary(ex);
	}

	private static void showSalary(Employee emp) {
		if (emp instanceof Manager)
			System.out.println("Manager Salary: " + emp.getSalary());
		
	}
	
	
}
