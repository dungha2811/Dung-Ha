/*JUNIOR EMPLOYEE CLASS*/
public class JuniorEmployee extends Employee implements EmployeeCompensation {

	private double commission; // the compensation for junior employee

	/**
	 * Constructor
	 */
	public JuniorEmployee(int employeeID, int hiredYear, String title, double baseSalary, double compensation,
			double commission) {
		super(employeeID, hiredYear, title, baseSalary, compensation);
		this.setCommission(commission);
	}

	@Override
	public String toString() {
		return String.format("This is a junior employee. ID is %d, hired since %d, and commission is $%,.0f.",
				super.getEmployeeID(), super.getHiredYear(), super.getCompensation());
	}

	/**
	 * Interface method
	 */
	public double CalculateTotalCompensation() {
		setCommission(super.getBaseSalary() + super.getCompensation());
		return getCommission();
	}

	/**
	 * The getCommission return the variable in the commission field
	 * 
	 * @return the commission variable in the commission field
	 */
	private double getCommission() {
		return commission;
	}

	/**
	 * The setCommission set the variable for commission field
	 * 
	 * @param commission the commission to set the variable for commission field
	 */
	private void setCommission(double commission) {
		this.commission = commission;
	}

}
/* ========================================================================== */ 
/*                      E N D   O F  C L A S S                                */
/* ========================================================================== */
