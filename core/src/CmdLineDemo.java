
public class CmdLineDemo {

	public static void main(String[] args){
		for (int i = 0; i < args.length; i++){
			System.out.println(args[i]);
		}
		String days = "Sun-Mon-Tue-Wed-Thu-Fri-Sat";
		String[] week = days.split("-");
		for (int i = 0; i < week.length; i++)
			System.out.println(week[i]);
	}
}
