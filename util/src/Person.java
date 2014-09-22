
public class Person //implements Comparable<Person>
{
	private String name;
	private int age;
	/**
	 * @param name
	 * @param age
	 */
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Person(){
		this.name = "Unknown";
		this.age = -1;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	

	public int getAge() {
		return age;
	}

//	@Override
//	public int compareTo(Person o) {
//		return this.age - o.age;
//	}
	
	
	
}
