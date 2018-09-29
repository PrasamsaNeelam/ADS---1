import java.util.Scanner;
class Node {
	String data;
	Node next;
	Node() {

	}
	Node(String data) {
		this.data = data;
	}
}
class LinkedList {
	Node start;
	int size;
	LinkedList(){
		start = new Node();
		size = 0;
	}
	void insert(String item) {
		Node obj = new Node();
		obj.data = item;
		if(size == 0){
			start = obj;
			size++;
			return;
		}
		obj.next = start;
		start = obj;
	}
	String delete() {
		String data = start.data;
		start = start.next;
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
class Stack{
	LinkedList ll ;
	Stack (){
		ll = new LinkedList();
	}
 	void push(String item){
		ll.insert(item);
	}
	String pop(){
		return ll.delete();
	}
	boolean isEmpty(){
		return ll.isEmpty();
	}
	int size(){
		return ll.size();
	}
}

class AddLargeNumbers {

	public static LinkedList numberToDigits(String number) {
		LinkedList obj = new LinkedList();
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			String line  = s.nextLine();
			for (int i = 0; i < line.length() ; i++) {
				String c = line.charAt(i) + "";
				obj.insert(c);
			}
		}
		return obj;
	}

	public static String digitsToNumber(LinkedList list) {
		list = new LinkedList();
		String str = "";
		for (int i = 0; i < list.size; i++) {
			str += i;
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
