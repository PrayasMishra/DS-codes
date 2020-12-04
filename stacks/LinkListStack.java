package stacks;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LinkListStack {

	class StackNode{
		int data;
		StackNode next;

		StackNode(int val){
			this.data = val;
		}
	}
	StackNode root;

	int	peek(){
		if (root == null)
			return Integer.MIN_VALUE;
		else
			return root.data;
	}

	int pop(){
		int poped = Integer.MIN_VALUE;
		if (root == null){
			System.out.println("Stack is empty...");
		}else {
			poped = root.data;
			root = root.next;
		}
		return poped;
	}

	void pushNode(int v){
		StackNode new_node = new StackNode(v);
		if (root == null){
			root = new_node;
		}else {
			StackNode tmp = root;
			root = new_node;
			new_node.next = tmp;
		}
		System.out.println(v + " pushed to stack");
	}

	//boolean isEmpty(){ return (root == null ? true: false); }

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		LinkListStack linkListStack = new LinkListStack();

		System.out.println("enter length stack");
		int n = Integer.valueOf(reader.readLine());
		for (int i = 0; i < n; i++) {
			if (i==0){
				System.out.println("enter node values->");
			}
			linkListStack.pushNode(Integer.valueOf(reader.readLine()));
		}

		System.out.println("popped node value-> "+ linkListStack.pop());
		System.out.println("top node-> "+ linkListStack.peek());

		reader.close();
	}
}
