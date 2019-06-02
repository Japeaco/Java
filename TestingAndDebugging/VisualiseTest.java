package testing;

// DO NOT CHANGE THESE IMPORTS
import a.a; // Module
import a.b; // ModuleRecord
import a.c; // ModuleResult
import a.d; // Qualification
import a.e; // Student
import b.f; // Visualize

// This is a driver class if you wish to use one. It contains a sample
// student and modules. You do NOT need to review the code in this class
// and you CAN modify it to add your own test data if you wish.
public class VisualiseTest {

	// #TODO Edit student number
	//public static final String STUDENT_NUMBER = "150123456";
	public static final String STUDENT_NUMBER = "150180281";
	
	public static void main (String[] args){
		
		//	A total of 180 credits (no more and no fewer) 
		//	No more than 70 credits, and at least 50 credits in each semester 
		//	A module of at least 60 credits (a project module) 
		//	At least 150 credits at Level 7 
		//	No more than 30 credits at Level 6 
		//	No credits at a level lower than Level 6 
		//  The pass mark for a Level 7 module is 50, 
		//  but for Level 4, 5 and 6 modules it is 40. 

		// define modules
		a csc8001 = new a("CSC8001", "Programming and data structures", 20, 0, 0, 7);
		a csc8002 = new a("CSC8002", "Advanced Programming", 0, 20, 0, 7);
		a csc8004 = new a("CSC8004", "Networks and Web Technologies", 0, 20, 0, 7);
		a csc8005 = new a("CSC8005", "Software Engineering with Group Project", 10, 10, 0, 7);
		a csc8008 = new a("CSC8008", "Information Systems", 20, 0, 0, 7);
		a csc8009 = new a("CSC8009", "Research Methods for Computer Science", 0, 10, 0, 7);
		a csc8010 = new a("CSC8010", "Computer Environments", 10, 0, 0, 7);
		a csc8099 = new a("CSC8099", "Project and Dissertation for MSc Computer Science", 0, 0, 60, 7);
		
		// define student
		e s = new e("John Smith", STUDENT_NUMBER);
		
		// add modules to student
		s.addModule(csc8001);
		s.addModule(csc8002);
		s.addModule(csc8004);
		s.addModule(csc8005);
		s.addModule(csc8008);
		s.addModule(csc8009);
		s.addModule(csc8010);
		s.addModule(csc8099);
		
		// record mark for that student
		s.recordMark(csc8001, 50);
		s.recordMark(csc8002, 50);
		s.recordMark(csc8004, 50);
		s.recordMark(csc8005, 50);
		s.recordMark(csc8008, 50);
		s.recordMark(csc8009, 50);
		s.recordMark(csc8010, 50);
		s.recordMark(csc8099, 50);
		
		System.out.println(s.getAverage());
		System.out.println(s.checkModuleSelection());
		System.out.println(s.getQualification());

		// summary
		new f(STUDENT_NUMBER, s);
		
	}
}
