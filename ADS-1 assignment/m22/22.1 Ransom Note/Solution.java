import java.util.*;
class SeparateChainingHashST {
    private static final int INIT_CAPACITY = 4;
    int n;                                // number of key-value pairs
    int m;                                // hash table size
    SequentialSearchST<String, Integer>[] st;  // array of linked-list symbol tables
    /**
     * Initializes an empty symbol table.
     */
    public SeparateChainingHashST() {
        this(INIT_CAPACITY);
    } 

    /**
     * Initializes an empty symbol table with {@code m} chains.
     * @param m the initial number of chains
     */
    public SeparateChainingHashST(int m) {
        this.m = m;
        st = (SequentialSearchST<String, Integer>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchST<String, Integer>();
    } 

    // resize the hash table to have the given number of chains,
    // // rehashing all of the keys
    // private void resize(int chains) {
    //     SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<Key, Value>(chains);
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
    private int hash(String key) {
        return (key.hashCode() & 0x7fffffff) % m;
    } 

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    } 

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key};
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(String key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    } 

    /**
     * Returns the value associated with the specified key in this symbol table.
     *
     * @param  key the key
     * @return the value associated with {@code key} in the symbol table;
     *         {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Integer get(String key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int i = hash(key);
        return st[i].get(key);
    } 

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(String key, Integer val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }

        // double table size if average length of list >= 10
        // if (n >= 10*m) resize(2*m);

        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].put(key, val);
    } 

    /**
     * Removes the specified key and its associated value from this symbol table     
     * (if the key is in this symbol table).    
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(String key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");

        int i = hash(key);
        if (st[i].contains(key)) n--;
        st[i].delete(key);

        // halve table size if average length of list <= 2
        // if (m > INIT_CAPACITY && n <= 2*m) resize(m/2);
    } 

    // return keys in symbol table as an Iterable
    // public Iterable<Key> keys() {
    //     Queue<Key> queue = new Queue<Key>();
    //     for (int i = 0; i < m; i++) {
    //         for (Key key : st[i].keys())
    //             queue.enqueue(key);
    //     }
    //     return queue;
    // }
    
}
class Solution {
    Solution() {

    }

    public static String check(SeparateChainingHashST st, int n, String[] data) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            // if (!st.contains(data[i])) {
   //              return "No";
            // }
            Integer p = st.get(data[i]);
            //System.out.println(p);
            
            if (p == null || p == 0) {
                return "No";
            }
            st.put(data[i], --p);
        }
        return "Yes";
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SeparateChainingHashST st = new SeparateChainingHashST();
        String num = sc.nextLine();
        String[] no = num.split(" ");
        int m = Integer.parseInt(no[0]);
        int n = Integer.parseInt(no[1]);
        while (sc.hasNextLine()) {
            String magazine = sc.nextLine();
            String[] magdata = magazine.split(" ");
            st = new SeparateChainingHashST(magdata.length);
            for (int i = 0; i < m; i++) {
                if (st.contains(magdata[i])) {
                    int val = st.get(magdata[i]);
                    st.put(magdata[i], ++val);
                } else {
                    st.put(magdata[i], 1);
                }
            }
            String note = sc.nextLine();
            String[] notedata = note.split(" ");
            System.out.println(check(st, n, notedata));
        }
    }
}