package strings;

import java.util.*;

public class Anagram {
	static final Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		String str1 = s.next();
		String str2 = s.next();
		boolean res = isAnagram(str1,str2);
		System.out.print(res);
		s.close();
	}

	static boolean isAnagram(String s1, String s2){
		if (s1.length() != s2.length())
			return false;
		else {
			char[] s1_char = s1.toCharArray();
			char[] s2_char = s2.toCharArray();
			Arrays.sort(s1_char);
			Arrays.sort(s2_char);

			for (int i = 0; i < s1.length(); i++) {
				if (s1_char[i] != s2_char[i])
					return false;
			}
		}
		return true;
	}
}
