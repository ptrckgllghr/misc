import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;


public class CalanderDemo {

	public static void main(String[] args) {

		
//		String[] zones = TimeZone.getAvailableIDs();
//		int count = 1;
//		for (String zone : zones) {
//			System.out.println(count + " " + zone);
//			count++;
//		}
//		Date dt = new Date();
//		System.out.println(dt);
		
		TimeZone zone = TimeZone.getTimeZone("CST");
		Calendar cal = new GregorianCalendar(zone);
//		System.out.println(cal.get(Calendar.HOUR));
				
//		Date d = new Date(System.currentTimeMillis());
//		Date d2 = new Date(cal.get(Calendar.MILLISECOND));
//		System.out.println(cal.toString());
	
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		System.out.println(nameOfMonth(cal.get(Calendar.MONTH)));		
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		
//		System.out.println(cal.get(Calendar.HOUR));
//		System.out.println(cal.get(Calendar.MINUTE));
//		System.out.println(cal.get(Calendar.SECOND));
//		System.out.println(cal.get(Calendar.AM_PM));
	}
	
	private static String nameOfMonth(int input)
	{
		switch(input)
		{
			case 0:
				return "January";
			case 1:
				return "Febuary";
			case 2:
				return "March";
			case 3:
				return "April";
			case 4:
				return "May";
			case 5:
				return "June";
			case 6:
				return "July";
			case 7:
				return "August";
			case 8:
				return "September";
			case 9:
				return "October";
			case 10:
				return "November";
			case 11:
				return "December";
			default:
				return "Invalid month";
		}
	}//end nameOfMonth
}
