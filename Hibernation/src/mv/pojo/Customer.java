package mv.pojo;

public class Customer {

	private int custId;
	private String custName;
	private double creditLimit;

	/**
	 * @param custName
	 * @param creditLimit
	 */
	public Customer(String custName, double creditLimit) {
		this.custName = custName;
		this.creditLimit = creditLimit;
	}

	/**
	 * 
	 */
	public Customer() {
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
}