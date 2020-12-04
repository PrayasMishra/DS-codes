package sepaAssign2;

interface Base1{
	int val = 0;
	void printBase1();
}

interface Base2{
	char letter = 'A';
	void printBase2();
}

public class Derived implements Base1,Base2{
	private double real;

	public void printBase1(){
		System.out.println(val);
	}

	public void printBase2(){
		System.out.println(letter);
	}
}

class Q3{
	public static void main(String[] args) {
		Derived der1 = new Derived();
		der1.printBase1();
		der1.printBase2();
	}
}
