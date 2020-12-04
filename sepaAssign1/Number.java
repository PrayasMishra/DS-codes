package sepaAssign1;

import java.util.Scanner;

class Num{
	private int num;
	static int obCount;

	Num(){
		obCount++;
	}

	Num(int n){
		this.num = n;
		obCount++;
	}

	static int countObj(){
		return obCount;
	}

	boolean isPrime(){
		int n = this.num;
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (int i = 5; i * i <= n; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;

		return true;
	}

	int factorial(int n) {	return (n == 1 || n == 0) ? 1 : n * factorial(n - 1); }

	int getSum(int n) {
		int sum = 0;

		while (n != 0) {
			sum = sum + n % 10;
			n = n/10;
		}
		return sum;
	}

	int reversDigits(int num) {
		int rev_num = 0;
		while(num > 0)
		{
			rev_num = rev_num*10 + num%10;
			num = num/10;
		}
		return rev_num;
	}

}

public class Number {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Num n1 = new Num();
		Num n2 = new Num(23);
		Num n3;
		int res = Num.countObj();
		System.out.println("number of objects: "+res);
		System.out.println("is the number prime: "+n2.isPrime());
		System.out.println("factorial of number: "+ n2.factorial(sc.nextInt()));
		System.out.println("sum of digits: "+n2.getSum(sc.nextInt()));
		System.out.println("reverseNumber: "+n2.reversDigits(sc.nextInt()));

		sc.close();
	}
}
