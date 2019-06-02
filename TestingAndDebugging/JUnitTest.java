package testing;

//DO NOT CHANGE THESE IMPORTS
import project1.Module;
import project1.ModuleRecord;
import project1.ModuleResult;
import project1.Qualification;
import project1.Student;

import static org.junit.Assert.*;

import org.junit.Test;

// This is a junit test class if you wish to use one. It contains a sample
// student. You do NOT need to review the code in this class and you CAN
// modify it to add your own test data if you wish.
public class JUnitTest {
	
	//Module.java tests
	@Test
	public void GetCodeTest1(){
		String code = "CSC8001";
		Module csc8001 = new Module(code, "Programming and data structures", 20, 0, 0, 7);
		assertEquals("Test for getCode: ", code, csc8001.getCode());
	}
	
	@Test
	public void GetTitleTest (){
		String title = "Programming and data structures";
		Module csc8001 = new Module("CSC8001", title, 20, 0, 0, 7);
		assertEquals("Test for getTitle: ", title, csc8001.getTitle());
	}
	
	@Test
	public void GetSem1CreditsTest (){
		int sem1 = 20;
		Module csc8001 = new Module("CSC8001", "Programming and data structures", sem1, 0, 0, 7);
		assertEquals("Test for getSem1Credits: ", sem1, csc8001.getSemesterOneCredits());
	}
	
	@Test
	public void GetSem2CreditsTest (){
		int sem2 = 0;
		Module csc8001 = new Module("CSC8001", "Programming and data structures", 20, sem2, 0, 7);
		assertEquals("Test for getSem2Credits: ", sem2, csc8001.getSemesterTwoCredits());
	}
		
	@Test
	public void GetSem3CreditsTest (){
		int sem3 = 0;
		Module csc8001 = new Module("CSC8001", "Programming and data structures", 20, 0,sem3, 7);
		assertEquals("Test for getSem3Credits: ", sem3, csc8001.getSemesterThreeCredits());
	}
		
	@Test
	public void GetTotalCreditsTest (){
		int total = 20;
		Module csc8001 = new Module("CSC8001", "Programming and data structures", 20, 0, 0, 7);
		assertEquals("Test for getTotalCredits: ", total, csc8001.getTotalCredits());	
	}
	
	@Test
	public void GetLevelTest (){
		int level = 7;
		Module csc8001 = new Module("CSC8001", "Programming and data structures", 20, 0, 0, level);
		assertEquals("Test for getLevel: ", level, csc8001.getLevel());	
	}
	
	//ModuleRecord.java tests
	@Test
	public void GetModuleTest (){
		Module csc8001 = new Module("CSC8001", "Programming and data structures", 20, 0, 0, 7);
		ModuleRecord a = new ModuleRecord(csc8001, 50);
		assertEquals("Test for getModule: ", csc8001, a.getModule());	
	}
	
	@Test
	public void GetModuleMarkTest (){
		int record = 50;
		Module csc8001 = new Module("CSC8001", "Programming and data structures", 20, 0, 0, 7);
		ModuleRecord a = new ModuleRecord(csc8001, record);
		assertEquals("Test for getModuleMark: ", record, a.getModuleMark());	
	}
	
	@Test
	public void GetModuleResultPassTest (){
		Module csc8001 = new Module("CSC8001", "Programming and data structures", 20, 0, 0, 7);
		ModuleRecord a = new ModuleRecord(csc8001, 50);
		assertEquals("Test for getModuleResult: ", ModuleResult.PASS, a.getModuleResult());	
	}
	
	@Test
	public void GetModuleResultFail(){
		Module csc8001 = new Module("CSC8001", "Programming and data structures", 20, 0, 0, 7);
		ModuleRecord a = new ModuleRecord(csc8001, 0);
		assertEquals("Test for getModuleResult: ", ModuleResult.FAIL, a.getModuleResult());	
	}
	
	//Student.java tests
	@Test
	public void GetNameTest (){
		String name = "John Smith";
		Student s = new Student(name, "150789456");
		assertEquals("Test for getName: ", name, s.getName());
	}
	
	@Test
	public void GetNumberTest (){
		String number = "150789456";
		Student s = new Student("John Smith", number);
		assertEquals("Test for getNumber: ", number, s.getNumber());
	}
	
	@Test
	public void GetCheckModuleSelectionFailTest (){
		Student s = new Student("John Smith", "150789456");
		Module csc8001 = new Module("CSC8001", "Programming and data structures", 20, 0, 0, 7);
		s.addModule(csc8001);
		s.recordMark(csc8001, 50);
		assertEquals("Test for getCheckModuleSelection: ", false, s.checkModuleSelection());
	}
	
	@Test
	public void GetCheckModuleSelectionPassTest (){
		Student s = new Student("John Smith", "150789456");
		Module csc8001 = new Module("CSC8001", "Programming and data structures", 20, 0, 0, 7);
		Module csc8002 = new Module("CSC8002", "Advanced Programming", 0, 20, 0, 7);
		Module csc8004 = new Module("CSC8004", "Networks and Web Technologies", 0, 20, 0, 7);
		Module csc8005 = new Module("CSC8005", "Software Engineering with Group Project", 10, 10, 0, 7);
		Module csc8008 = new Module("CSC8008", "Information Systems", 20, 0, 0, 7);
		Module csc8009 = new Module("CSC8009", "Research Methods for Computer Science", 0, 10, 0, 7);
		Module csc8010 = new Module("CSC8010", "Computer Environments", 10, 0, 0, 7);
		Module csc8099 = new Module("CSC8099", "Project and Dissertation for MSc Computer Science", 0, 0, 60, 7);
		s.addModule(csc8001);
		s.addModule(csc8002);
		s.addModule(csc8004);
		s.addModule(csc8005);
		s.addModule(csc8008);
		s.addModule(csc8009);
		s.addModule(csc8010);
		s.addModule(csc8099);
		s.recordMark(csc8001, 50);
		s.recordMark(csc8002, 50);
		s.recordMark(csc8004, 50);
		s.recordMark(csc8005, 50);
		s.recordMark(csc8008, 50);
		s.recordMark(csc8009, 50);
		s.recordMark(csc8010, 50);
		s.recordMark(csc8099, 50);
		assertEquals("Test for getCheckModuleSelection: ", true, s.checkModuleSelection());
	}
	
	@Test
	public void GetAverageTest (){
		int average = 50;
		Student s = new Student("John Smith", "150789456");
		Module csc8001 = new Module("CSC8001", "Programming and data structures", 20, 0, 0, 7);
		Module csc8002 = new Module("CSC8002", "Advanced Programming", 0, 20, 0, 7);
		Module csc8004 = new Module("CSC8004", "Networks and Web Technologies", 0, 20, 0, 7);
		Module csc8005 = new Module("CSC8005", "Software Engineering with Group Project", 10, 10, 0, 7);
		Module csc8008 = new Module("CSC8008", "Information Systems", 20, 0, 0, 7);
		Module csc8009 = new Module("CSC8009", "Research Methods for Computer Science", 0, 10, 0, 7);
		Module csc8010 = new Module("CSC8010", "Computer Environments", 10, 0, 0, 7);
		Module csc8099 = new Module("CSC8099", "Project and Dissertation for MSc Computer Science", 0, 0, 60, 7);
		s.addModule(csc8001);
		s.addModule(csc8002);
		s.addModule(csc8004);
		s.addModule(csc8005);
		s.addModule(csc8008);
		s.addModule(csc8009);
		s.addModule(csc8010);
		s.addModule(csc8099);
		s.recordMark(csc8001, 50);
		s.recordMark(csc8002, 50);
		s.recordMark(csc8004, 50);
		s.recordMark(csc8005, 50);
		s.recordMark(csc8008, 50);
		s.recordMark(csc8009, 50);
		s.recordMark(csc8010, 50);
		s.recordMark(csc8099, 50);
		assertEquals("Test for getAverage: ", average, s.getAverage());
	}
	
	@Test
	public void GetQualificationDistinctionTest (){
		Student s = new Student("John Smith", "150789456");
		Module csc8001 = new Module("CSC8001", "Programming and data structures", 20, 0, 0, 7);
		Module csc8002 = new Module("CSC8002", "Advanced Programming", 0, 20, 0, 7);
		Module csc8004 = new Module("CSC8004", "Networks and Web Technologies", 0, 20, 0, 7);
		Module csc8005 = new Module("CSC8005", "Software Engineering with Group Project", 10, 10, 0, 7);
		Module csc8008 = new Module("CSC8008", "Information Systems", 20, 0, 0, 7);
		Module csc8009 = new Module("CSC8009", "Research Methods for Computer Science", 0, 10, 0, 7);
		Module csc8010 = new Module("CSC8010", "Computer Environments", 10, 0, 0, 7);
		Module csc8099 = new Module("CSC8099", "Project and Dissertation for MSc Computer Science", 0, 0, 60, 7);
		s.addModule(csc8001);
		s.addModule(csc8002);
		s.addModule(csc8004);
		s.addModule(csc8005);
		s.addModule(csc8008);
		s.addModule(csc8009);
		s.addModule(csc8010);
		s.addModule(csc8099);
		s.recordMark(csc8001, 70);
		s.recordMark(csc8002, 70);
		s.recordMark(csc8004, 70);
		s.recordMark(csc8005, 70);
		s.recordMark(csc8008, 70);
		s.recordMark(csc8009, 70);
		s.recordMark(csc8010, 70);
		s.recordMark(csc8099, 70);
		assertEquals("Test for getQualification: ", Qualification.MSC_WITH_DISTINCTION, s.getQualification());
	}
	
	@Test
	public void GetQualificationMeritTest (){
		Student s = new Student("John Smith", "150789456");
		Module csc8001 = new Module("CSC8001", "Programming and data structures", 20, 0, 0, 7);
		Module csc8002 = new Module("CSC8002", "Advanced Programming", 0, 20, 0, 7);
		Module csc8004 = new Module("CSC8004", "Networks and Web Technologies", 0, 20, 0, 7);
		Module csc8005 = new Module("CSC8005", "Software Engineering with Group Project", 10, 10, 0, 7);
		Module csc8008 = new Module("CSC8008", "Information Systems", 20, 0, 0, 7);
		Module csc8009 = new Module("CSC8009", "Research Methods for Computer Science", 0, 10, 0, 7);
		Module csc8010 = new Module("CSC8010", "Computer Environments", 10, 0, 0, 7);
		Module csc8099 = new Module("CSC8099", "Project and Dissertation for MSc Computer Science", 0, 0, 60, 7);
		s.addModule(csc8001);
		s.addModule(csc8002);
		s.addModule(csc8004);
		s.addModule(csc8005);
		s.addModule(csc8008);
		s.addModule(csc8009);
		s.addModule(csc8010);
		s.addModule(csc8099);
		s.recordMark(csc8001, 60);
		s.recordMark(csc8002, 60);
		s.recordMark(csc8004, 60);
		s.recordMark(csc8005, 60);
		s.recordMark(csc8008, 60);
		s.recordMark(csc8009, 60);
		s.recordMark(csc8010, 60);
		s.recordMark(csc8099, 60);
		assertEquals("Test for getQualification: ", Qualification.MSC_WITH_MERIT, s.getQualification());
	}

	@Test
	public void GetQualificationMSCTest (){
		Student s = new Student("John Smith", "150789456");
		Module csc8001 = new Module("CSC8001", "Programming and data structures", 20, 0, 0, 7);
		Module csc8002 = new Module("CSC8002", "Advanced Programming", 0, 20, 0, 7);
		Module csc8004 = new Module("CSC8004", "Networks and Web Technologies", 0, 20, 0, 7);
		Module csc8005 = new Module("CSC8005", "Software Engineering with Group Project", 10, 10, 0, 7);
		Module csc8008 = new Module("CSC8008", "Information Systems", 20, 0, 0, 7);
		Module csc8009 = new Module("CSC8009", "Research Methods for Computer Science", 0, 10, 0, 7);
		Module csc8010 = new Module("CSC8010", "Computer Environments", 10, 0, 0, 7);
		Module csc8099 = new Module("CSC8099", "Project and Dissertation for MSc Computer Science", 0, 0, 60, 7);
		s.addModule(csc8001);
		s.addModule(csc8002);
		s.addModule(csc8004);
		s.addModule(csc8005);
		s.addModule(csc8008);
		s.addModule(csc8009);
		s.addModule(csc8010);
		s.addModule(csc8099);
		s.recordMark(csc8001, 50);
		s.recordMark(csc8002, 50);
		s.recordMark(csc8004, 50);
		s.recordMark(csc8005, 50);
		s.recordMark(csc8008, 50);
		s.recordMark(csc8009, 50);
		s.recordMark(csc8010, 50);
		s.recordMark(csc8099, 50);
		assertEquals("Test for getQualification: ", Qualification.MSC, s.getQualification());
	}

	@Test
	public void GetQualificationFailTest (){
		Student s = new Student("John Smith", "150789456");
		Module csc8001 = new Module("CSC8001", "Programming and data structures", 20, 0, 0, 7);
		Module csc8002 = new Module("CSC8002", "Advanced Programming", 0, 20, 0, 7);
		Module csc8004 = new Module("CSC8004", "Networks and Web Technologies", 0, 20, 0, 7);
		Module csc8005 = new Module("CSC8005", "Software Engineering with Group Project", 10, 10, 0, 7);
		Module csc8008 = new Module("CSC8008", "Information Systems", 0, 0, 0, 7);
		Module csc8009 = new Module("CSC8009", "Research Methods for Computer Science", 0, 10, 0, 7);
		Module csc8010 = new Module("CSC8010", "Computer Environments", 10, 0, 0, 7);
		Module csc8099 = new Module("CSC8099", "Project and Dissertation for MSc Computer Science", 0, 0, 60, 7);
		s.addModule(csc8001);
		s.addModule(csc8002);
		s.addModule(csc8004);
		s.addModule(csc8005);
		s.addModule(csc8008);
		s.addModule(csc8009);
		s.addModule(csc8010);
		s.addModule(csc8099);
		s.recordMark(csc8001, 5);
		s.recordMark(csc8002, 5);
		s.recordMark(csc8004, 5);
		s.recordMark(csc8005, 5);
		s.recordMark(csc8008, 5);
		s.recordMark(csc8009, 5);
		s.recordMark(csc8010, 5);
		s.recordMark(csc8099, 5);
		assertEquals("Test for getQualification: ", Qualification.FAIL, s.getQualification());
	}



}
