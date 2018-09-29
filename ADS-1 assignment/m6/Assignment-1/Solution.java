import java.util.Scanner;
class Node {
	String data;
	Node next;
	Node() {

	}
	Node(String data) {
		this.data = data;
		next = null;
	}
}
class LinkedList {
	Node first;
	Node last;
	int size;
	LinkedList() {
		first = new Node();
		last = new Node();
		size = 0;
	}
	void insert(String item) {
		Node object = new Node(item);
		if (size == 0) {
			first = object;
			last = object;
			size++;
			return;
		}
		last.next = object;
		last = object;
		size++;
	}
	String delete() {
		String data = last.data;
		last = last.next;
		size--;
		return data;
	}
	boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}
	int size() {
		return size;
	}
}
class Stack {
	LinkedList ll ;
	Stack () {
		ll = new LinkedList();
	}

	void push(String item) {
		ll.insert(item);
	}
	String pop() {
		return ll.delete();
	}
	boolean isEmpty() {
		return ll.isEmpty();
	}
	int size() {
		return ll.size();
	}
}

class AddLargeNumbers {

	public static LinkedList numberToDigits(String number) {
		LinkedList obj = new LinkedList();
		for (int i = 0; i < number.length(); i++) {
			String s = number.charAt(i) + "";
			obj.insert(s);
		}
		return obj;

	}

	public static String digitsToNumber(LinkedList list) {
		Node node = list.first;
		String str = new String();
		for (int i = 0; i < list.size; i++) {
			str += node.data;
			node = node.next;
		}
		return str;
	}
	// public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {

	// }
}

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String p = sc.nextLine();
		String q = sc.nextLine();
		switch (input) {
		case "numberToDigits":
			LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
			LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
			System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
			System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
			break;

			// case "addLargeNumbers":
			// 	pDigits = AddLargeNumbers.numberToDigits(p);
			// 	qDigits = AddLargeNumbers.numberToDigits(q);
			// 	LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
			// 	System.out.println(AddLargeNumbers.digitsToNumber(result));
			// 	break;
		}
	}

}
