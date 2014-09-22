package homework1;

import java.text.DecimalFormat;

public class CourseEntry {
	
	private String name;
	private int idNum, enrollment;
	private double runningGradePoint, gpHigh, gpLow, gpAvg;
	

	public CourseEntry(String name, int idNum)
	{
		this.name = padRight(name, 15);
		this.idNum = idNum;
		enrollment = 0;
		runningGradePoint = 0.0;
		gpHigh = 0.0;
		gpLow = 4.0;
		gpAvg = 0.0;
	}
	
	/**
	 * changes CourseEntry data in response to new student being added
	 * increases enrollment and adjusts CourseEntry stats thorugh new grade point
	 * @param newGP
	 */
	public void acceptNewStudent(double newGP)
	{
		enrollment++;
		calculateGradePoints(newGP);
	}


	/**
	 * calculates the gradePoint stats for each new student in course
	 * @param newGP
	 */
	private void calculateGradePoints(double newGP)
	{
		calculateGPAverage(newGP);
		calculateHighAndLow(newGP);
	}
	
	/**
	 * calculates the new grade point average to set the gpAvg to the
	 * @param newGp
	 */
	private void calculateGPAverage(double newGp)
	{
		runningGradePoint = runningGradePoint + newGp;
		setGpAvg(runningGradePoint / enrollment);
	}
	
	/**
	 * calculates the gpHigh and gpLow of the course after adding the new grade point
	 * @param newGp
	 */
	private void calculateHighAndLow(double newGp)
	{	
		if (newGp < gpLow)//newGp is lower than gpLow
			setGpLow(newGp);
		
		if (newGp > gpHigh)//newGp is higher than gpHigh
			setGpHigh(newGp);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the idNum
	 */
	public int getIdNum() {
		return idNum;
	}

	/**
	 * @return the enrollment
	 */
	public int getEnrollment() {
		return enrollment;
	}

	/**
	 * @return the gpHigh
	 */
	public double getGpHigh() {
		return gpHigh;
	}

	/**
	 * @return the gpLow
	 */
	public double getGpLow() {
		return gpLow;
	}

	/**
	 * @return the gpAvg
	 */
	public double getGpAvg() {
		return gpAvg;
	}
	
	
	/**
	 * @param gpHigh the gpHigh to set
	 */
	private void setGpHigh(double gpHigh) {
		this.gpHigh = roundTwoDecimals(gpHigh, "#.##");
	}

	/**
	 * @param gpLow the gpLow to set
	 */
	private void setGpLow(double gpLow) {
		this.gpLow = roundTwoDecimals(gpLow, "#.##");
	}

	/**
	 * @param gpAvg the gpAvg to set
	 */
	private void setGpAvg(double gpAvg) {
		this.gpAvg = roundTwoDecimals(gpAvg, "#.##");
	}

	/**
	 * rounds the double value d inputted to the format verified in the parameter
	 * @param d
	 * @param format
	 * @return double in format of format string
	 */
	private double roundTwoDecimals(double d, String format) {
	    DecimalFormat twoDForm = new DecimalFormat(format);
	    return Double.valueOf(twoDForm.format(d));
	}
	/**
	 * pads a String s with spaces so it is n characters long
	 * @param s - string to format
	 * @param n - size of full string
	 * @return formatted String
	 */
	private static String padRight(String s, int n) {
	     return String.format("%1$-" + n + "s", s);  
	}
	
	public void printInfo()
	{
		System.out.println("==========================================================");
		System.out.println("         State University of New York at New Paltz        ");
		System.out.println("														  ");
		System.out.println("                Statistics for Spring 2012				  ");
		System.out.println("----------------------------------------------------------");
		System.out.println("Course Name\tNumber  No. Stud  Max-GP  Min-GP  Ave-GP ");
		System.out.println("														  			");
		System.out.println(getName() +"\t" + getIdNum() + "\t" + getEnrollment() + 
					"\t   " + getGpHigh() + "\t  " + getGpLow() + "\t  " + getGpAvg());
	}
	
		
}