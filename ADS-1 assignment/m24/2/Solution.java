import java.util.Scanner;

class Student implements Comparable<Student>{
	/**
    * Class for node.
    */
    class Node {
        /**
         * key variable.
         */
        private Book key;
        /**
         * value variable.
         */
        private int value;
        /**
         * left node variable.
         */
        private Node left;
        /**
         * right node varible.
         */
        private Node right;
        /**
         * Constructs the object.
         *
         * @param      k     The key
         * @param      val   The value
         */
        Node(final Book k, final int val) {
            this.key = k;
            this.value = val;
        }
    }
	/**
	 * { variable for student rollnumber }.
	 */
	int roll;
	/**
	 * { variable for student name }.
	 */
	String name;
	/**
	 * { variable for student marks }.
	 */
	double marks;
	Student() {

	}
	Student(final int rollno, final String name1, final double marks1) {
		this.roll  = rollno;;
		this.name = name1;
		this.marks = marks1;
	}
	public int compareTo(final Student other) {
        return this.marks.compareTo(other.marks);
    }
}
/**
 * Class for binary search tree.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchTree<Key, Value> {
    /**
     * root variable.
     */
    private Node root;
    /**
     * Constructs the object.
     */
    BinarySearchTree() {

    }
    /**
     * Gets the value for key.
     *
     * Time complexity is O(log(N)).
     *
     * @param      key   The key
     *
     * @return     returns string type.
     */
    String get(final Book key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                String str = String.valueOf(x.value);
                return str;
            }
        }
        return null;
    }
    /**
     * Inserts the key and value.
     *
     * Time complexity is O(log(N)).
     *
     * @param      key   The key
     * @param      val   The value
     */
    void put(final Book key, final int val) {
        root = put(root, key, val);
    }
    /**
     * Puts the value in the array.
     *
     * @param      obj   The object
     * @param      key   The key
     * @param      val   The value
     *
     * @return     { description_of_the_return_value }
     */
    Node put(final Node obj, final Book key, final int val) {
        if (obj == null) {
            return new Node(key, val);
        }
        int cmp = key.compareTo(obj.key);
        if (cmp > 0) {
            obj.right = put(obj.right, key, val);
        } else if (cmp < 0) {
            obj.left = put(obj.left, key, val);
        } else {
            obj.value = val;
            //return obj;
        }
        return obj;
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
     * Main function to drive the program.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BinarySearchTree<Student, Integer> bst = new BinarySearchTree<>();
        int n = Integer.parseInt(s.nextLine());
        Student std = new Student();
        for (int i = 0; i < n; i++) {
            String data = s.nextLine();
            String[] tokens = data.split(",");
            std = new Student(Integer.parseInt(tokens[0]), tokens[1], Double.parseDouble(tokens[2]));
            bst.put(std, Integer.parseInt(tokens[0]));
        }
        int m = Integer.parseInt(s.nextLine());
        for (int i = 0; i < m; i++) {
            String data = s.nextLine();
            String[] tokens = data.split(",");
        }
    }
}
