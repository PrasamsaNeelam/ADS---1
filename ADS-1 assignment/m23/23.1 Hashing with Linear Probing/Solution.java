import java.util.Scanner;
/**
 * Class for linear probing hash st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class LinearProbingHashST<Key, Value> {
    /**
     * Variable for capacity.
     */
    private static final int INIT_CAPACITY = 4;
    /**
     * Variable for number of key-value pairs in the symbol table.
     */
    private int n;
    /**
     * Variable for size of linear probing table.
     */
    private int m;
    /**
     * Variable for the keys.
     */
    private Key[] keys;
    /**
     * Variable for the values.
     */
    private Value[] vals;

    /**
     * Initializes an empty symbol table.
     */
    LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Initializes an empty symbol table with the specified initial capacity.
     *
     * @param      capacity  The capacity
     */
    LinearProbingHashST(final int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
    }
    /**
     * Function to determine the size.
     *
     * Time complexity is O(1).
     *
     * @return     { integer value }
     */
    public int size() {
        return n;
    }
    /**
     * Determines if empty.
     *
     * Time complexity is O(1).
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * checks whether the key is present.
     *
     * Time complexity is O(1).
     *
     * @param      key   The key
     *
     * @return     Key type.
     */
    public boolean contains(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to contains() is null");
        }
        return get(key) != null;
    }

    /**
    * hash function for keys - returns value between 0 and M-1.
    *
    * @return    Key type
    *
    * @param    key   Key type
    */
    private int hash(final Key key) {
        final int num = 11;
        return (num * key.hashCode()) % m;
    }
    /**
     * resize function.
     *
     * Time complexity is O(N).
     *
     * @param      capacity  The capacity
     */
    private void resize(final int capacity) {
        LinearProbingHashST<Key, Value> temp =
            new LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m    = temp.m;
    }
    /**
     * Function to insert key-value pair.
     *
     * Time complexity is O(log(N)).
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        if (key == null) {
            throw new IllegalArgumentException(
                "first argument to put() is null");
        }
        if (val == null) {
            delete(key);
            return;
        }

        // double table size if 50% full
        if (n >= m / 2) {
            resize(2 * m);
        }

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }
    /**
     * Function to get value for key.
     *
     * Time complexity is O(log(N))
     *
     * @param      key   The key
     *
     * @return     { Key type }
     */
    public Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to get() is null");
        }
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }
    /**
     * Function to delete the key-value pair.
     *
     * Time complexity is O(log(N))
     *
     * @param      key   The key
     */
    public void delete(final Key key) {
        final int no = 8;
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        if (!contains(key)) {
            return;
        }
        // find position i of key
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }

        // delete key and associated value
        keys[i] = null;
        vals[i] = null;

        // rehash all keys in same cluster
        i = (i + 1) % m;
        while (keys[i] != null) {
            // delete keys[i] an vals[i] and reinsert
            Key   keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }
        n--;
        // halves size of array if it's 12.5% full or less
        if (n > 0 && n <= m / no) {
            resize(m / 2);
        }
    }
    /**
     * Display function.
     *
     * Time complexity is O(N).
     */
    public void display() {
        if (size() == 0) {
            System.out.println("{}");
            return;
        }
        String str = "{";
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                str += keys[i] + ":" + get(keys[i]) + ", ";
            }
        }
        str = str.substring(0, str.length() - 2);
        str += "}";
        System.out.println(str);
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
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        LinearProbingHashST<String, Integer> st =
        new LinearProbingHashST<String, Integer>();
        int lines = Integer.parseInt(s.nextLine());
        while (s.hasNext()) {
            String data = s.nextLine();
            String[] tokens = data.split(" ");
            switch (tokens[0]) {
            case "put":
                st.put(tokens[1], Integer.parseInt(tokens[2]));
                break;
            case "get":
                System.out.println(st.get(tokens[1]));
                break;
            case "display":
                st.display();
                break;
            case "delete":
                st.delete(tokens[1]);
                break;
            default:
                break;
            }
        }
    }
}
