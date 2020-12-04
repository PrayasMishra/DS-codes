import java.util.Scanner;

class Seive{
	static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();
		System.out.print("prime numbers till "+n+" are: ");
		seive(n);
		sc.close();
	}

	public static void printArray(int[] a){
		for(int i = 2; i < a.length; i++)
		{
			if(a[i] == 0)
				System.out.print(i+" ");
		}
	}

	public static void seive(int n){
		int[] b = new int[n+1];
		for (int i = 2; i*i < n; i++) {
			if (b[i] == 0) {
				for (int j = i*2; j <= n; j+=i) {
					b[j] = 1;
				}
			}
		}
		printArray(b);
	}

}