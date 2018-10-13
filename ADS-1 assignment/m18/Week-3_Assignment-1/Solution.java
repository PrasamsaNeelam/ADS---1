import java.util.Scanner;

/**
 * Class for binary search ST.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchST<Key extends Comparable<Key>,
    Value extends Comparable<Value>> {
    /**
     * Class for stock.
     */
    class Stock {
        /**
         * stock name variable.
         */
        private String stockName;
        /**
         * frequency variable.
         */
        private float freq;
        /**
         * Constructs the object.
         */
        Stock() {

        }
        /**
         * Constructs the object.
         *
         * @param      name    The stock name
         * @param      freque  The frequency
         */
        Stock(final String name, final float freque) {
            this.stockName = name;
            this.freq = freque;
        }
        /**
         * compares frequencies.
         *
         * @param      other  The other
         *
         * @return     { boolean }
         */
        public boolean compareTo(final Stock other) {
            return this.freq > other.freq;
        }
    }
    /**
     * array for keys.
     */
    private Key[] keys;
    /**
     * array for values.
     */
    private Value[] values;
    /**
     * size variable.
     */
    private int size;
    /**
     * Constructs the object.
     */
    BinarySearchST() { }
    /**
     * put function.
     *
     * The time complexity is O(log N).
     *
     * @param      key    The key
     * @param      value  The value
     */
    void put(final Key key, final Value value) {
        if (key == null) {
            throw new IllegalArgumentException(
                "first argument to put() is null");
        }
        if (value == null) {
            delete(key);
            return;
        }
        int r = rank(key);
        if (r < size && keys[r].compareTo(key) == 0) {
            values[r] = value;
            return;
        }
        for (int i = size; i > r; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        keys[r] = key;
        values[r] = value;
        size++;
    }
    /**
     * Rank Function.
     *
     * Time complexity is O(log N).
     *
     * @param      key   The key
     *
     * @return     { Integer value }
     */
    int rank(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to rank() is null");
        }
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                high = mid - 1;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
    /**
     * checks whether the key is present.
     *
     * Time complexity is 1.
     *
     * @param      key   The key
     *
     * @return     { boolean }
     */
    boolean contains(final Key key) {
        return get(key) != null;
    }
    /**
     * Gets the key.
     *
     * Time complexity is O(log N).
     *
     * @param      key   The key
     *
     * @return     { value }
     */
    Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null");
        }
        int r = rank(key);
        if (r < size && keys[r].compareTo(key) == 0) {
            return values[r];
        }
        return null;
    }
    /**
     * returns max key.
     *
     * Time complexity is O(1).
     *
     * @return     { Key }
     */
    Key max() {
        return keys[size - 1];
    }
    /**
     * returns min key.
     *
     * Time complexity is O(1).
     *
     * @return     { key }
     */
    Key min() {
        return keys[0];
    }
    /**
     * return largest key less than or equal to key.
     *
     * Time complexity is O(log(N)).
     *
     * @param      key   The key
     *
     * @return     { key }
     */
    Key floor(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to floor() is null");
        }
        int r = rank(key);
        if (r < size && keys[r].compareTo(key) == 0) {
            return key;
        }
        if (r == 0) {
            return null;
        }
        return keys[r - 1];
    }
    /**
     * Delete minimum.
     *
     * Time complexity is O(1).
     */
    void deleteMin() {
        delete(keys[0]);
    }
    /**
     * returns size.
     *
     *Time complexity is O(1).
     *
     * @return     { int }
     */
    int size() {
        return size;
    }
    /**
     * deletes the key.
     *
     * Time complexity is O(log(N)).
     *
     * @param      key   The key
     */
    void delete(final Key key) {
        int r = rank(key);
        if (r == size || keys[r].compareTo(key) != 0) {
            return;
        }
        for (int i = r; i < size - 1; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        size--;
        keys[size] = null;
        values[size] = null;
    }
    /**
     * displays all keys.
     *
     * Time complexity is O(N).
     */
    void keys() {
        for (int i = 0; i < size; i++) {
            System.out.println(keys[i] + " " + values[i]);
        }
    }
}
/**
 * class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        BinarySearchST<String, Float> bst = new BinarySearchST<String, Float>();
        Stock stock = new Stock();
        while (s.hasNext()) {
            String[] tokens = s.next().split(",");
            bst.put(tokens[0], Float.parseFloat(tokens[1]));
            int input = s.nextInt();
            while (s.hasNext()) {
                String[] data = s.next().split(",");
                switch (data[0]) {
                case "get":
                    System.out.println(bst.get(data[2]));
                    break;
                default:
                    break;
                }
            }
        }
    }
}
