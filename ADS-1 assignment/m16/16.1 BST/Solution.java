import java.util.Scanner;
/**
 * Class for book.
 */
class Book implements Comparable<Book> {
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
     * name variable.
     */
    private String name;
    /**
     * author variable.
     */
    private String author;
    /**
     * price variable.
     */
    private Double price;
    /**
     * Constructs the object.
     */
    Book() {

    }
    /**
     * Constructs the object.
     *
     * @param      name1    The name 1
     * @param      author1  The author 1
     * @param      price1   The price 1
     */
    Book(final String name1, final String author1, final Double price1) {
        this.name = name1;
        this.author = author1;
        this.price = price1;
    }
    /**
     * compares the objects.
     *
     * @param      other  The other
     *
     * @return     returns integer value.
     */
    public int compareTo(final Book other) {
        return this.name.compareTo(other.name);
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
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        BinarySearchTree<Book, Integer> bst = new BinarySearchTree<Book,
        Integer>();
        Book book = new Book();
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
            case "put":
                book = new Book(tokens[1], tokens[2],
                                Double.parseDouble(tokens[2 + 1]));
                bst.put(book, Integer.parseInt(tokens[2 + 2]));
                break;
            case "get":
                book = new Book(tokens[1], tokens[2],
                                Double.parseDouble(tokens[2 + 1]));
                System.out.println(bst.get(book));
            default:
                break;
            }
        }
    }
}
