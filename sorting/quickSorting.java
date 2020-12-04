package sorting;

import java.util.*;

public class quickSorting{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		System.out.println("enter length of array...");
		int n = sc.nextInt();
		int[] arr = new int[n];

		System.out.println("enter elements of array...");
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}

		System.out.println("quick sorting array...");
		quickSort(arr,0, arr.length-1);

		System.out.println("Sorted Array...");
		printArray(arr);

		sc.close();
	}

	static void printArray(int arr[])
	{
		for (int i=0; i<arr.length; ++i)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

	public static void quickSort(int[] a, int low ,int high){
		if(low < high){
			int j = partition(a,low,high);
			quickSort(a,low,j-1);
			quickSort(a,j+1,high);
		}
	}

	public static int partition(int[] a, int low ,int high){
		int pivot = a[low];
		int i = low;
		int j = high;

		while(i<=j) {

			while(a[i] < pivot)
				i++;

			while(a[j] > pivot)
				j--;

			if(i<=j) {
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				i++;
				j--;
			}
		}
		return i;
	}
}