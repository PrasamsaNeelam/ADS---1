import java.util.Scanner;
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

