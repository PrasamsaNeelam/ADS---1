import java.util.Scanner;
class Node {
	String data;
	Node next;
	Node(String data) {
		this.data = data;
	}
}
class LinkedList {
	Node start;
	int size;
	LinkedList() {
		start = null;
		size = 0;
	}
	void insertAt(int index, String element) throws Exception {
		Node obj = new Node(element);
		if (index < 0 || index > size) {
			throw new Exception();
		}
		Node previous = null;
		Node temp = start;
		int count = 0;
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
	Node insertAt(int index, Node first, Node obj, int count) {
		if (index == count) {
			obj.next = first;
			size++;
			return obj;
		}
		start.next = insertAt(index, start.next, obj, count + 1);
		return start;
	}
	void reverse() {
		reverse(null, start);
	}
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

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
   private Solution() {
    }

    /**
     * { main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        while (s.hasNextLine()) {
            String[] input = s.nextLine().split(" ");
            switch (input[0]) {
                case "insertAt" :
                try {
                ll.insertAt(Integer.parseInt(input[1]), input[2]);
                ll.print();
            } catch (Exception e) {
                    System.out.println(
                    "Can't insert at this position.");
                }
                break;
                case "reverse" :
                try {
                ll.reverse();
                ll.print();
            } catch (Exception e) {
                System.out.println("No elements to reverse.");
                }
                break;
                default :
                break;
            }
        }
    }

}
