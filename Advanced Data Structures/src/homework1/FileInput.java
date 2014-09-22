package homework1;

//Patrick Gallagher
//Homework1
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileInput {
	
		public static void main(String[] args) throws IOException{
			Scanner inFile = null;  // creates Scanner object
			SchoolDirectory schoolDirectory = new SchoolDirectory();  //creates schoolDirectory to store information about CourseEntries
			StudentDirectory studentDirectory = new StudentDirectory();  //creates studentDirectory to store informtion about Students
	
			try
			{//reads in the input file
				inFile = new Scanner(new File("C:\\Users\\Patrick\\Desktop\\Advanced Data Structures\\in.dat"));
			} 
			catch (IOException e)
			{
				System.out.println(e.getMessage()); // display error
				System.exit(1);                     // terminate program
			}

			while (inFile.hasNextLine())//while loop that reads through all the lines of the input file
			{
				String tempName = inFile.nextLine();    // read 1st line, get name
				int tempId = inFile.nextInt();		//read 2nd line, get idNumber
				int tempNumOfCourses = inFile.nextInt();	//read 3rd line, get number of courses
				
				//creates a new student class that takes in the name, id and number of courses
				Student tempStudent = new Student(tempName, tempId, tempNumOfCourses);
	
				for (int i = 0; i < tempNumOfCourses; i++)
				{//loops through following lines for however many number of classes are taken, then returns to the while loop
					int tempCourseNum = inFile.nextInt();				//gets the first entry, the Course number
					int tempGrade = inFile.nextInt();					//gets the second entry, the Course grade
					
					// creates a new course to add to the tempStudent, finds the name through the findCourseEntryName in the schoolDirectory
					Course tempCourse = new Course(schoolDirectory.findCourseEntryName(tempCourseNum), tempCourseNum, tempGrade);
					
					//finds the Course in the School Directory and prompts the acceptNewStudent method in that CourseEntry
					schoolDirectory.findCourseEntry(tempCourseNum).acceptNewStudent(tempCourse.getGradePoint());
					tempStudent.addCourse(tempCourse); //adds the course to the students Courses
				}
				
				studentDirectory.add(tempStudent);  //adds the students to the directory
				inFile.nextLine();  //establishes for next line in the loop to be added	
			}//end while
			
			//creates out1.dat, which provides documentation from the student Directory class object studentDirectory
			try{
				BufferedWriter out1 = new BufferedWriter(new FileWriter("out1.dat"));  //makes new file
				//for loop that goes through ArrayList in studentDirectory and gets data of each student e
				for (Student e : studentDirectory.getStudentDir())
				{																//creates new line on out file
					out1.write("=========================================================="); out1.newLine();  
					out1.write("State University of New York at New Paltz      Spring 2012"); out1.newLine();
					out1.write("															"); out1.newLine();
					out1.write("Name:  					" + e.getName()); 						out1.newLine();
					out1.write("Student Indentifacation No.:		" + e.getIdNum());			out1.newLine();
					out1.write("----------------------------------------------------------");  	out1.newLine();
					out1.write("Course name		Course number 	Grade       GP");out1.newLine(); out1.newLine();
					out1.write("															");  out1.newLine();
					for (Course eachCourse : e.getCourses())//for loop that goes through courses ArrayList
					{										//obtains course data from eachCourse
						out1.write(eachCourse.getName() + "\t" + eachCourse.getIdNum() + "\t\t" +
								eachCourse.getLetterGrade() + "\t     " + eachCourse.getGradePoint());
						out1.newLine();
					}
					out1.write("----------------------------------------------------------");  out1.newLine();
					out1.write("Number of Courses Taken:			" + e.getNumOfCourses());  out1.newLine();
					out1.write("GP Average (GPA):				" + e.getGpa());			   out1.newLine();
				}
				out1.close();//close the output stream
			}
			catch (Exception e){//Catch exception if any
				  System.err.println("Error: " + e.getMessage());
				  }
			
			try{//creates a document from data from the SchoolDirectory object schoolDirectory
				BufferedWriter out2 = new BufferedWriter(new FileWriter("out2.dat"));
				out2.write("=========================================================="); out2.newLine();
				out2.write("         State University of New York at New Paltz        "); out2.newLine();
				out2.write("														  "); out2.newLine();
				out2.write("                Statistics for Spring 2012				  "); out2.newLine();
				out2.write("----------------------------------------------------------"); out2.newLine();
				out2.write("Course Name \t Number No. Stud Max-GP Min-GP  Ave-GP "); out2.newLine();
				out2.write("														  "); out2.newLine();
				for (CourseEntry e : schoolDirectory.getSchoolDir())
				{//loop that obtains each CourseEntry in the schoolDir ArrayList and writes the data
						out2.write(e.getName() +"\t" + e.getIdNum() + "\t" + e.getEnrollment() + 
								"\t" + e.getGpHigh() + "\t" + e.getGpLow() + "\t" + e.getGpAvg());
						out2.newLine();
				}
			  out2.close();//Close the output stream
			  }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
			
			//sorts the studentDir Arraylist in the studentDirectory by gpa
			studentDirectory.sortList();
			
			int counter = 1;  //stores the order of students
			try{//creates a document from data from the SchoolDirectory object schoolDirectory
				BufferedWriter out3 = new BufferedWriter(new FileWriter("out3.dat"));
				//sorts the 
				out3.write("========================================");	out3.newLine();
				out3.write("Order \t Name \t\t\t GPA");						out3.newLine();
				out3.write("----------------------------------------"); out3.newLine();
				for (Student e : studentDirectory.getStudentDir())
				{
					out3.write(counter + "\t" + e.getName() + "	  " + e.getGpa()); out3.newLine();
					counter++;
				}	
				out3.write("----------------------------------------"); out3.newLine();
				out3.close(); //close out3 writer
			}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
			}
			
			Scanner in = new Scanner(System.in);
			
			System.out.println("For more information");
			System.out.println("press 1 - check a student using his/her name");
			System.out.println("press 2 - check a student using his/her id#");
			System.out.println("press 3 - check a course using the course name");
			System.out.println("press 4 - check a course using the course id#");
			System.out.println("press 9 - quit program");
			System.out.println("															");
			System.out.println("Enter: ");
		
			int nextMove = in.nextInt();
			
			
			
			switch(nextMove)
			{
			case 1:
				nextMove = 1;
				System.out.println("Please enter the name of the student you are seeking");
				in.nextLine();  //wait for this line
				String input1 = in.nextLine();
				studentDirectory.findStudent(input1).printInfo();
				break;
			case 2:
				nextMove = 2;
				System.out.println("Please the student ID you are seeking: ");
				int input2 = in.nextInt();
				studentDirectory.findStudent(input2).printInfo();
				break;
			case 3:
				nextMove = 3;
				System.out.println("Please enter the course name you are seeking: ");
				in.nextLine();  //wait for next line
				String input3 = in.nextLine();
				System.out.println(input3);
				schoolDirectory.findCourseEntry(input3).printInfo();
				break;
			case 4:
				nextMove = 4;
				System.out.println("Please enter the course id you are seeking: ");
				int input4 = in.nextInt();
				schoolDirectory.findCourseEntry(input4).printInfo();
				break;
			case 9:
				nextMove = 9;
				System.out.println("Goodbye");
				System.exit(1);
				break;
			default:
				System.out.println("Try again: ");
				break;
			}
		}
	}


