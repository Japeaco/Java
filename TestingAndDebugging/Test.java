package testing;

//DO NOT CHANGE THESE IMPORTS
import project1.Module;
import project1.ModuleRecord;
import project1.ModuleResult;
import project1.Qualification;
import project1.Student;

// This is a driver class if you wish to use one. It contains a sample
// student. You do NOT need to review the code in this class and you CAN
// modify it to add your own test data if you wish.
public class Test {

	public static void main(String[] args) {
		
	// testing module class
		
		// new module object
		Module mod = new Module("CSC1022", "Programming II", 30, 0, 0, 7);
		
		// test for module object
		System.out.println(mod.getCode());
		System.out.println(mod.getTitle());
		System.out.println(mod.getSemesterOneCredits());
		System.out.println(mod.getSemesterTwoCredits());
		System.out.println(mod.getSemesterThreeCredits());
		System.out.println(mod.getTotalCredits());
		System.out.println(mod.getLevel());
		
	//testing ModuleRecord class
		
		// if m.getLevel() equals Module.MSC_MODULE_LEVEL (7) and mark greater than or equal to Module.MSC_MODULE_PASS_MARK (40)
		// or mark greater than or equal to Module.UG_MODULE_PASS_MARK (40)
		
		// new module record object
		// should return pass
		ModuleRecord pass = new ModuleRecord(mod, 40);
		
		Module no = new Module("CSC1022", "Programming II", 0, 40, 40, 6);
		
		//should return fail
		ModuleRecord fail = new ModuleRecord(no, 39);
		
		// test for module record object
		System.out.println("\n" + pass.getModuleResult());
		System.out.println(fail.getModuleResult());
		System.out.println(pass.getModuleMark());
		System.out.println(pass.getModule());
		
		//new student object
		Student jam = new Student("James", "150180281");
	
		Module csc8001 = new Module("CSC8001", "Programming and data structures", 20, 0, 0, 7);
		Module csc8002 = new Module("CSC8002", "Advanced Programming", 0, 20, 0, 7);
		Module csc8004 = new Module("CSC8004", "Networks and Web Technologies", 0, 20, 0, 7);
		Module csc8005 = new Module("CSC8005", "Software Engineering with Group Project", 10, 10, 0, 7);
		Module csc8008 = new Module("CSC8008", "Information Systems", 20, 0, 0, 7);
		Module csc8009 = new Module("CSC8009", "Research Methods for Computer Science", 0, 10, 0, 7);
		Module csc8010 = new Module("CSC8010", "Computer Environments", 10, 0, 0, 7);
		Module csc8099 = new Module("CSC8099", "Project and Dissertation for MSc Computer Science", 0, 0, 60, 7);
		
	
		jam.addModule(csc8001);
		jam.addModule(csc8002);
		jam.addModule(csc8004);
		jam.addModule(csc8005);
		jam.addModule(csc8008);
		jam.addModule(csc8009);
		jam.addModule(csc8010);
		jam.addModule(csc8099);
		
		jam.recordMark(csc8001, 50);
		jam.recordMark(csc8002, 50);
		jam.recordMark(csc8004, 50);
		jam.recordMark(csc8005, 50);
		jam.recordMark(csc8008, 50);
		jam.recordMark(csc8009, 50);
		jam.recordMark(csc8010, 50);
		jam.recordMark(csc8099, 50);
		
		System.out.println("\n" + jam.getName());
		System.out.println(jam.getClass());
		System.out.println(jam.getAverage());
		System.out.println(jam.checkModuleSelection());
		System.out.println(jam.getQualification());
		

	}
	
}
