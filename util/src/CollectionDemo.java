import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class CollectionDemo {

	public static void main(String[] args) {
		ArrayList<String> alist = new ArrayList<String>();
		alist.add("Microsoft");
		alist.add("Oracle");
		alist.add("Apple");
		alist.add("HP");
		
		System.out.println("Printing with for loop");
		for (int i = 0; i < alist.size(); i++) {
			System.out.println(alist.get(i));
		}
		
		System.out.println("Printing with for each loop");
		for (String e : alist) {
			System.out.println(e);
		}
		
		System.out.println("Printing with iterator");
		Iterator<String> itr = alist.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
		LinkedList<String> list = new LinkedList<String>();
		list.add("Oracle");
		list.add("JBoss");
		list.add("Xerox");
		
		alist.addAll(list);
		
		System.out.println("--Merged--");
		itr = alist.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
		int index = alist.indexOf("HP");
		alist.add(index + 1, "IBM");
		
		System.out.println("Printing with for each loop");
		for (String e : alist) 
			System.out.println(e);
		
		alist.remove("Apple");
		
		System.out.println("Printing with for each loop");
		for (String e : alist) 
			System.out.println(e);
		
		alist.set(alist.indexOf("Xerox"), "Apple");
		
		System.out.println("Printing with for each loop");
		for (String e : alist) 
			System.out.println(e);
		
		HashSet<String> hset = new HashSet<String>(alist);
		
		
		System.out.println("--Hash set--");
		Iterator<String> itr2 = hset.iterator();
		while(itr2.hasNext())
			System.out.println(itr2.next());
		
		TreeSet<String> tset = new TreeSet<String>(hset);
		System.out.println("--Tree set--");
		Iterator<String> itr3 = tset.descendingIterator();
		while(itr3.hasNext())
			System.out.println(itr3.next());
	
	}
}
