/*MANAGER CLASS*/
import java.io.PrintWriter;

public class Manager extends Employee implements EmployeeCompensation {

	private double dividend; // the compensation for manager employee

	/**
	 * 
	 * Constructor
	 */
	public Manager(int employeeID, int hiredYear, String title, double baseSalary, double compensation,
			double dividend) {
		super(employeeID, hiredYear, title, baseSalary, compensation);
		this.setDividend(dividend);
	}

	@Override
	public String toString() {
		return String.format("This is a manager. ID is %d, hired since %d, and stock dividend is $%,.0f.",
				super.getEmployeeID(), super.getHiredYear(), super.getCompensation());
	}

	/**
	 * The ShowDividend method print out a special summary only for manager employee
	 * 
	 * @param pw PrintWriter object to print out in the file
	 */
	public void ShowDividend(PrintWriter pw) {
		System.out.printf("Employee %d is a manager. Dividend is $%,.0f!%n", super.getEmployeeID(), super.getCompensation());
		pw.printf("Employee %d is a manager. Dividend is $%,.0f!%n", super.getEmployeeID(), super.getCompensation());
	}

	/**
	 * Interface method
	 */
	public double CalculateTotalCompensation() {
		setDividend(super.getBaseSalary() + super.getCompensation());
		return getDividend();

	}

	/**
	 * The getDividend return the variable in the dividend field
	 * 
	 * @return the dividend variable in the dividend field
	 */
	private double getDividend() {
		return dividend;
	}

	/**
	 * The setDividend set the variable for dividend field
	 * 
	 * @param dividend the dividend to set the variable for dividend field
	 */
	private void setDividend(double dividend) {
		this.dividend = dividend;
	}
}
/* ========================================================================== */ 
/*                      E N D   O F  C L A S S                                */
/* ========================================================================== */