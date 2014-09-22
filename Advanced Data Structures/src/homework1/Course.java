package homework1;
//Patrick Gallagher
public class Course {
	
	private String name, letterGrade;
	private int idNum, grade;
	private double gradePoint;
	
	/**
	 * constructor for Course
	 * calculates gradePoint and letterGrade from grade and finds course number
	 * @param name
	 * @param idNum
	 * @param grade
	 * 
	 */	
	public Course(String name, int idNum, int grade){
		this.name = padRight(name, 20);
		this.idNum = idNum;
		this.grade = grade;
		findLetterGradeAndGPA(grade);
	}

	/**
	 * a constructor that uses an already built course
	 * @param newCourse
	 */
	public Course(Course newCourse)
	{
		this.name = newCourse.getName();
		this.letterGrade = newCourse.getLetterGrade();
		this.idNum = newCourse.getIdNum();
		this.grade = newCourse.getGrade();
		this.gradePoint = newCourse.getGradePoint();
	}
	
	/**
	 * determines the grade point and letter grade through series of if else statements
	 * by measuring grade (i.e. 100 point grade)
	 * @precondition grade must be under 101
	 * @param grade
	 */
	private void findLetterGradeAndGPA(int grade){
		if (grade <= 100 && grade >= 95){
			setLetterGrade("A");
			setGradePoint(4.0);
		}
		else if (grade <= 94 && grade >= 90){
			setLetterGrade("A-");
			setGradePoint(3.7);
		}
		else if (grade <= 89 && grade >= 85){
			setLetterGrade("B+");
			setGradePoint(3.3);
		}
		else if (grade <= 84 && grade >= 80){
			setLetterGrade("B");
			setGradePoint(3.0);
		}
		else if (grade <= 79 && grade >= 75){
			setLetterGrade("B-");
			setGradePoint(2.7);
		}
		else if (grade <= 74 && grade >= 70){
			setLetterGrade("C+");
			setGradePoint(2.3);
		}
		else if (grade <= 69 && grade >= 65){
			setLetterGrade("C");
			setGradePoint(2.0);
		}
		else if (grade <= 64 && grade >= 60){
			setLetterGrade("C-");
			setGradePoint(1.7);
		}
		else if (grade <= 59 && grade >= 55){
			setLetterGrade("D+");
			setGradePoint(1.3);
		}
		else if (grade <= 54 && grade >= 50){
			setLetterGrade("D");
			setGradePoint(1.0);
		}
		else if (grade <= 49 && grade >= 40){
			setLetterGrade("D-");
			setGradePoint(0.7);
		}
		else//grade less than 40
		{
			setLetterGrade("F");
			setGradePoint(0.0);
		}
	}
		
	//getters and setters for course class
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the letterGrade
	 */
	public String getLetterGrade() {
		return letterGrade;
	}
	/**
	 * @param letterGrade the letterGrade to set
	 */
	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
	}
	/**
	 * @return the grade
	 */
	public int getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}
	/**
	 * @return the gradePoint
	 */
	public double getGradePoint() {
		return gradePoint;
	}
	/**
	 * @param gradePoint the gradePoint to set
	 */
	public void setGradePoint(double gradePoint) {
		this.gradePoint = gradePoint;
	}
	public int getIdNum() {
		return idNum;
	}
	public void setIdNum(int idNum) {
		this.idNum = idNum;
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

