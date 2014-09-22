import static java.lang.Math.*;
import static java.lang.System.*;

public class MustangDemo {

	public static void main(String[] args) {
		int[] num = { 10, 20, 30, 40, 50 };
		for (int i : num) {
			System.out.println(i);
		}

		showDays("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");

		out.println(max(10, 20));

		String s = "10";

		int x = Integer.parseInt(s);

		// int x = 10;
		// Integer y = new Integer(20);
		// int z = x + y.intValue();
		Integer y = 20;
		int z = x + y;
		System.out.println(z);
	}

	private static void showDays(String... week) {
		for (String day : week) {
			out.println(day);
		}
	}
}
