/**
 * Scanner import.
 */
import java.util.Scanner;
/**
 * Class for separate chaining hash st.
 */
class SeparateChainingHashST {
    /**
     * Capacity of the symbol table.
     */
    private static final int INIT_CAPACITY = 4;
    /**
     * // number of key-value pairs.
     */
    private int n;
    /**
     * // hash table size.
     */
    private int m;
    /**
     * // array of linked-list symbol tables.
     */
    private SequentialSearchST<String, Integer>[] st;
    /**
     * Initializes an empty symbol table.
     */
    SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Constructs the object.
     *
     * @param      m1    The m 1
     */
    SeparateChainingHashST(final int m1) {
        this.m = m1;
        st = (SequentialSearchST<String, Integer>[]) new SequentialSearchST[m1];
        for (int i = 0; i < m1; i++) {
            st[i] = new SequentialSearchST<String, Integer>();
        }
    }

    // resize the hash table to have the given number of chains,
    // // rehashing all of the keys
    // private void resize(int chains) {
    //     SeparateChainingHashST<Key, Value> temp
    //     = new SeparateChainingHashST<Key, Value>(chains);
    //     for (int i = 0; i < m; i++) {
    //         for (Key key : st[i].keys()) {
    //             temp.put(key, st[i].get(key));
    //         }
    //     }
    //     this.m  = temp.m;
    //     this.n  = temp.n;
    //     this.st = temp.st;
    // }

    // hash value between 0 and m-1

    /**
     * Function to generate hash value to given key.
     * Complexity is 1.
     *
     * @param      key   The key
     *
     * @return     { Generated hash value }
     */
    private int hash(final String key) {
        final int data = 0x7fffffff;
        return (key.hashCode() & data) % m;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * Complexity of the function is 1.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Returns true if this symbol table is empty.
     * Complexity is 1.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     * Complexity is 1.
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key};
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(final String key) {
        //if (key == null)
        //throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    /**
     * Returns the value associated with the specified key in this symbol table.
     * Complexity is 1.
     *
     * @param  key the key
     * @return the value associated with {@code key} in the symbol table;
     *         {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Integer get(final String key) {
        //if (key == null)
        //throw new IllegalArgumentException("argument to get() is null");
        int i = hash(key);
        return st[i].get(key);
    }

    /**
     * Inserts the specified key-value pair into
     * the symbol table,overwriting the old
     * value with the new value if the symbol
     * table already contains the specified key.
     * Deletes the specified key (and its
     * associated value) from this symbol table
     * if the specified value is {@code null}.
     * Complexity is 1.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(final String key, final Integer val) {
        // if (key == null)
        //throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }

        // double table size if average length of list >= 10
        // if (n >= 10*m) resize(2*m);

        int i = hash(key);
        if (!st[i].contains(key)) {
            n++;
        }
        st[i].put(key, val);
    }

    /**
     * Removes the specified key and its
     * associated value from this symbol table
     * (if the key is in this symbol table).
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(final String key) {
        //if (key == null)
        //throw new IllegalArgumentException("argument to delete() is null");

        int i = hash(key);
        if (st[i].contains(key)) {
            n--;
        }
        st[i].delete(key);
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * Checks the if the string can be formed from the
     * given words in the magzine.
     * Complexity is N.
     *
     * @param      st     { Hash table object }
     * @param      n      { Length of the string }
     * @param      notes  The notes
     *
     * @return     { Yes or No based on the strings. }
     */
    public static String check(final SeparateChainingHashST st,
        final int n, final String[] notes) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            Integer p = st.get(notes[i]);
            if (p == null || p == 0) {
                return "No";
            }
            st.put(notes[i], --p);
        }
        return "Yes";
    }

    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        SeparateChainingHashST st = new SeparateChainingHashST();
        String[] num = sc.nextLine().split(" ");
        int m = Integer.parseInt(num[0]);
        int n = Integer.parseInt(num[1]);
        while (sc.hasNextLine()) {
            String[] magzine = sc.nextLine().split(" ");
            st = new SeparateChainingHashST(magzine.length);
            for (int i = 0; i < m; i++) {
                if (st.contains(magzine[i])) {
                    int val = st.get(magzine[i]);
                    st.put(magzine[i], ++val);
                } else {
                    st.put(magzine[i], 1);
                }
            }
            String[] str = sc.nextLine().split(" ");
            System.out.println(check(st, n, str));
        }
    }
}


