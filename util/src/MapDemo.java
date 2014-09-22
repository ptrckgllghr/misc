import java.util.HashMap;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Jack", "Jill");
		map.put("Scott", "Tiger");
		map.put("Polo", "Lili");
		map.put("Jack", "Rose");

		System.out.println(map.get("Scott"));
		System.out.println(map.get("Polo"));
		System.out.println(map.get("Jack"));

		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key + " : " + map.get(key));
		}
	}
}
