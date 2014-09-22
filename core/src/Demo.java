public class Demo {

	private Object data;

	/**
	 * @param data
	 */
	public Demo(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data.toString();
	}

	public static void main(String[] args) {
		Demo d1 = new Demo("Test");
		d1.setData(500);
		System.out.println(d1);

		Demo d2 = new Demo(1000);
		d2.setData("Hello");
		System.out.println(d2);
	}

}
