package sepaAssign2;

import java.util.Scanner;

abstract class Emp{
	String name;
	int eid;

	Emp(){
		this.name = null;
		this.eid = 0;
	}

	Emp(String n, int id){
		this.name = n;
		this.eid = id;
	}

	public abstract void earnings();
	public abstract void printData();
}

class Boss extends Emp{
	double weeklySal;

	Boss(String n,int id,double wsal){
		super(n,id);
		this.weeklySal = wsal;
	}

	@Override
	public void earnings() {
		System.out.println("earnings(1month): \u20B9"+weeklySal*4);
	}

	@Override
	public void printData() {
		System.out.println("name: "+name);
		System.out.println("employee id: "+eid);
		System.out.println("weekly salary: \u20B9"+weeklySal);
	}
}

class HrlyWorker extends Emp{
	double wage,hr;

	HrlyWorker(String n,int id,double w, double h){
		super(n,id);
		this.wage = w;
		this.hr = h;
	}

	@Override
	public void earnings() {
		System.out.println("earnings(hours worked): \u20B9"+wage*hr);
	}

	@Override
	public void printData() {
		System.out.println("name: "+name);
		System.out.println("employee id: "+eid);
		System.out.println("wage: \u20B9"+wage);
		System.out.println("hours: "+hr);
	}
}

class CommissionWorker extends Emp{
	double sal,comm;
	int quant;

	CommissionWorker(String n,int id,double s, double com, int q){
		super(n,id);
		this.sal = s;
		this.comm = com;
		this.quant = q;
	}

	@Override
	public void earnings() {
		double tot = sal + sal * comm * quant / 100;
		System.out.println("earnings(commission included): \u20B9"+tot);
	}

	@Override
	public void printData() {
		System.out.println("name: "+name);
		System.out.println("employee id: "+eid);
		System.out.println("salary: \u20B9"+sal);
		System.out.println("commission: "+comm+"%");
		System.out.println("quantity: "+quant);
	}
}

class PieceWorker extends Emp{
	double wagePerPiece;
	int quant;

	PieceWorker(String n,int id,double wpp, int q){
		super(n,id);
		this.wagePerPiece = wpp;
		this.quant = q;
	}

	@Override
	public void earnings() {
		System.out.println("earnings(per piece): \u20B9"+wagePerPiece*quant);
	}

	@Override
	public void printData() {
		System.out.println("name: "+name);
		System.out.println("employee id: "+eid);
		System.out.println("wage per piece(wpp): \u20B9"+wagePerPiece);
		System.out.println("quantity: "+quant);
	}
}

public class Q4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter boss name, id and weekly salary: ");
		Boss bo1 = new Boss(sc.nextLine(),sc.nextInt(),sc.nextDouble());
		bo1.printData();
		bo1.earnings();

		System.out.println("enter HrlyWorker name, id, wage and hours worked: ");
		HrlyWorker hw1 = new HrlyWorker(sc.nextLine(),sc.nextInt(),sc.nextDouble(),sc.nextInt());
		hw1.printData();
		hw1.earnings();

		System.out.println("enter CommissionWorker name, id , salary, commission and quantity: ");
		CommissionWorker cw1 = new CommissionWorker(sc.nextLine(),sc.nextInt(),sc.nextDouble(),sc.nextDouble(),sc.nextInt());
		cw1.printData();
		cw1.earnings();

		System.out.println("enter PieceWorker name, id, wage per piece(wpp) and quantity: ");
		PieceWorker pw1 = new PieceWorker(sc.nextLine(),sc.nextInt(),sc.nextDouble(),sc.nextInt());
		pw1.printData();
		pw1.earnings();

		sc.close();
	}
}