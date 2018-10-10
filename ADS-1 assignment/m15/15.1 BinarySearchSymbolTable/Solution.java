import java.util.Scanner;
import java.util.NoSuchElementException;

class BinarySearchST<Key extends Comparable<Key>, Value> {
	Key[] keys;
	Value[] values;
	int size;
	BinarySearchST() {

	}
	BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		values = (Value[]) new Object[capacity];
		size = 0;
	}

	private void resize(int capacity) {
        Key[] tempkey = (Key[]) new Comparable[capacity];
        Value[] tempval = (Value[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            tempkey[i] = keys[i];
            tempval[i] = values[i];
        }
        keys = tempkey;
        values = tempval;
    }

	void put(Key key, Value value) {
		if (key == null) {
			throw new IllegalArgumentException("first argument to put() is null");
		}
		if (value == null) {
			delete(key);
			return;
		}
		int r = rank(key);
		if (r < size && keys[r].compareTo(key) == 0) {
			values[r] = value;
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

	int rank(Key key) {
		if (key == null) {
			throw new IllegalArgumentException("argument to rank() is null");	
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

	boolean contains(Key key) {
		return get(key) != null;
	}

	Value get(Key key) {
		if (key == null) {
            throw new IllegalArgumentException("Key is null");
        }
        int r = rank(key);
        if (r < size && keys[r].compareTo(key) == 0) {
        	return values[r];
        }
        return null;
    }

    Key max() {
    	return keys[size - 1];
    }

    Key min() {
    	return keys[0];
    }

    Key floor(Key key) {
    	int r = rank(key);
    	if (keys[r].compareTo(key) == 0) {
    		return key;
    	} else {
    		return keys[r - 1];
    	}
    }

    void deleteMin() {
    	delete(keys[0]);
    }

	int size() {
		return size;
	}

	void delete(Key key) {
		int r = rank(key);
		if (r == size || keys[r].compareTo(key) != 0) {
			return;
		}
		for (int i = r; i < size - 1; i++) {
			keys[i] = keys[i+ 1];
			values[i] = values[i+1];
		}
		size--;
		keys[size] = null;
		values[size] = null;
	}

	void keys() {
		for (int i = 0; i < size; i++) {
			System.out.println(keys[i] +" "+ values[i]);
		}
	}
}
public class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
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
