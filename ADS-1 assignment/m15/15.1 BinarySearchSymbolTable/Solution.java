/**
 * @author : Prasamsa.
 * Date : 10th October,2018.
 */
import java.util.Scanner;
/**
 * Class for binary search st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchST<Key extends Comparable<Key>, Value> {
    /**
     * array for keys.
     */
    private Key[] keys;
    /**
     * array for values.
     */
    private Value[] values;
    /**
     * variable for size.
     */
    private int size;
    /**
     * Constructs the object.
     */
    BinarySearchST() { }
    /**
     * Constructs the object.
     *
     * @param      capacity  The capacity
     */
    BinarySearchST(final int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
        size = 0;
    }
    /**
     * resize function.
     *
     * @param      capacity  The capacity
     */
    private void resize(final int capacity) {
        Key[] tempkey = (Key[]) new Comparable[capacity];
        Value[] tempval = (Value[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            tempkey[i] = keys[i];
            tempval[i] = values[i];
        }
        keys = tempkey;
        values = tempval;
    }
    /**
     * put function.
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
        if (size == keys.length) {
            resize(2 * keys.length);
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
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
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
     * @return     { Key }
     */
    Key max() {
        return keys[size - 1];
    }
    /**
     * returns min key.
     *
     * @return     { key }
     */
    Key min() {
        return keys[0];
    }
    /**
     *  return largest key less than or equal to key.
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
     */
    void deleteMin() {
        delete(keys[0]);
    }
    /**
     * returns size.
     *
     * @return     { int }
     */
    int size() {
        return size;
    }
    /**
     * deletes the key.
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
     */
    void keys() {
        for (int i = 0; i < size; i++) {
            System.out.println(keys[i] + " " + values[i]);
        }
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String[] str = s.nextLine().split(" ");
        BinarySearchST bs = new BinarySearchST<String, Integer>(str.length);
        for (int i = 0; i < str.length; i++) {
            bs.put(str[i], i);
        }
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(" ");
            switch (tokens[0]) {
            case "contains":
                System.out.println(bs.contains(tokens[1]));
                break;
            case "get":
                System.out.println(bs.get(tokens[1]));
                break;
            case "max":
                System.out.println(bs.max());
                break;
            case "min":
                System.out.println(bs.min());
                break;
            case "floor":
                System.out.println(bs.floor(tokens[1]));
                break;
            case "rank":
                System.out.println(bs.rank(tokens[1]));
                break;
            case "deleteMin":
                bs.deleteMin();
                break;
            case "keys":
                bs.keys();
                break;
            default:
                break;
            }
        }
    }
}
