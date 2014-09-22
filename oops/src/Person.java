

public class Person {
	private String name;
	private int age;
	
	
	public Person() {
		this("Unknown", -1);
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString()
	{
		return "Name " + name + "\t Age " + age;
	}
	
	private void print()
	{
		System.out.println("Name: " + name);
		System.out.println("Age:  " + age);
	}
	
	public boolean equals(Object obj)
	{
		if(obj instanceof Person)
		{
			Person p2 = (Person) obj;
			if (name.equals(p2.name) && age == p2.age)
				return true;
		}
		return false;
	}
	
	@Override
	public void finalize() throws Throwable
	{
		super.finalize();
		System.out.println("Person is no more");
	}
	
	public static void main(String[] args)
	{
		Person p = new Person("Polo", 21);
		p.print();
		Person p2 = new Person();
		p2.print();
		
		System.out.println(p.hashCode());
		System.out.println(p.equals(p2));	
		

		for (int c = 1; c <= 60000; c++)
			new Person();
		
		System.gc();
	}
	
	
	
}
