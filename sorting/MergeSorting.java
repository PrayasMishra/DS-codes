package sorting;

import java.util.*;

public class MergeSorting {
	static final Scanner sc = new Scanner(System.in);

	static void sort(int[] a, int l, int h){
		if (l<h){
			int mid = (l+h)/2;
			sort(a,l,mid);
			sort(a,mid+1,h);
			mergesort(a,l,mid,h);
		}
	}

	static void mergesort(int[] a, int l, int mid, int h) {
		int k = l;
		int n1 = mid-l+1;
		int n2 = h-mid;
		int[] L = new int[n1];
		int[] R = new int[n2];

		/*Copy data to temp arrays*/
		for (int i = 0; i < n1; i++) {
			L[i] = a[l+i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = a[(mid+1)+j];
		}

		/* Merge the temp arrays */
		int i=0,j=0;
		while (i<n1 && j<n2)
		{// if leftArr element less or equal to rightArr then add to a[].
			if (L[i] <= R[j]){
				a[k] = L[i];
				i++;
			}else {// if leftArr element greater than rightArr then add to a[].
				a[k] = R[j];
				j++;
			}
			k++;	//increment a[] length.
		}	// loop runs till both L[] and R[] are not empty.

		while (i<n1)
		{
			a[k] = L[i];
			i++;
			k++;
		}// loop runs till L[] is not empty.

		while (j<n2)
		{
			a[k] = R[j];
			j++;
			k++;
		}// loop runs till R[] is not empty.
	}

	static void printArray(int arr[])
	{
		for (int i=0; i<arr.length; ++i)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.print("enter array size...");
		int[] arr = new int[sc.nextInt()];

		System.out.print("\nenter array elements...\n");
		for (int i = 0; i<arr.length; ++i)
			arr[i] = sc.nextInt();
		printArray(arr);

		MergeSorting ob = new MergeSorting();
		ob.sort(arr, 0, arr.length - 1);
		System.out.println("sorted array:");
		printArray(arr);

		sc.close();
	}
}
