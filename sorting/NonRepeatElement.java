package sorting;

import java.util.*;

/*
Given an array in which all numbers except two are repeated once.
(i.e. we have 2n+2 numbers and n numbers are occurring twice and remaining two have occurred once).
Find those two numbers in the most efficient way.
*/
public class NonRepeatElement {
	public static void main(String[] args) {
		NonRepeatElement nre = new NonRepeatElement();
		int[] arr = {2, 3, 7, 9, 11, 2, 3, 11};
		nre.getAllNonRepeatElementsHashMap(arr);
	}

	private static void getAllNonRepeatElementsHashMap(int arr[]) {
		// Insert all array elements in hash table
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (m.containsKey(arr[i]))
				m.put(arr[i], m.get(arr[i]) + 1);
			else
				m.put(arr[i], 1);
		}
		// Traverse array again and return first element with count 1.
		for (int i = 0; i < arr.length; i++)
			if (m.get(arr[i]) == 1)
				System.out.print(arr[i]+" ");
	}
	/*
	private void get2NonRepeatElementsXOR(int[] arr) {
		int xor = arr[0];
		int set_bit_no;
		int x = 0, y = 0;

		for (int i = 0; i < arr.length; i++)
			xor = xor ^ arr[i];

		set_bit_no = xor & ~(xor - 1);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] & set_bit_no)
				x = x ^ arr[i];
			else
				y = y ^ arr[i];
		}
	}
	*/
}