package hashing;

/*	Given 3 arrays sorted in increasing order,
	print all common elements in these arrays.
*/
public class CommonElements {
	public static void main(String[] args) {
		CommonElements ce = new CommonElements();
		int a[] = {1, 5, 10, 15, 40, 80};
		int b[] = {6, 7, 15, 80, 100};
		int c[] = {3, 4, 15, 30, 70, 80, 120};
		System.out.print("Common elements are...");
		ce.findCommon(a,b,c);
	}

	private void findCommon(int[] a, int[] b, int[] c) {
		int i=0,j=0,k=0;

		while (i < a.length && j < b.length && k < c.length){
			if(a[i] == b[j] && b[j] == c[k])
			{
				System.out.print(a[i]+" ");
				i++;
				j++;
				k++;
			}
			else if (a[i] < b[j])
				i++;
			else if (b[j] < c[k])
				j++;
			else //a[i] > c[k] && b[j] > c[k]
				k++;
		}
	}
}
