package hashing;

import java.util.Arrays;

//Given an array of integers. Check whether it contains a triplet that sums up to zero. Also print all the triplets.
public class TripletsSumZero {
	public static void main(String[] args) {
		TripletsSumZero tsz = new TripletsSumZero();
		int[] arr = {0, -1, 2, -3, 1};
		if(tsz.isTripleSumZero(arr)){
			System.out.print("true");
		}else{
			System.out.print("false");
		}
	}

	private boolean isTripleSumZero(int[] arr) {
		Arrays.sort(arr);
		boolean flag = false;
		for (int i = 0; i < arr.length-1; i++) {
			int l = i+1;
			int r = arr.length-1;

			while(l<r){
				if ((arr[i] + arr[l] + arr[r]) == 0) {
					System.out.println(arr[i] +" "+ arr[l] +" "+ arr[r]);
					l++;
					r--;
					flag = true;
				}
				else if (arr[i]+arr[l]+arr[r] < 0) {
					l++;
				} else {
					r--;
				}
			}
		}
		return flag ? true : false;
	}
}
