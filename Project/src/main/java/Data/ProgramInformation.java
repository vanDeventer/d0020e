package Data;

import Data.CourseProgram.ProgramType;

/**
 * This holds all the information associated with a program. No courses or
 * specializations are included. this is just pure information used when searching the database.
 * @author Robin
 *
 */
public class ProgramInformation {
	private CourseOrder courseOrder;
	private String code;
	private String name;
	private String description;
	private CourseDate startDate;
	private Credits credits;
	private ProgramType programType;
	
	public ProgramInformation(CourseOrder courseOrder, String code, String name, String description, CourseDate startDate, Credits credits, ProgramType type) {
		this.courseOrder = courseOrder;
		this.code = code;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.credits = credits;
		this.programType = type;
		
	}
	
	public CourseOrder getCourseOrder() {
		return courseOrder;
	}


	public void setCourseOrder(CourseOrder courseOrder) {
		this.courseOrder = courseOrder;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Credits getCredits() {
		return credits;
	}


	public void setCredits(Credits credits) {
		this.credits = credits;
	}

	public CourseDate getStartDate() {
		return startDate;
	}

	public void setStartDate(CourseDate startDate) {
		this.startDate = startDate;
	}
	
	public ProgramType getProgramType() {
		return programType;
	}

	public void setProgramType(ProgramType programType) {
		this.programType = programType;
	}

}
