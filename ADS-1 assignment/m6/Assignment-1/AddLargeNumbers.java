
/**
 * Class for node.
 */
class Node {
	String data;
	Node next;
	/**
	 * Constructs the object.
	 */
	Node() {

	}
	/**
	 * Constructs the object.
	 *
	 * @param      data  The data
	 */
	Node(String data) {
		this.data = data;
		next = null;
	}
}
/**
 * List of linkeds.
 */
class LinkedList {
	Node first;
	Node last;
	int size;
	/**
	 * Constructs the object.
	 */
	LinkedList() {
		first = new Node();
		last = new Node();
		size = 0;
	}
	/**
	 * { function to insert an item }.
	 *
	 * @param      item  The item
	 */
	public void insert(final String item) {
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
	/**
	 * { function to delete an element }.
	 *
	 * @return     { returns String }
	 */
	public String delete() {
		String data = last.data;
		last = last.next;
		size--;
		return data;
	}
	/**
	 * Determines if empty.
	 *
	 * @return     True if empty, False otherwise.
	 */
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}
	/**
	 * { function to keep track of size }.
	 *
	 * @return     { returns int type }
	 */
	public int size() {
		return size;
	}
}
/**
 * List of .
 */
class Stack {
	LinkedList ll ;
	/**
	 * Constructs the object.
	 */
	Stack () {
		ll = new LinkedList();
	}
	/**
	 * { function to push an element into stack }.
	 *
	 * @param      item  The item
	 */
	public void push(String item) {
		ll.insert(item);
	}
	/**
	 * { function to pop an element from stack }.
	 *
	 * @return     { returns String type }
	 */
	public String pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		return ll.delete();
	}
	/**
	 * Determines if empty.
	 *
	 * @return     True if empty, False otherwise.
	 */
	public boolean isEmpty() {
		return ll.isEmpty();
	}
	/**
	 * { function to keep ttrack of size }.
	 *
	 * @return     { returns int type }
	 */
	int size() {
		return ll.size();
	}
}
/**
 * Class for add large numbers.
 */
public class AddLargeNumbers {
	/**
	 * { function to insert the numbers }.
	 *
	 * @param      number  The number
	 *
	 * @return     { returns LinkedList type }
	 */
	public static LinkedList numberToDigits(final String number) {
		LinkedList obj = new LinkedList();
		for (int i = 0; i < number.length(); i++) {
			String c = number.charAt(i)+ "";
			obj.insert(c);
		}
		return obj;

	}
	/**
	 * { function to append the values of each node into String }.
	 *
	 * @param      list  The list
	 *
	 * @return     { returns String type }
	 */
	public static String digitsToNumber(final LinkedList list) {
		String str = "";
		Node node = list.first;
		for (int i = 0; i < list.size; i++) {
			str += node.data;
			node = node.next;
		}
		return str;
	}
	// public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {

	// }
}