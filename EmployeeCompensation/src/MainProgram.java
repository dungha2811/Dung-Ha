/* ========================================================================== */
/*	PROGRAM Employee Compensation

    AUTHOR: <Dung Ha>
    COURSE NUMBER: <CIS 210>
    COURSE SECTION NUMBER: <02D>
    INSTRUCTOR NAME: <Dr. Tian>
    PROJECT NUMBER: 10
    DUE DATE: 12/09/2018
SUMMARY
 - This program print out the information of a list of given employee' information and calculate the total compensation of
 each employee and sorted the list by their ID number in ascending order and print out to the console and to an output file.

INPUT

- A file with a list of Employee with given ID number, title, base salary and compensation.

OUTPUT

 - The employee's ID number
 - The employee's hired year
 - The employee's title
 - The employee's base salary
 - The employee's total compensation
 - A summary sentence for each employee with the ID number, hired year and the compensation
 - A special summary sentence for the stock dividend if the employee is a manager
  
ASSUMPTION 

 - The input file must be a csv file or a txt file must be in order : ID, Year, Title, Salary(double), Compensation(double).
 
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/* MAIN FUNCTION */
public class MainProgram {

	public static void main(String[] args) throws IOException {

		// create an ArrayList to take the file data
		ArrayList<Employee> inputList = ReadInputData();

		// create an ArrayList to take the sorted ArrayList
		ArrayList<Employee> list = SelectionSort(inputList);

		// create an object to print out on the file
		PrintWriter pw = new PrintWriter("employeeOutput.txt");

		// create interface object
		EmployeeCompensation total;

		// Print the title
		System.out.printf("%s\t%s\t%s\t\t%s\t%s%n", "ID", "YEAR_HIRED", "TITLE", "BASE_SALARY", "COMPENSATION");
		pw.printf("%s\t%s\t%s\t\t%s\t%s%n", "ID", "YEAR_HIRED", "TITLE", "BASE_SALARY", "COMPENSATION");

		// for loop to print out employee informations
		for (int i = 0; i < list.size(); i++) {

			// print out the information of the employee
			System.out.printf("%d\t%d%18s\t%10s%,.0f", list.get(i).getEmployeeID(), list.get(i).getHiredYear(),
					list.get(i).getTitle(), "$", list.get(i).getBaseSalary());
			pw.printf("%d\t%d%18s\t%10s%,.0f", list.get(i).getEmployeeID(), list.get(i).getHiredYear(),
					list.get(i).getTitle(), "$", list.get(i).getBaseSalary());

			// if the title is manager then call the interface for manager class
			if (list.get(i).getTitle().equals(" Manager")) {

				// call interface object for manager class
				total = new Manager(list.get(i).getEmployeeID(), list.get(i).getHiredYear(), list.get(i).getTitle(),
						list.get(i).getBaseSalary(), list.get(i).getCompensation(), 0);

				// print out the total compensation
				System.out.printf("\t%s%,.0f%n", "$", total.CalculateTotalCompensation());
				pw.printf("\t%s%,.0f%n", "$", total.CalculateTotalCompensation());
			}

			// if the title is manager then call the interface for JuniorEmployee class
			if (list.get(i).getTitle().equals(" Junior")) {

				// call interface object for manager class
				total = new JuniorEmployee(list.get(i).getEmployeeID(), list.get(i).getHiredYear(),
						list.get(i).getTitle(), list.get(i).getBaseSalary(), list.get(i).getCompensation(), 0);

				// print out the total compensation
				System.out.printf("\t%s%,.0f%n", "$", total.CalculateTotalCompensation());
				pw.printf("\t%s%,.0f%n", "$", total.CalculateTotalCompensation());
			}

			// if the title is manager then call the interface for SeniorEmployee class
			if (list.get(i).getTitle().equals(" Senior")) {
				total = new SeniorEmployee(list.get(i).getEmployeeID(), list.get(i).getHiredYear(),
						list.get(i).getTitle(), list.get(i).getBaseSalary(), list.get(i).getCompensation(), 0);

				// print out the total compensation
				System.out.printf("\t%s%,.0f%n", "$", total.CalculateTotalCompensation());
				pw.printf("\t%s%,.0f%n", "$", total.CalculateTotalCompensation());

			}

			// print out the summary sentence (toString() method) of the employee
			System.out.println(list.get(i).toString());
			pw.println(list.get(i).toString());
		}

		// decoration
		System.out.println("_________________________________________________________________________________\n");
		pw.println("_________________________________________________________________________________\n");

		// for loop to print if the employee is a manager
		for (int i = 0; i < list.size(); i++) {

			// if statement to call manager object
			if (list.get(i).getTitle().equals(" Manager")) {
				Manager manObject = new Manager(list.get(i).getEmployeeID(), list.get(i).getHiredYear(),
						list.get(i).getTitle(), list.get(i).getBaseSalary(), list.get(i).getCompensation(), 0);

				// call the ShowDividend method
				manObject.ShowDividend(pw);
			}
		}

		// print greet message
		System.out.println("\nGoodBye!");
		pw.println("\nGoodBye!");

		// close PrintWriter object
		pw.close();
	}

	/**
	 * The ReadInputData method read the data from the input file and store inside
	 * an ArrayList
	 * 
	 * @return array the ArrayList after stored all the data from file as Employee
	 *         object
	 * @throws IOException
	 */
	public static ArrayList<Employee> ReadInputData() throws IOException {

		// create file object to input file
		File inputFile = new File("Employees.csv");

		// if file not exits then terminate the program
		if (!inputFile.exists()) {
			System.out.println("File not exist!");
			System.exit(0);
		}

		// create a scanner object to read the input file
		Scanner input = new Scanner(inputFile);

		// create an ArrayList to store data
		ArrayList<Employee> array = new ArrayList<Employee>();

		// read the first line
		input.nextLine();
		String fromFile;

		// store all the data inside an ArrayList
		while (input.hasNextLine()) {

			// read the string in each line
			fromFile = input.nextLine();

			// split the string out to store each fields in the object
			int mainID = Integer.parseInt(fromFile.split(",")[0]);
			int mainHiredYear = Integer.parseInt(fromFile.split(",")[1]);
			String mainTitle = fromFile.split(",")[2];
			double mainSalary = Double.parseDouble(fromFile.split(",")[3]);
			double mainCompensation = Double.parseDouble(fromFile.split(",")[4]);

			// store all the information inside the arrayList base on the inherit class

			// store into JuniorEmployee subclass
			if (mainTitle.equals(" Junior")) {

				array.add(new JuniorEmployee(mainID, mainHiredYear, mainTitle, mainSalary, mainCompensation, 0));
			}

			// store into SeniorEmployee subclass
			if (mainTitle.equals(" Senior")) {
				array.add(new SeniorEmployee(mainID, mainHiredYear, mainTitle, mainSalary, mainCompensation, 0));
			}

			// store into the Manager subclass
			if (mainTitle.equals(" Manager")) {
				array.add(new Manager(mainID, mainHiredYear, mainTitle, mainSalary, mainCompensation, 0));
			}
		}

		// close the input object
		input.close();

		// return the ArrayList of the method
		return array;
	}

	/**
	 * The SelectionSort method sorted the ArrayList in ascending order
	 * 
	 * @param array the first ArrayList without being sorted
	 * @return array the ArrayList are sorted
	 */
	public static ArrayList<Employee> SelectionSort(ArrayList<Employee> array) {

		// for loop to read through every elements of the array
		for (int i = 0; i < array.size() - 1; i++) {

			// get the smallest position of the array
			int tempPosition = i;

			// this for loop use to compare the smallest position to other position
			for (int j = i + 1; j < array.size(); j++) {

				// if the smallest position greater than the next position
				if (array.get(j).getEmployeeID() < array.get(tempPosition).getEmployeeID()) {

					// then the smallest position will be replaced
					tempPosition = j;
				}
			}

			// swap position to sort the array
			Employee temp = array.get(i);
			array.set(i, array.get(tempPosition));
			array.set(tempPosition, temp);

		}

		// return the sorted array
		return array;
	}
}
/* ========================================================================== */
/*                     E N D      O F     P R O G R A M                       */
/* ========================================================================== */
