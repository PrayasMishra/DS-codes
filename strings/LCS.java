package strings;

import java.util.Scanner;

public class LCS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LCS lcs = new LCS();
		String s1 = sc.next();
		String s2 = sc.next();
		char[] x = s1.toCharArray();
		char[] y = s2.toCharArray();
		int m = x.length;
		int n = y.length;
		System.out.println("Length of strings.LCS is "+ lcs.lcs(x,y,m,n));
		sc.close();
	}

	int max(int p, int q)
	{
		return p>q ? p : q;
	}

	int lcs(char[] x, char[] y, int m, int n){
		int[][] L = new int[m+1][n+1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					L[i][j] = 0;
				}else if (x[i-1] == y[j-1]){
					L[i][j] = L[i-1][j-1] + 1;
				}else{
					L[i][j] = max(L[i-1][j], L[i][j-1]);
				}
			}
		}
		return L[m][n];
	}
}
