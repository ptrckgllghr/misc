package homework1;
//Patrick Gallagher
import java.util.ArrayList;

public class SchoolDirectory {

	public ArrayList<CourseEntry> schoolDir;

	/**
	 * Constructor for CourseEntry
	 * creates sequence of predetermined CourseEntries
	 */
	public SchoolDirectory() {
		schoolDir = new ArrayList<CourseEntry>();
		addCourseEntry(new CourseEntry("Algebra", 64050));
		addCourseEntry(new CourseEntry("Ballet", 73156));
		addCourseEntry(new CourseEntry("Communication", 90102));
		addCourseEntry(new CourseEntry("French", 46101));
		addCourseEntry(new CourseEntry("History", 58100));
		addCourseEntry(new CourseEntry("IntroComputing", 25210));
		addCourseEntry(new CourseEntry("Management", 20309));
		addCourseEntry(new CourseEntry("Physics", 75201));	
	}
	
	/**
	 * adds a new CourseEntry to the school directory 
	 * @param newCourseEntry
	 */
	public void addCourseEntry(CourseEntry newCourseEntry)
	{
		schoolDir.add(newCourseEntry);
	}
	
	/**
	 * scans through courseEntry arrayList to find course through id Num
	 * returns null if not found
	 * @param idNum
	 * @return CourseEntry
	 */
	public CourseEntry findCourseEntry(int idNum)
	{
		for (CourseEntry e: schoolDir)
		{
			if (e.getIdNum() == idNum)
				return e;		
		}
		return null;
	}
	/**
	 * scans through courseEntry arrayList to find course through Name
	 * returns null if not found
	 * @param name
	 * @return CourseEntry with name : name
	 */
	public CourseEntry findCourseEntry(String name)
	{
		String tempName = padRight(name, 15);  //adjusts for the designated size of CourseEntry name Strings
		for (CourseEntry e: schoolDir)
		{
			if (e.getName().equalsIgnoreCase(tempName))
				return e;		
		}
		return null;
	}
	
	/**
	 * finds the name of the course entry by it's unique id number
	 * 
	 * if the name is unavailable at \t String is returned
	 * @param id
	 * @return
	 */
	public String findCourseEntryName(int id)
	{
		for (CourseEntry e : schoolDir)
		{
			if (e.getIdNum() == id)
				return e.getName();
		}
		return "\t";
	}
	
	/**
	 * @return the schoolDir
	 */
	public ArrayList<CourseEntry> getSchoolDir() {
		return schoolDir;
	}

	/**
	 * prints the information on all the collected courses
	 */
	public void printInfo()
	{
		System.out.println("==========================================================");
		System.out.println("         State University of New York at New Paltz        ");
		System.out.println("														  ");
		System.out.println("                Statistics for Spring 2012				  ");
		System.out.println("----------------------------------------------------------");
		System.out.println("Course Name \t Number \t No. Stud \t Max-GP \t Min-GP \t Ave-GP ");
		System.out.println("														  			");
		for (CourseEntry e : schoolDir)
		{
			System.out.println(e.getName() +"\t\t" + e.getIdNum() + "\t\t" + e.getEnrollment() + 
					"\t\t" + e.getGpHigh() + "\t\t" + e.getGpLow() + "\t\t" + e.getGpAvg());
		}
	}

	/**
	 * pads a String s with spaces so it is n characters long
	 * @param s - string to format
	 * @param n - size of full string
	 * @return
	 */
	private static String padRight(String s, int n) {
	     return String.format("%1$-" + n + "s", s);  
	}
}

