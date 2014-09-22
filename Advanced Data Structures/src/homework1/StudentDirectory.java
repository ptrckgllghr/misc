package homework1;
//Patrick Gallagher
import java.util.ArrayList;

public class StudentDirectory{
	
	public int numberOfStudents;
	public ArrayList<Student> studentDir;
	
	/**
	 * creates new StudentDirectory Object
	 */
	public StudentDirectory()
	{
		studentDir = new ArrayList<Student>();
		numberOfStudents = 0;
	}
	
	/**
	 * adds a student to the studentDir ArrayList, increases the number of students enrolled
	 * @param newStudent
	 */
	public void add(Student newStudent)
	{
		studentDir.add(newStudent);
		numberOfStudents++;
	}

	/**
	 * @return the numberOfStudents
	 */
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	
	
	public ArrayList<Student> getStudentDir()
	{
		return studentDir;
	}
	
	/**
	 * sorts the studentDir by gpa, from highest to lowest
	 */
	public void sortList()
	{
		for (int i = 0; i < studentDir.size() - 1; i++)
		{
			double currentMin = studentDir.get(i).getGpa();
			int currentMinIndex = i;
			for (int j = i ; j <= studentDir.size() - 1; j++)
			{
				if (currentMin < studentDir.get(j).getGpa())
				{
					currentMin = studentDir.get(j).getGpa();
					currentMinIndex = j;
				}
			}
			if (currentMinIndex != i)
			{
				Student tempi = studentDir.get(i);
				
				Student currentTop = studentDir.get(currentMinIndex);
				
				studentDir.set(i, currentTop);
				
				studentDir.set(currentMinIndex, tempi);
					
			}
		}
	}
	/**
	 * scans through courseEntry arrayList to find course through id Num
	 * returns null if not found	
	 * @param id
	 * @return
	 */
	public Student findStudent(int id)
	{
		for (Student e: studentDir)
		{
			if (e.getIdNum() == id)
				return e;		
		}
		return null;
	}
	/**
	 * scans through courseEntry arrayList to find course through name
	 * returns null if not found
	 * @param name
	 * @return
	 */
	public Student findStudent(String name)
	{
		String tempName = padRight(name, 20); //adjusts for the length of designated Student name Strings
		for (Student e: studentDir)
		{
			if (e.getName().equalsIgnoreCase(tempName))
			{
				e.printInfo();
				return e;
			}		
		}
		return null;
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
