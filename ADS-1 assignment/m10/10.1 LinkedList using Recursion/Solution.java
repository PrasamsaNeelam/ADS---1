/**
 * @author : Prasamsa.
 * date : 4th October,2018.
 */
import java.util.Scanner;

/**
 * List of linkeds.
 */
class LinkedList {
    /**
    * Class for node.
    */
    class Node {
        /**
         * { var for string data }.
         */
        private String data;
        /**
         * { var for node next }.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      data  The data
         */
        Node(final String data) {
            this.data = data;
        }
    }
    /**
     * { var for start node }.
     */
    private Node start;
    /**
     * { var for size }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    LinkedList() {
        start = null;
        size = 0;
    }
    // time complexity for this method is n
    //takes O(n) time complexity
    void insertAt(final int index, final String element) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception();
        }
        Node obj = new Node(element);
        // Node previous = null;
        // Node temp = start;
        // int count = 0;
        // if (index == 0) {
        //  obj.next = start;
        //  start = obj;
        //  size++;
        //  return;
        // }
        start = insertAt(index, start, obj, 0);
        // while (temp != null) {
        //  if (count == index) {
        //      previous.next = obj;
        //      obj.next = temp;
        //      size++;
        //      return;
        //  }
        //  previous = temp;
        //  temp = temp.next;
        //  count++;
        // }
    }
    // time complexity for this method is n
    //takes O(n) time complexity
    Node insertAt(final int index, final Node first, final Node obj,
                  final int count) throws Exception {
        if (index == count) {
            obj.next = first;
            size++;
            return obj;
        }
        first.next = insertAt(index, first.next, obj, count + 1);
        return first;
    }
    // time complexity for this method is n
    //takes O(n) time complexity
    void reverse() {
        reverse(null, start);
    }
    // time complexity for this method is n
    //takes O(n) time complexity
    void reverse(final Node previous, final Node current) {
        if (current != null) {
            reverse(current, current.next);
            current.next = previous;
        } else {
            start = previous;
        }
    }
    void print() {
        String str = "";
        Node temp = start;
        while (temp != null) {
            str += temp.data + ", ";
            temp = temp.next;
        }
        System.out.println(str.substring(0, str.length() - 2));
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
     * { main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        while (s.hasNextLine()) {
            String[] input = s.nextLine().split(" ");
            switch (input[0]) {
            case "insertAt" :
                try {
                    ll.insertAt(Integer.parseInt(input[1]), input[2]);
                    ll.print();
                } catch (Exception e) {
                    System.out.println(
                        "Can't insert at this position.");
                }
                break;
            case "reverse" :
                try {
                    ll.reverse();
                    ll.print();
                } catch (Exception e) {
                    System.out.println("No elements to reverse.");
                }
                break;
            default :
                break;
            }
        }
    }

}
