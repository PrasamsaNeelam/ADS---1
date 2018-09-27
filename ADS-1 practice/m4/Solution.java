import java.util.Scanner;
class  Stack {
	int size;
	String[] arr;
	Stack() {
		size = 0;
		arr = new String[20];
	}
	void push(String item) {
		arr[size++] = item;
	}
	boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}
	String pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		return arr[--size];
	}
}
class Solution {
	public static void main(String[] args) {
		Stack stack = new Stack();
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			String line = s.nextLine();
			if (line.equals("-")) {
				System.out.println(stack.pop());
			} else {
				stack.push(line);
			}
		}
	}
}