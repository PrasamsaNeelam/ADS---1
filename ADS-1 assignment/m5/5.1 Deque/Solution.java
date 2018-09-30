import java.util.Scanner;
/**
 * Class for deque.
 *
 * @param      <Item>  The item
 */
class Deque<Item> {
	Node first = null;
	Node last = null;
	int size = 0;
	/**
	 * Class for node.
	 */
	class Node {
		Item data;
		Node next;
		/**
		 * Constructs the object.
		 *
		 * @param      data  The data
		 */
		Node(Item data) {
			this.data = data;
		}
	}
	/**
	 * Determines if empty.
	 *
	 * @return     True if empty, False otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	/**
	 * Gets the size.
	 *
	 * @return     The size.
	 */
	public int getSize() {
		return size;
	}
	/**
	 * Pushes a right.
	 *
	 * @param      element  The element
	 */
	public void pushRight(Item element) {
		Node oldleft = last;
		last = new Node(element);
		if (isEmpty()) {
			first = last;
			last.next = null;
			size++;
			printList();
			return;
		}
		last.next = null;
		oldleft.next = last;
		size++;
		printList();
	}
	/**
	 * Pushes a left.
	 *
	 * @param      element  The element
	 */
	public void pushLeft(Item element) {
		Node oldright = first;
		first = new Node(element);
		if (isEmpty()) {
			last = first;

			size++;
			printList();
			return;

		}
		first.next = oldright;
		size++;
		printList();
	}
	/**
	 * { pops the left element }.
	 *
	 * @return     { returns Item type }
	 */
	public Item popLeft() {
		if (size == 0) {
			System.out.println("Deck is empty");
			return null;
		}
		Item data = first.data;
		if (isEmpty()) {
			return null;
		}
		first = first.next;
		size--;
		printList();
		return data;
	}
	public Item popRight() {
		if (size == 0) {
			System.out.println("Deck is empty");
			return null;
		}
		Item data =  last.data;
		if (isEmpty()) {
			return null;
		}
		int s = 0;
		Node get = first;

		while (s < size - 2) {
			//System.out.println("herre" + size);
			get = get.next;
			//System.out.println(get.data);

			s++;
		}
		last = get;
		get.next = null;
		size--;
		printList();
		return data;
	}
	/**
	 * { prints a list }.
	 */
	public void printList() {
		if (size == 0) {
			System.out.println("[]");
			return;
		}
		Node tnode = first;
		String s = "";
		while (tnode != null) {
			s += tnode.data + ",";
			tnode = tnode.next;
		}
		String[] str = s.split(",");
		String pr = "[";
		for (int i = 0; i < size - 1; i++) {
			pr += str[i] + ", ";
		}
		pr += str[size - 1] + "]";
		System.out.println(pr);
	}
}
/**
 * Class for solution.
 */
class Solution {
	/**
	 * { main function to drive the program }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Deque<Integer> queue = new Deque<>();
		Scanner s = new Scanner(System.in);
		int num = Integer.parseInt(s.nextLine());
		while (s.hasNext()) {
			String[] tokens = s.nextLine().split(" ");
			switch (tokens[0]) {
			case "pushLeft":
				queue.pushLeft(Integer.parseInt(tokens[1]));
				break;
			case "pushRight":
				queue.pushRight(Integer.parseInt(tokens[1]));
				break;
			case "size":
				System.out.println(queue.getSize());
				break;
			case "popLeft":
				queue.popLeft();
				break;
			case "popRight":
				queue.popRight();
				break;
			default:
				break;
			}
		}
	}
}