/* ABSTRACT CLASS ----- SUPER CLASS */
public abstract class Employee {
	private int employeeID; // the ID number of the employee
	private int hiredYear; // the year that the employee was hired
	private String title; // the title of the employee
	private double baseSalary; // the current base salary of the employee
	private double compensation; // the compensation of the employee

	/**
	 * Constructor
	 * 
	 * @param employeeID   the ID number of the employee
	 * @param hiredYear    the year that the employee was hired
	 * @param title        the title of the employee
	 * @param baseSalary   the current base salary of the employee
	 * @param compensation the compensation of the employee
	 */
	public Employee(int employeeID, int hiredYear, String title, double baseSalary, double compensation) {
		this.employeeID = employeeID;
		this.hiredYear = hiredYear;
		this.title = title;
		this.baseSalary = baseSalary;
		this.compensation = compensation;
	}

	/**
	 * The toString method print out the information for a employee
	 */
	public String toString() {
		return String.format("This is a %s. ID is %d, hired since %d, and total compensation is $%,.2d ", this.title,
				this.employeeID, this.hiredYear, this.compensation);
	}

	/**
	 * The getEmployeeID return the variable in the employeeID field
	 * 
	 * @return the employeeID variable in the employeeID field
	 */
	public int getEmployeeID() {
		return employeeID;
	}

	/**
	 * The setEmployeeID set the variable for employeeID field
	 * 
	 * @param employeeID the employeeID to set the variable for employeeID field
	 */
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	/**
	 * The getHiredYear return the variable in the hiredYear field
	 * 
	 * @return the hiredYear variable in the hiredYear field
	 */
	public int getHiredYear() {
		return hiredYear;
	}

	/**
	 * The setHiredYear set the variable for hiredYear field
	 * 
	 * @param hiredYear the hiredYear to set the variable for hiredYear field
	 */
	public void setHiredYear(int hiredYear) {
		this.hiredYear = hiredYear;
	}

	/**
	 * The getTitle return the variable in the title field
	 * 
	 * @return the title variable in the title field
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * The setTitle set the variable for title field
	 * 
	 * @param title the title to set the variable for title field
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * The getBaseSalary return the variable in the baseSalary field
	 * 
	 * @return the baseSalary variable in the baseSalary field
	 */
	public double getBaseSalary() {
		return baseSalary;
	}

	/**
	 * The setBaseSalary set the variable for baseSalary field
	 * 
	 * @param baseSalary the baseSalary to set the variable for baseSalary field
	 */
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	/**
	 * The getCompensation return the variable in the compensation field
	 * 
	 * @return the compensation variable in the compensation field
	 */
	public double getCompensation() {
		return compensation;
	}

	/**
	 * The setCompensation set the variable for compensation field
	 * 
	 * @param compensation the compensation to set the variable for compensation
	 *                     field
	 */
	public void setCompensation(double compensation) {
		this.compensation = compensation;
	}
}
/* ========================================================================== */ 
/*                      E N D   O F  C L A S S                                */
/* ========================================================================== */
