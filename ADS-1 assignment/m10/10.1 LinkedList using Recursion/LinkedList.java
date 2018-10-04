/**
 * Class for node.
 */
class Node {
	String data;
	Node next;
	/**
	 * Constructs the object.
	 *
	 * @param      data  The data
	 */
	Node(String data) {
		this.data = data;
	}
}
/**
 * List of linkeds.
 */
public class LinkedList {
	Node start;
	int size;
	LinkedList() {
		start = null;
		size = 0;
	}
	// time complexity for this method is n
    //takes O(n) time complexity
	void insertAt(int index, String element) throws Exception {
		
		if (index < 0 || index > size) {
			throw new Exception();
		}
		Node obj = new Node(element);
		// Node previous = null;
		// Node temp = start;
		// int count = 0;
		// if (index == 0) {
		// 	obj.next = start;
		// 	start = obj;
		// 	size++;
		// 	return;
		// }
		start = insertAt(index, start, obj, 0);
		// while (temp != null) {
		// 	if (count == index) {
		// 		previous.next = obj;
		// 		obj.next = temp;
		// 		size++;
		// 		return;
		// 	}
		// 	previous = temp;
		// 	temp = temp.next;
		// 	count++;
		// }
	}
	// time complexity for this method is n
    //takes O(n) time complexity
	Node insertAt(int index, Node first, Node obj, int count) throws Exception {
		if (index == count) {
			obj.next = first;
			size++;
			return obj;
		}
		first.next = insertAt(index, first.next, obj, count + 1);
		return first;
	}
	// time complexity for this method is n
    //takes O(n) time complexity
	void reverse() {
		reverse(null, start);
	}
	// time complexity for this method is n
    //takes O(n) time complexity
	void reverse(Node previous, Node current) {
		if (current != null) {
			reverse(current, current.next);
			current.next = previous;
		} else {
			start = previous;
		}
	}
	void print() {
		String str = "";
		Node temp = start;
		while (temp != null) {
			str += temp.data + ", ";
			temp = temp.next;
		}
		System.out.println(str.substring(0, str.length() - 2));
	}
}