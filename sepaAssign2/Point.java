package sepaAssign2;

import graphs.CyclicGraph;

import java.util.Scanner;

public class Point {
	private double xCo,yCo;

	Point(){
		this.xCo = 0.0;
		this.yCo = 0.0;
	}

	Point(double x, double y){
		this.xCo = x;
		this.yCo = y;
	}

	void printPoint(){
		System.out.println("x coordinate: "+xCo+" y coordinate: "+yCo);
	}
}

class Circle extends Point{
	private double radius;

	Circle(double r){
		this.radius = r;
	}

	void printArea(){
		System.out.println("Area of circle = "+3.14*radius*radius);
	}
}

class Cylinder extends Circle{
	private double height;
	private double radius;

	Cylinder(double h,double r){
		super(r);
		this.radius = r;
		this.height = h;
	}

	void printArea(){
		System.out.println("Area of cylinder = "+2*3.14*radius*height);
	}

	void printVolume(){
		System.out.println("Volume of cylinder = "+3.14*radius*radius*height);
	}
}

class Q2{
	final static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		Point p1 = new Point(s.nextDouble(), s.nextDouble());
		Circle cr1 = new Circle(s.nextDouble());
		Cylinder cy1 = new Cylinder(s.nextDouble(), s.nextDouble());

		p1.printPoint();
		cr1.printArea();
		cy1.printArea();
		cy1.printVolume();

		s.close();
	}
}
