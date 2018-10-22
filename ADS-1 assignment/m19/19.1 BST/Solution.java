import java.util.Scanner;
class Book implements Comparable<Book> {
	String name;
	String author;
	float price;
	Book() {
		
	}
	Book(String name1, String author1, float price1) {
		this.name = name1;
		this.author = author1;
		this.price = price1;
	}

	public String getName() {
        return name;
    }

    public String getAuthor() {
    	return author;
    }

    public float getPrice() {
    	return price;
    }

	public int compareTo(Book other) {
		return this.name.compareTo(other.name);
	}
	public String toString() {
		return getName() + ", " + getAuthor() + ", " + getPrice();
	}
}
class Node {
	Book key;
	int value;
	Node left;
	Node right;
	int count;
	Node(Book key1, int value1, int count1) {
		this.key = key1;
		this.value = value1;
		this.count = count1;
	}
	public Book getKey() {
        return key;
    }
    public int getValue() {
        return value;
    }
    public Node getLeft() {
        return left;
    }
    public Node getRight() {
        return right;
    }
    public int getCount() {
        return count;
    }
    public void setLeft(final Node left1) {
        this.left = left1;
    }
    public void setRight(final Node right1) {
        this.right = right1;
    }
    public void setValue(final int val) {
        this.value = val;
    }
    public void setCount(final int cnt) {
        this.count = cnt;
    }
}
class Bst {
	private Node root;
	Bst() {

	}
	public boolean isEmpty() {
        return count() == 0;
    }
    public int count() {
        return count(root);
    }
    private int count(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.getCount();
        }
    }
    public boolean contains(final Book key) {
        return get(key) != 0;
    }
    /**
     * Method to insert the key.
     * Time complexity is O(1).
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Book key, final int value) {
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
    public Node put(final Node x, final Book key, final int value) {
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
    public int get(final Book key) {
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
        return 0;
    }
    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * 
     */
    public Book min() {

        return min(root).getKey();
    } 

    private Node min(Node x) { 
        if (x.getLeft() == null) return x; 
        else                return min(x.getLeft()); 
    }
    /**
     * Returns the largest key in the symbol table.
     *
     * @return the largest key in the symbol table
     * 
     */
    public Book max() {

        return max(root).getKey();
    } 

    private Node max(Node x) {
        if (x.getRight() == null) return x; 
        else                 return max(x.getRight()); 
    }
    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * 
     * 
     */
    public Book floor(Book key) {
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.getKey();
    } 

    private Node floor(Node x, Book key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.getKey());
        if (cmp == 0) return x;
        if (cmp <  0) return floor(x.getLeft(), key);
        Node t = floor(x.getRight(), key); 
        if (t != null) return t;
        else return x; 
    }
    /**
     * Returns the smallest key in the symbol table greater than or equal to {@code key}.
     *
     * @param  key the key
     * @return the smallest key in the symbol table greater than or equal to {@code key}
     * 
     * 
     */
    public Book ceiling(Book key) {
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.getKey();
    }

    private Node ceiling(Node x, Book key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.getKey());
        if (cmp == 0) return x;
        if (cmp < 0) { 
            Node t = ceiling(x.getLeft(), key); 
            if (t != null) return t;
            else return x; 
        } 
        return ceiling(x.getRight(), key); 
    }
    /**
     * Return the key in the symbol table whose rank is {@code k}.
     * This is the (k+1)st smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the key in the symbol table of rank {@code k}
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */
    public Book select(int k) {
        Node x = select(root, k);
        //System.out.println(x);
        return x.getKey();
    }

    // Return key of rank k. 
    private Node select(Node x, int k) {
        if (x == null) return null;
        //System.out.println(x.toString());
        int t = count(x.getLeft());
        //System.out.println(t);
        if (t > k) {
            return select(x.getLeft(),  k);
        } 
        if (t < k) {
            return select(x.getRight(), k - t - 1); 
        }
        if(t==k)
        	return x;
        return x;
    }
}
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Bst bst = new Bst();
		Book book = new Book();
		while (s.hasNext()) {
			String[] tokens = s.nextLine().split(",");
			switch(tokens[0]) {
				case "put":
				book = new Book(tokens[1], tokens[2], Float.parseFloat(tokens[3]));
				bst.put(book, Integer.parseInt(tokens[4]));
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