package project1;

// this class represents a module record
public class ModuleRecord {

	Module m;
	public int mark;

	public ModuleRecord(Module m, int mark) {

		this.m = m;
		this.mark = mark;
	}
	
	// method to create ModuleRecord object
	public ModuleRecord(Module m) {

		this.m = m;
	}

	//method to create recordMark object
	public void recordMark(int mark) {

		this.mark = mark;
	}

	// method to return module mark
	public int getModuleMark() {

		return mark;
	}

	// method returned project1.Module@2a139a55, but now returns toString method
	public Module getModule() {

		return m;
	}
	
	// method to calculate whether result is a pass or fail
	public ModuleResult getModuleResult() {

			if (m.getLevel() == Module.MSC_MODULE_LEVEL && mark >= Module.MSC_MODULE_PASS_MARK ||
					m.getLevel() != Module.MSC_MODULE_LEVEL && mark >= Module.UG_MODULE_PASS_MARK) {
				return ModuleResult.PASS;
			} else {
				return ModuleResult.FAIL;
		}
	}
}

