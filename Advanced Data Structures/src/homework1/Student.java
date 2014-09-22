package homework1;
//Patrick Gallagher
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Student {

	//make method to set average and gpa to 0.00 format at setters
	private String name;
	private int idNum, numOfCourses;
	private ArrayList<Course> courses;
	private double average;
	private double gpa;
		
	/**
	 * partial constructor too be used when name, idNum and numOfCourses is known
	 * @param name
	 * @param idNum
	 * @param numOfCourses
	 */
	public Student(String name, int idNum, int numOfCourses){
		this.name = padRight(name, 20);
		this.idNum = idNum;
		this.numOfCourses = numOfCourses;
		courses = new ArrayList<Course>();
		average = 0.0;
		gpa = 0.0;			
	}
	
	/**
	 * constructor with an already made student
	 * @param newStudent
	 */
	public Student(Student newStudent)
	{
		this.name = newStudent.getName();
		this.idNum = newStudent.getIdNum();
		this.numOfCourses = newStudent.getIdNum();
		this.courses = newStudent.cloneList();
		this.average = newStudent.getAverage();
		this.gpa = newStudent.getGpa();
	}
	

	/**
	 * adds a course to the course ArrayList
	 * uses the calculateAverages method to set average and gpa with a new addition
	 * @param newCourse
	 */
	public void addCourse(Course newCourse)
	{
		courses.add(newCourse);  //adds a Course to the ArrayList
		calculateAverages();
	}
	
	/**
	 * calculates the and sets the gpa and the average variables
	 */
	private void calculateAverages()
	{
		double gpaRunningTotal = 0.0;  //temp variables that store the total value for grade point and running total
		int gradeRunningTotal = 0;
		for (Course e : courses)
		{  //for each course it obtains the gradePoint and the grade and stores in temp variables
			gpaRunningTotal += e.getGradePoint();
			gradeRunningTotal += e.getGrade();
		}
		setGpa(gpaRunningTotal / numOfCourses);		//sets the gpa and average fields
		setAverage(gradeRunningTotal / numOfCourses);
	}

	//getters and setters of Student Class
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the idNum
	 */
	public int getIdNum() {
		return idNum;
	}

	/**
	 * @param idNum the idNum to set
	 */
	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}

	/**
	 * @return the numOfCourses
	 */
	public int getNumOfCourses() {
		return numOfCourses;
	}

	/**
	 * @param numOfCourses the numOfCourses to set
	 */
	public void setNumOfCourses(int numOfCourses) {
		this.numOfCourses = numOfCourses;
	}

	/**
	 * @return the average
	 */
	public double getAverage() {
		return average;
	}

	/**
	 * @param average the average to set
	 */
	public void setAverage(double average) {
		this.average = roundTwoDecimals(average, "##.##");
	}


	/**
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}


	/**
	 * @param gpa the gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = roundTwoDecimals(gpa, "#.##");
	}

	
	/**
	 * rounds the double value inputted to the format verified in the parameter
	 * @param d
	 * @param format
	 * @return double in format of format string
	 */
	private double roundTwoDecimals(double d, String format) {
	    DecimalFormat twoDForm = new DecimalFormat(format);
	    return Double.valueOf(twoDForm.format(d));
	}

	/**
	 * prints the information of the student
	 */
	public void printInfo()
	{
		System.out.println("==========================================================");
		System.out.println("State University of New York at New Paltz      Spring 2012");
		System.out.println("															");
		System.out.println("Name:  					" + getName());
		System.out.println("Student Indentifacation No.:		" + getIdNum());
		System.out.println("----------------------------------------------------------");
		System.out.println("Course name		Course number 	Grade       GP");
		System.out.println("															");
		for (Course e : courses)
		{
			System.out.println(e.getName() + "\t " + e.getIdNum() + "\t\t" +
					e.getLetterGrade() + "\t   " + e.getGradePoint());
		} 
		System.out.println("----------------------------------------------------------");
		System.out.println("Number of Courses Taken:			" + getNumOfCourses());
		System.out.println("GP Average (GPA):				" + getGpa());
		
	}
	
	/**
	 * @return the courses
	 */
	public ArrayList<Course> getCourses() {
		return courses;
	}

	/**
	 * creates a clone of courses from the students list of courses
	 * @param oldList
	 * @return a cloned list
	 */
	public ArrayList<Course> cloneList() 
	{
	    ArrayList<Course> clonedList = new ArrayList<Course>(courses.size());
	    for (Course e : courses) 
	    {
	        clonedList.add(new Course(e));
	    }
	    return clonedList;
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


