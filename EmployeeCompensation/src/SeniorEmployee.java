/*SENIOR EMPLOYEE CLASS*/
public class SeniorEmployee extends Employee implements EmployeeCompensation {

	private double annualBonus; // the total compensation of a senior employee

	/**
	 * Constructor
	 */
	public SeniorEmployee(int employeeID, int hiredYear, String title, double baseSalary, double compensation,
			double annualBonus) {
		super(employeeID, hiredYear, title, baseSalary, compensation);
		this.setAnnualBonus(annualBonus);
	}

	@Override
	public String toString() {
		return String.format("This is a senior employee. ID is %d, hired since %d, and annual bonus is $%,.0f.",
				super.getEmployeeID(), super.getHiredYear(), super.getCompensation());
	}

	/**
	 * Interface method
	 */
	public double CalculateTotalCompensation() {
		setAnnualBonus(super.getBaseSalary() + super.getCompensation());
		return getAnnualBonus();
	}

	/**
	 * The getAnnualBonus return the variable in the annualBonus field
	 * 
	 * @return the annualBonus variable in the annualBonus field
	 */
	private double getAnnualBonus() {
		return annualBonus;
	}

	/**
	 * The setAnnualBonus set the variable for annualBonus field
	 * 
	 * @param annualBonus the annualBonus to set the variable for annualBonus field
	 */
	private void setAnnualBonus(double annualBonus) {
		this.annualBonus = annualBonus;
	}
}
/* ========================================================================== */ 
/*                      E N D   O F  C L A S S                                */
/* ========================================================================== */
