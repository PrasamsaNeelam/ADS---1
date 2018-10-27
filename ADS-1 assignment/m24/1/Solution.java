/**
 * Imports Scanner class.
 * @author: Prasamsa
 * Date: 27th October, 2018.
 */
import java.util.Scanner;
/**
 * Class for student.
 */
class Student {
    /**
     * Variable for student roll number.
     */
    private String roll;
    /**
     * Variable for student's name.
     */
    private String name;
    /**
     * Variable for student marks.
     */
    private Double marks;
    /**
     * Constructs the object.
     *
     * @param      rollno  The rollno
     * @param      name1   The name 1
     * @param      marks1  The marks 1
     */
    Student(String rollno, String name1, Double marks1) {
        this.roll = rollno;
        this.name = name1;
        this.marks = marks1;
    }
    Student(String rollno) {
        this.roll = rollno;
    }
    /**
     * Gets the roll.
     *
     * @return     The roll.
     */
    public String getRoll() {
        return this.roll;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Gets the marks.
     *
     * @return     The marks.
     */
    public Double getMarks() {
        return this.marks;
    }
}
/**
 * Class for separate chaining hash st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class SeparateChainingHashST<Key, Value> {
    /**
     * variable for capacity.
     */
    private static final int INIT_CAPACITY = 4;
    /**
     * variable for number of key-value pairs.
     */
    private int n;
    /**
     * variable for hash table size .
     */
    private int m;
    /**
     * variable for array of linked-list symbol tables.
     */
    private SequentialSearchST<Key, Value>[] st;

    /**
     * Initializes an empty symbol table.
     */
    SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Constructs the object.
     *
     * @param      m1     { parameter_description }
     */
    SeparateChainingHashST(final int m1) {
        this.m = m1;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m1];
        for (int i = 0; i < m1; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    /**
     * { resize the hash table to have the given number
     *   of chains,rehashing all of the keys}.
     *
     * Complexity :
     *              Best Case : O(N)
     *              Average Case : O(N)
     *              Worst Case : O(N)
     *
     * @param      chains  The chains
     */
    private void resize(final int chains) {
        SeparateChainingHashST<Key, Value> temp = new
        SeparateChainingHashST<Key, Value>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m  = temp.m;
        this.n  = temp.n;
        this.st = temp.st;
    }

    /**
     * { hash value between 0 and m-1 }.
     *
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private int hash(final Key key) {
        final int fff = 0x7fffffff;
        return (key.hashCode() & fff) % m;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Determines if empty.
     *
     * Complexity :
     *              Best Case : O(1)
     *              Average Case : O(1)
     *              Worst Case : O(1)
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * { Returns true if this symbol table contains the specified key }.
     *
     * Complexity :
     *              Best Case : O(logN)
     *              Average Case : O(logN)
     *              Worst Case : O(logN)
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to contains() is null");
        }
        return get(key) != null;
    }

    /**
     * { Returns the value associated with the specified
     *   key in this symbol table }.
     *
     *   Complexity :
     *              Best Case : O(logN)
     *              Average Case : O(logN)
     *              Worst Case : O(logN)
     *
     * @param      key   The key
     *
     * @return     { the value associated with in the symbol table }
     */
    public Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to get() is null");
        }
        int i = hash(key);
        return st[i].get(key);
    }

    /**
     * { Inserts the specified key-value pair into the symbol table,
     * overwriting the old value with the new value if the symbol table
     * already contains the specified key. Deletes the specified key
     * (and its associated value) from this symbol table
     * if the specified value is }.
     *
     * Complexity :
     *              Best Case : O(logN)
     *              Average Case : O(logN)
     *              Worst Case : O(logN)
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        final int ten = 10;
        if (key == null) {
            throw new IllegalArgumentException(
                "first argument to put() is null");
        }
        if (val == null) {
            delete(key);
            return;
        }
        // double table size if average length of list >= 10
        if (n >= ten * m) {
            resize(2 * m);
        }
        int i = hash(key);
        if (!st[i].contains(key)) {
            n++;
        }
        st[i].put(key, val);
    }

    /**
     * { Removes the specified key and its associated value
     *   from this symbol table (if the key is in this symbol table) }.
     *
     *   Complexity :
     *              Best Case : O(logN)
     *              Average Case : O(logN)
     *              Worst Case : O(logN)
     *
     * @param      key   The key
     */
    public void delete(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to delete() is null");
        }
        int i = hash(key);
        if (st[i].contains(key)) {
            n--;
        }
        st[i].delete(key);
        // halve table size if average length of list <= 2
        if (m > INIT_CAPACITY && n <= 2 * m) {
            resize(m / 2);
        }
    }

    /**
     * { return keys in symbol table as an Iterable }.
     *
     * Complexity :
     *              Best Case : O(N^2)
     *              Average Case : O(N^2)
     *              Worst Case : O(N^2)
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                queue.enqueue(key);
            }
        }
        return queue;
    }
}

/**
 * Class for solution.
 */
public class Solution {
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
        SeparateChainingHashST<String, Student> st = new SeparateChainingHashST<>();
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            String data = s.nextLine();
            String[] tokens = data.split(",");
            Student std = new Student(tokens[0], tokens[1], Double.parseDouble(tokens[2]));
            st.put(tokens[0], std);
        }
        int m = s.nextInt();
        for (int i = 0; i < m; i++) {
            String data = s.nextLine();
            String[] tokens = data.split(" ");
            switch (tokens[2]) {
                case "1":
                String roll = tokens[0];
                if (st.contains(roll)) {
                    System.out.println(st.get(roll).getName());
                }
                break;

                case "2":
                String rollno = tokens[0];
                if (st.contains(rollno)) {
                    System.out.println(st.get(rollno).getName());
                }
                break;
                default:
                break;
            }
        }
    }
}