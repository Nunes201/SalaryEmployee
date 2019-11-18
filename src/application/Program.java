package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter departments's name:");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data:");
		System.out.println("Name: ");
		String workerName = sc.nextLine();
		System.out.println("Level: ");
		String workerLevel = sc.nextLine();
		System.out.println("Base salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
				new Department(departmentName));

		System.out.println("How many contracts to this worker?");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter contract #" + i + " Data");
			System.out.println("Date (DD/MM/YYYY): ");
			Date dateContract = spf.parse(sc.next());
			System.out.println("Value per hour:");
			double valuePerHour = sc.nextDouble();
			System.out.println("Duration (hours): ");
			int durationHours = sc.nextInt();
			HourContract contract = new HourContract(dateContract, valuePerHour, durationHours);
			worker.addContract(contract);
		}

		System.out.println("Enter month and year to calculate income (MM/YYYY): ");
		String montAndYear = sc.next();
		int month = Integer.parseInt(montAndYear.substring(0, 2));
		int year = Integer.parseInt(montAndYear.substring(3));
		System.out.println("Name: "+worker.getName());
		System.out.println("Department: "+worker.getDepartment().getName());
		System.out.println("Income for "+montAndYear+": "+worker.income(year, month));

		sc.close();
	}

}
