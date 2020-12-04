package strings;
import java.util.Stack;
public class InfixToPostfix {
	public static void main(String[] args) {
		String str = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.print(convertInfixToPostfix(str));
	}

	private static String convertInfixToPostfix(String exp) {
		String result = new String();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i<exp.length(); ++i) {
			char c = exp.charAt(i);

			// If the scanned character is an operand, add it to output.
			if (Character.isLetterOrDigit(c))
				result += c;

				// If the scanned character is an '(', push it to the stack.
			else if (c == '(')
				stack.push(c);
				//  If the scanned character is an ')', pop and output from the stack until an '(' is encountered.
			else if (c == ')')
			{
				while (!stack.isEmpty() && stack.peek() != '(')
					result += stack.pop();

				if (!stack.isEmpty() && stack.peek() != '(')
					return "Invalid Expression";
				else
					stack.pop();
			}
			else // an operator is encountered
			{
				while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())){
					if(stack.peek() == '(')
						return "Invalid Expression";
					result += stack.pop();
				}
				stack.push(c);
			}

		}
		// pop all the operators from the stack
		while (!stack.isEmpty()){
			if(stack.peek() == '(')
				return "Invalid Expression";
			result += stack.pop();
		}
		return result;
	}

	private static int precedence(Character c) {
		switch (c){
			case '+':
			case'-': return 1;

			case '*':
			case '/': return 2;

			case '^': return 3;
		}
		return -1;
	}
}
