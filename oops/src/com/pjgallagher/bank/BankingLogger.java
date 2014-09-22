package com.pjgallagher.bank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

final class BankingLogger {

	public void log(int accountNo, String transType, double amount)
			throws IOException {
		TimeZone zone = TimeZone.getTimeZone("EST");// sets time zone to east
													// coast
		Calendar cal = new GregorianCalendar(zone); //
		String dateStamp = dayOfWeek(cal.get(Calendar.DAY_OF_WEEK))
				+ nameOfMonth(cal.get(Calendar.MONTH))
				+ Integer.toString(cal.get(Calendar.DAY_OF_MONTH)) + "-"
				+ Integer.toString(cal.get(Calendar.YEAR));
		//System.out.println(dateStamp);

		String log = "C:\\" + dateStamp + "log.txt";
		System.out.println(log);
		File f = new File(log);

		if (f.exists()) {// append if f already exists
			BufferedWriter writer = new BufferedWriter(
					new FileWriter(log, true));
			writer.write("Account Number: " + accountNo + " Transaction: "
					+ transType + " Amount : " + amount);
		}
		else
		{
			BufferedWriter writer = new BufferedWriter(
					new FileWriter(log));
			writer.write("Account Number: " + accountNo + " Transaction: "
					+ transType + " Amount : " + amount);
		}

		// String logFile = "banklogs.txt";
		// Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("EST"));
		// FileInputStream fstream = new FileInputStream("src/banklogs.txt");
		// Properties p = new Properties();
		// p.load(fstream);
		//
		// Set props = p.keySet();
		// for (Object prop : props)
		// System.out.println(prop.toString());
	}

	public static void main(String[] args) throws IOException {
		BankingLogger bl = new BankingLogger();
		bl.log(1, "type", 1.0);
	}

	private static String nameOfMonth(int input) {
		switch (input) {
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
	}// end nameOfMonth

	/**
	 * takes in a number between 1 and 7 and returns a String of its
	 * corresponding name
	 * 
	 * @param input
	 * @return String of name of day of the week
	 */
	private static String dayOfWeek(int input) {
		switch (input) {
		case 1:
			return "Sunday";
		case 2:
			return "Monday";
		case 3:
			return "Tuesday";
		case 4:
			return "Wednesday";
		case 5:
			return "Thursday";
		case 6:
			return "Friday";
		case 7:
			return "Saturday";
		default:
			return "Invalid day";
		}
	}// end dayOfWeek
}
