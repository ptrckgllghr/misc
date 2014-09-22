public class GenDemo<T> {

	private T data;

	/**
	 * @param data
	 */
	public GenDemo(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data.toString();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static void main(String[] args) {
		GenDemo<String> d1 = new GenDemo<String>("Hello");
		System.out.println(d1);

		GenDemo<Integer> d2 = new GenDemo<Integer>(1000);
		System.out.println(d2);
	}

}
