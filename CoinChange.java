import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
	public static int count(int[] coinset, int len, int amt){
		int[] tab = new int[amt+1];
		Arrays.fill(tab, 0);
		tab[0] = 1;

		for (int i = 0; i < len; i++) {
			for (int j = coinset[i]; j <= amt; j++) {
				tab[j] += tab[j-coinset[i]];
			}
		}
		return tab[amt];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] coin = {1,2,3};
		int n = coin.length;
		int amount = sc.nextInt();
		System.out.print(count(coin,n,amount)+" ways can we make the change for "+amount+" dollars with ");
		for (int i : coin) {
			System.out.print(i+" ");
		}
		System.out.print("coins");
		sc.close();
	}
}
