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
class Steque {
	Node start;
	Node temp;
	Node end;
	int size;
	Steque() {
		start = new Node();
		temp = new Node();
		end = new Node();
		size = 0;
	}
	void push(String item) {
		Node obj = new Node(item);
		if (size == 0) {
			start = obj;
			end = start;
			size++;
			return;
		}
		obj.next = start;
		start = obj;
		size++;
	}
	void enqueue(String item) {
		Node obj = new Node();
		if (size == 0) {
			start = obj;
			end = start;
			size++;
			return;
		}
		end.next = obj;
		end = obj;
		size++;
	}
	String pop() throws Exception {
		if (size == 0) {
			throw new Exception("Steque is empty.");
		}
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
	public String toString() {
		temp = start;
		String out = "";
		while(temp != null) {
			out += temp.data + ", ";
			temp = temp.next;
		}
		return out.substring(0, out.length() - 2);
	}
}

public class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = Integer.parseInt(s.nextLine());
		Steque sq = new Steque();
		while (s.hasNext()) {
			String[] tokens = s.nextLine().split(" ");
			switch(tokens[0]) {
				case "push":
				sq.push(tokens[1]);
				System.out.println(sq);
				break;
				case "pop":
				try {
					sq.pop();
					System.out.println(sq);
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
				case "enqueue":
				sq.enqueue(tokens[1]);
				System.out.println(sq);
				break;
			}
		}
	}
}