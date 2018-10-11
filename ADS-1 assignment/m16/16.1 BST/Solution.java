import java.util.Scanner;
class Node {
	Book key;
	int value;
	Node left;
	Node right;
	Node(Book k, int val) {
		this.key = k;
		this.value = val;
	}
}

class Book implements Comparable<Book> {
	String name;
	String author;
	Double price;
	Book() {

	}
	Book(String name1, String author1, Double price1) {
		this.name = name1;
		this.author = author1;
		this.price = price1;
	}
	public int compareTo(Book other) {
		return this.name.compareTo(other.name);
	}
}

class BinarySearchTree<Key, Integer> {
	Node root;
	BinarySearchTree() {

	}
	int get(Book key) {
		Node x = root;
		while(x != null) {
			int cmp = key.compareTo(x.key);
			if (cmp < 0) {
				x = x.left;
			} else if (cmp > 0) {
				x = x.right;
			} else {
				return x.value;
			}
		}
		return x.value;
	}

	void put(Book key, int val) {
		root = put(root, key, val);
	}

	Node put(Node obj, Book key, int val) {
		if (obj == null) {
			return new Node(key, val);
		}
		int cmp = (obj.key).compareTo(key);
		if (cmp > 0) {
			obj.right = put(obj.right, key, val);
		} else if(cmp < 0) {
			obj.left = put(obj.left, key, val);
		} else {
			obj.value = val;
			return obj;
		}
		return null;
	}
}

public class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BinarySearchTree<Book, Integer> bst = new BinarySearchTree<Book, Integer>();
		Book book = new Book();
		while (s.hasNext()) {
			String[] tokens = s.nextLine().split(",");
			switch (tokens[0]) {
				case "put":
				book = new Book(tokens[1], tokens[2], Double.parseDouble(tokens[3]));
				bst.put(book, Integer.parseInt(tokens[4]));
				break;
				case "get":
				book = new Book(tokens[1], tokens[2], Double.parseDouble(tokens[3]));
				System.out.println(bst.get(book));
				default:
				break;
		}	
		}
		
	}
}