package employeeSalaryCalculator;

import java.util.Scanner;

public class salaryCalculator {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter hourly rate: ");
		double rate=sc.nextDouble();
		System.out.print("Enter hours per week worked: ");
		int hours=sc.nextInt();
		if (hours>40) {
			overtimeHours(rate,hours);
		}
		else regularHours(rate,hours);
	}
	
	private static void overtimeHours(double rate, int hours) {
		double salary = rate * 40;
		int overtimeHours = hours - 40;
		salary += rate * overtimeHours * 1.5;
		double monthlySalary = salary * 4.33;
		System.out.println("Monthly gross sakary: $"+monthlySalary);
		double tax = monthlySalary * 0.10;
		System.out.println("Tax deduction (10%): $"+tax);
		double netSalary = monthlySalary - tax;
		System.out.println("Employee's salary including overtime is $"+netSalary);
	}

	private static void regularHours(double rate, int hours) {
		double salary = rate * hours;
		double monthlySalary = salary * 4.33;
		System.out.println("Monthly gross sakary: $"+monthlySalary);
		double tax = monthlySalary * 0.10;
		System.out.println("Tax deduction (10%): $"+tax);
		double netSalary = monthlySalary - tax;
		System.out.println("Employee's salary is $"+netSalary);
	}
}
