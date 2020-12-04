package strings;

import java.util.Scanner;
import java.util.regex.*;

public class PasswordAuthenticator {
	static final Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		String[] strArr = new String[5];
		for (int i = 0; i < strArr.length; i++) {
			strArr[i] = s.next();
		}
		for (int i = 0; i < strArr.length; i++) {
			if (isValid(strArr[i])) {
				System.out.println("Valid");
			}else {
				System.out.println("Not valid");
			}
		}
		s.close();
	}

	public static boolean isValid(String pwd){
		String regex = "^(?=.*[0-9])"
				+ "(?=.*[a-z])(?=.*[A-Z])"
				+ "(?=.*[@#$%^&+=])"
				+ "(?=\\S+$).{8,20}$";

		return Pattern.compile(regex).matcher(pwd).matches();
	}
}
