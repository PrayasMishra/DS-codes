package strings;

import java.util.Scanner;

public class MaxSubarraySum {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println("sum = "+maxSubarraySum(a));
	}

	public static int maxSubarraySum(int[] arr){
		int begin, end = 0, currMax = arr[0], globMax = arr[0], sum = 0;

		for (int i = 1; i < arr.length; i++) {
			currMax = Math.max(arr[i],arr[i]+currMax);
			if (globMax < currMax)
			{
				globMax = currMax;
				end = i;
			}
		}

		for (begin = end; begin >= 0 ; --begin) {
			globMax -= arr[begin];
			if (globMax == 0)
				break;
		}

		for (int i = begin; i <= end; i++) {
			sum += arr[i];
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		return sum;
	}
}
//[-2, -3, 4, -1, -2, 1, 5, -3]