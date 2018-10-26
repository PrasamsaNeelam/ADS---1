import java.util.Scanner;
class LinearProbingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n;           // number of key-value pairs in the symbol table
    private int m;           // size of linear probing table
    private Key[] keys;      // the keys
    private Value[] vals;    // the values


    /**
     * Initializes an empty symbol table.
     */
    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Initializes an empty symbol table with the specified initial capacity.
     *
     * @param capacity the initial capacity
     */
    public LinearProbingHashST(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
    }
    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

     public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    // hash function for keys - returns value between 0 and M-1
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    private void resize(int capacity) {
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m    = temp.m;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");

        if (val == null) {
            delete(key);
            return;
        }

        // double table size if 50% full
        if (n >= m/2) resize(2*m);

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

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;

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
        if (n > 0 && n <= m/8) resize(m/2);
        // assert check();
    }
    public void display() {
    	String str = "{";
    	for (int i = 0; i < m; i++) {
    		if(keys[i] != null) {
    			str += keys[i] + ":" + get(keys[i]) + ", ";
    		}
    	}
    	str = str.substring(0, str.length() - 2);
    	str += "}";
    	System.out.println(str);
    }
}
public class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
		int lines = Integer.parseInt(s.nextLine());
		while (s.hasNext()) {
			String data = s.nextLine();
			String[] tokens = data.split(" ");
			switch(tokens[0]) {
				case "put":
				st.put(tokens[1], Integer.parseInt(tokens[2]));
				break;
				case "get":
				st.get(tokens[1]);
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
