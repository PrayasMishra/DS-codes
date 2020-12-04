package sepaAssign2;

import java.util.Scanner;

public class Employee {
	private String name;
	private int number;

	Employee(String name, int num){
		this.name = name;
		this.number = num;
	}

	void printData(){
		System.out.println("Name: "+name+" EmpNo: "+number);
	}
}

class Manager extends Employee{
	private String title;
	private double clubDues;

	Manager(String name, int num) {
		super(name, num);
	}
}

class Scientist extends Employee{
	private String publication;

	Scientist(String name, int num){
		super(name, num);
	}
}

class Q1{
	final static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		Employee e1 = new Employee(s.next(), s.nextInt());
		Manager m1 = new Manager(s.next(), s.nextInt());
		Scientist s1 = new Scientist(s.next(), s.nextInt());
		e1.printData();
		m1.printData();
		s1.printData();

		s.close();
	}
}