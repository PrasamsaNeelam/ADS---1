/**
 * imports Scanner class.
 */
import java.util.Scanner;
/**
 * Class for book.
 */
class Book implements Comparable<Book> {
    /**
     * varible for name.
     */
    private String name;
    /**
     * varible for author.
     */
    private String author;
    /**
     * varible for price.
     */
    private float price;
    /**
     * Constructs the object.
     */
    Book() { }
    /**
     * Constructs the object.
     *
     * @param      name1    The name 1
     * @param      author1  The author 1
     * @param      price1   The price 1
     */
    Book(final String name1, final String author1, final float price1) {
        this.name = name1;
        this.author = author1;
        this.price = price1;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the author.
     *
     * @return     The author.
     */
    public String getAuthor() {
        return author;
    }
    /**
     * Gets the price.
     *
     * @return     The price.
     */
    public float getPrice() {
        return price;
    }
    /**
     * compares the objects.
     *
     * @param      other  The other
     *
     * @return     integer
     */
    public int compareTo(final Book other) {
        return this.name.compareTo(other.name);
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return getName() + ", " + getAuthor() + ", " + getPrice();
    }
}
/**
 * Class for node.
 */
class Node {
    /**
     * varible for key.
     */
    private Book key;
    /**
     * varible for value.
     */
    private String value;
    /**
     * varible for left node.
     */
    private Node left;
    /**
     * varible for right node.
     */
    private Node right;
    /**
     * varible for count.
     */
    private int count;
    /**
     * Constructs the object.
     *
     * @param      key1    The key 1
     * @param      value1  The value 1
     * @param      count1  The count 1
     */
    public Node(final Book key1, final String value1, final int count1) {
        this.key = key1;
        this.value = value1;
        this.count = count1;
    }
    /**
     * Gets the key.
     *
     * @return     The key.
     */
    public Book getKey() {
        return key;
    }
    /**
     * Gets the value.
     *
     * @return     The value.
     */
    public String getValue() {
        return value;
    }
    /**
     * Gets the left.
     *
     * @return     The left.
     */
    public Node getLeft() {
        return left;
    }
    /**
     * Gets the right.
     *
     * @return     The right.
     */
    public Node getRight() {
        return right;
    }
    /**
     * Gets the count.
     *
     * @return     The count.
     */
    public int getCount() {
        return count;
    }
    /**
     * Sets the left.
     *
     * @param      left1  The left 1
     */
    public void setLeft(final Node left1) {
        this.left = left1;
    }
    /**
     * Sets the right.
     *
     * @param      right1  The right 1
     */
    public void setRight(final Node right1) {
        this.right = right1;
    }
    /**
     * Sets the value.
     *
     * @param      val   The value
     */
    public void setValue(final String val) {
        this.value = val;
    }
    /**
     * Sets the count.
     *
     * @param      cnt   The count
     */
    public void setCount(final int cnt) {
        this.count = cnt;
    }
}
/**
 * Class for bst.
 */
class Bst {
    /**
     * varible for root.
     */
    private Node root;
    /**
     * Constructs the object.
     */
    Bst() {

    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return count() == 0;
    }
    /**
     * keeps track of count.
     *
     * @return     { integer }
     */
    public int count() {
        return count(root);
    }
    /**
     * keeps track of count.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private int count(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.getCount();
        }
    }
    /**
     * Determines whether key is present.
     *
     * @param      key   The key
     *
     * @return     { boolean }
     */
    public boolean contains(final Book key) {
        return get(key) != null;
    }
    /**
     * Method to insert the key.
     *
     * Time complexity is O(1).
     *
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Book key, final String value) {
        root = put(root, key, value);
    }
    /**
     * Method to insert the keys.
     * Time complexity is O(N) in worst case.
     * @param      x      The node.
     * @param      key    The key
     * @param      value  The value
     *
     * @return     The node.
     */
    public Node put(final Node x, final Book key, final String value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.getName().compareTo(x.getKey().getName());
        if (cmp < 0) {
            x.setLeft(put(x.getLeft(), key, value));
        }
        if (cmp > 0) {
            x.setRight(put(x.getRight(), key, value));
        }
        if (cmp == 0) {
            x.setValue(value);
        }
        x.setCount(1 + count(x.getLeft()) + count(x.getRight()));
        return x;
    }
    /**
     * Method to get value of the key.
     * Time complexity of this method is O(N).
     * @param      key   The key
     *
     * @return     The value of the key
     */
    public String get(final Book key) {
        Node x = root;
        while (x != null) {
            int cmp = key.getName().compareTo(x.getKey().getName());
            if (cmp < 0) {
                x = x.getLeft();
            }
            if (cmp > 0) {
                x = x.getRight();
            }
            if (cmp == 0) {
                return x.getValue();
            }
        }
        return null;
    }
    /**
     * Returns the smallest key in the symbol table.
     *
     * @return     { description_of_the_return_value }
     */
    public Book min() {
        return min(root).getKey();
    }
    /**
     * Returns the minimum key in the symbol table.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node min(final Node x) {
        if (x.getLeft() == null) {
            return x;
        } else {
            return min(x.getLeft());
        }
    }
    /**
     * Returns the largest key in the symbol table.
     *
     * @return     { description_of_the_return_value }
     */
    public Book max() {
        return max(root).getKey();
    }
    /**
     * Returns the largest key in the symbol table.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node max(final Node x) {
        if (x.getRight() == null) {
            return x;
        } else {
            return max(x.getRight());
        }
    }
    /**
     * Returns the largest key in the symbol table less than or equal to.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Book floor(final Book key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.getKey();
        }
    }
    /**
     * Returns the largest key in the symbol table less than or equal to.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Node floor(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.getKey());
        if (cmp == 0) {
            return x;
        }
        if (cmp <  0) {
            return floor(x.getLeft(), key);
        }
        Node t = floor(x.getRight(), key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }
    /**
     * Returns the smallest key in the symbol table greater than or equal to.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Book ceiling(final Book key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.getKey();
        }
    }
    /**
     * Returns the smallest key in the symbol table greater than or equal to.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Node ceiling(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.getKey());
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            Node t = ceiling(x.getLeft(), key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return ceiling(x.getRight(), key);
    }
    /**
     * Return the key in the symbol table whose rank.
     * This is the (k+1)st smallest key in the symbol table.
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Book select(final int k) {
        Node x = select(root, k);
        return x.getKey();
    }
    /**
     * Return the key in the symbol table whose rank.
     * This is the (k+1)st smallest key in the symbol table.
     *
     * @param      x     { parameter_description }
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node select(final Node x, final int k) {
        if (x == null) {
            return null;
        }
        int t = count(x.getLeft());
        if (t > k) {
            return select(x.getLeft(),  k);
        }
        if (t < k) {
            return select(x.getRight(), k - t - 1);
        }
        if (t == k) {
            return x;
        }
        return x;
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    Solution() {

    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        Bst bst = new Bst();
        Book book = new Book();
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
            case "put":
                book = new Book(tokens[1], tokens[2], Float.parseFloat(tokens[3]));
                bst.put(book, tokens[4]);
                break;
            case "get":
                book = new Book(tokens[1], tokens[2], Float.parseFloat(tokens[3]));
                System.out.println(bst.get(book));
                break;
            case "max":
                System.out.println(bst.max());
                break;
            case "min":
                System.out.println(bst.min());
                break;
            case "select":
                System.out.println(bst.select(Integer.parseInt(tokens[1])));
                break;
            case "floor":
                book = new Book(tokens[1], tokens[2], Float.parseFloat(tokens[3]));
                System.out.println(bst.floor(book));
                break;
            case "ceiling":
                book = new Book(tokens[1], tokens[2], Float.parseFloat(tokens[3]));
                System.out.println(bst.ceiling(book));
                break;
            default:
                break;
            }
        }
    }
}
