package strings;
import java.util.Stack;
public class LongestValidParenthesis {
	public static void main(String[] args) {
		LongestValidParenthesis lvparen = new LongestValidParenthesis();
		String s = "()()())";
		int result = lvparen.LongValidParen(s,s.length());
		System.out.println("longest valid Parenthesis = "+result);
		int no_terms = lvparen.numberOfTermsInTheParenthesis(result);
		System.out.println("no of terms in those parenthesis = "+no_terms);
	}

	private int numberOfTermsInTheParenthesis(int p) {
		return p/2;
	}

	private int LongValidParen(String str, int n) {
		int res = 0;
		Stack <Integer> st = new Stack<>();
		st.push(-1);

		for (int i = 0; i < n; i++) {
			if (str.charAt(i) == '('){
				st.push(i);
			}
			else {
				if (str.charAt(i) == ')')
					st.pop();
				if(st.empty())
					st.push(i);
				if (!st.empty())
					res = Math.max(i - st.peek(), res);
			}
		}
		return res;
	}
}
