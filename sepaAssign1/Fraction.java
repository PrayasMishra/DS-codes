package sepaAssign1;

import java.util.Scanner;

public class Fraction {
	int nume,deno;

	Fraction(int n, int d){
		if (d!=0){
			this.nume = n;
			this.deno = d;
		}else {
			System.out.println("Error, denominator cannot be zero !");
		}
	}

	static int gcd(int a, int b)
	{
		if (a == 0)
			return b;
		return gcd(b%a, a);
	}

	/* Function to convert the obtained fraction into it's simplest form */
	static void lowest(int den3, int num3)
	{
		int common_factor = gcd(num3,den3);

		// Converting both terms into simpler terms by dividing them by common factor
		den3 = den3/common_factor;
		num3 = num3/common_factor;

		if(num3==0){
			System.out.println(0);
		}else if(num3==1 && den3==1){
			System.out.println(1);
		}else
			System.out.println(num3+"/"+den3);
	}


	public static void addFraction(Fraction f1, Fraction f2)
	{
		// Finding gcd of den1 and den2
		int den3 = gcd(f1.deno,f2.deno);

		// Denominator of final fraction obtained, then finding LCM of den1 and den2
		// LCM * GCD = a * b
		den3 = (f1.deno * f2.deno) / den3;

		// Changing the fractions to have same denominator , Numerator of the final fraction obtained
		int num3 = (f1.nume)*(den3/f1.deno) + (f2.nume)*(den3/f2.deno);

		// Calling function to convert final fraction into it's simplest form
		lowest(den3,num3);
	}

	public static void subFraction(Fraction f1, Fraction f2)
	{
		int den3 = gcd(f1.deno,f2.deno);
		den3 = (f1.deno * f2.deno) / den3;

		int num3 = (f1.nume)*(den3/f1.deno) - (f2.nume)*(den3/f2.deno);
		lowest(den3,num3);
	}

	public static void mulFraction(Fraction f1, Fraction f2)
	{
		int den3 = f1.deno * f2.deno;
		int num3 = f1.nume * f2.nume;
		lowest(den3,num3);
	}

	public static void divFraction(Fraction f1, Fraction f2)
	{
		int den3 = f1.deno * f2.nume;
		int num3 = f1.nume * f2.deno;
		lowest(den3,num3);
	}

}

class Q4{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Fraction f1 = new Fraction(sc.nextInt(),sc.nextInt());
		Fraction f2 = new Fraction(sc.nextInt(),sc.nextInt());

		System.out.print(f1.nume+"/"+f1.deno+" + "+f2.nume+"/"+f2.deno+" is equal to ");
		Fraction.addFraction(f1,f2);

		System.out.print(f1.nume+"/"+f1.deno+" - "+f2.nume+"/"+f2.deno+" is equal to ");
		Fraction.subFraction(f1,f2);

		System.out.print(f1.nume+"/"+f1.deno+" x "+f2.nume+"/"+f2.deno+" is equal to ");
		Fraction.mulFraction(f1,f2);

		System.out.print(f1.nume+"/"+f1.deno+" / "+f2.nume+"/"+f2.deno+" is equal to ");
		Fraction.divFraction(f1,f2);

		sc.close();
	}
}