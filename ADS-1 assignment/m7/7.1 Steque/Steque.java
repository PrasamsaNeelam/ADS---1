/**
 * Class for node.
 */
class Node {
    /**
     * { variable to access data }.
     */
    String data;
    /**
     * { var to access the next node }.
     */
    Node next;
    /**
     * Constructs the object.
     */
    Node() {
    }
    /**
     * Constructs the object.
     *
     * @param      data  The data
     */
    Node(final String d) {
        this.data = d;
        next = null;
    }
}
/**
 * Class for steque.
 */
public class Steque {
    /**
     * { var for start node }.
     */
    Node start;
    /**
     * { var for temp node}.
     */
    Node temp;
    /**
     * { var for end node }.
     */
    Node end;
    /**
     * { var for size }.
     */
    int size;
    /**
     * Constructs the object.
     */
    Steque() {
        start = new Node();
        temp = new Node();
        end = new Node();
        size = 0;
    }
    /**
     * { pushes the node at the left of List }.
     *
     *All the operations in this method take constant time.
     *So, the time complexity equals O(1).
     *
     * @param      item  The item
     */
    void push(final String item) {
        Node obj = new Node(item);
        if (size == 0) {
            start = obj;
            end = start;
            size++;
            return;
        }
        obj.next = start;
        start = obj;
        size++;
    }
    /**
     * { add the node at the right of the List }.
     *
     * All the operations in this method take constant time.
     * So, the time complexity equals O(1).
     *
     * @param      item  The item
     */
    void enqueue(final String item) {
        Node obj = new Node(item);
        if (size == 0) {
            start = obj;
            end = start;
            size++;
            return;
        }
        end.next = obj;
        end = obj;
        size++;
    }
    /**
     * { pops the node from the left }.
     *
     * All the operations in this method take constant time.
     * So, the time complexity equals O(1).
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     Exception  { exception_description }
     */
    String pop() throws Exception {
        if (size == 0) {
            throw new Exception("Steque is empty.");
        }
        String data = start.data;
        start = start.next;
        size--;
        return data;
    }
    /**
     * Determines if empty.
     * 
     * All the operations in this method take constant time.
     * So, the time complexity equals O(1).
     *
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
    /**
     * { returns size }.
     * 
     * All the operations in this method take constant time.
     * So, the time complexity equals O(1).
     *
     * @return     { description_of_the_return_value }
     */
    int size() {
        return size;
    }
    /**
     * Returns a string representation of the object.
     * 
     * The while loop iterates N times.
     * For each iteration the time complexity of this method is 1.
     * So the final time complexity equals O(N).
     * 
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "Steque is empty.";
        }
        temp = start;
        String out = "";
        while (temp != null) {
            out += temp.data + ", ";
            temp = temp.next;
        }
        return out.substring(0, out.length() - 2);
    }
}
