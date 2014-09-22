import java.util.TreeSet;


public class SortedPerson {

	public static void main(String[] args) {
		PersonComparator pc = new PersonComparator();
		TreeSet<Person> tree = new TreeSet<Person>(pc);
		
		tree.add(new Person("Polo", 21));
		tree.add(new Person("Lili", 19));
		tree.add(new Person("Mili", 20));
		
		for (Person person : tree)
			System.out.println(person);
	}
}
