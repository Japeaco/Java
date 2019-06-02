package project1;

// this class represents a module
public class Module {

	public final static int MSC_MODULE_PASS_MARK = 40;
	//public final static double UG_MODULE_PASS_MARK = 40;
	public final static int UG_MODULE_PASS_MARK = 40;
	public final static int MSC_MODULE_LEVEL = 7;
	public final static int STAGE_3_MODULE_LEVEL = 6;

	String moduleCode;
	String moduleTitle;
	int sem1Credits;
	int sem2Credits;
	int sem3Credits;
	int moduleLevel;

	public Module(String code, String title, int sem1, int sem2, int sem3, int level) {

		moduleCode = code;
		moduleTitle = title;
		sem1Credits = sem1;
		//sem2Credits = sem1;
		sem2Credits = sem2;
		sem3Credits = sem3;
		moduleLevel = level;
	}

	// method to return the module code
	public String getCode() {

		return moduleCode;
	}

	// method to return the module title
	public String getTitle() {

		return moduleTitle;
	}

	// method to return the Semester 1 credits
	public int getSemesterOneCredits() {

		return sem1Credits;
	}

	// method to return the Semester 2 credits
	public int getSemesterTwoCredits() {

		return sem2Credits;
	}

	// method to return the Semester 3 credits
	public int getSemesterThreeCredits() {

		return sem3Credits;
	}

	// method to return the total credits across all the semesters
	public int getTotalCredits() {

		//return sem2Credits + sem3Credits;
		return sem1Credits + sem2Credits + sem3Credits;
	}

	// method to return the module level
	public int getLevel() {

		return moduleLevel;
	}
	
	// method print Module object
	public String toString()
	{
		return "Module code: " + getCode() + "\nTitle: " + getTitle() + "\nSemester one credits: " + getSemesterOneCredits()
				+ "\nSemester two credits: " + getSemesterTwoCredits() + "\nSemester three credits: " + getSemesterThreeCredits()
				+ "\nTotal credits: " + getTotalCredits() + "\nLevel: " + getLevel();
	}
}