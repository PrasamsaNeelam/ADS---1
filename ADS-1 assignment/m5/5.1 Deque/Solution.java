/**
 * @author : Prasamsa
 * date : 30th September,2018.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Zero Parameter Constructor.
    }
    /**
     * { main function to drive the program }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Deque<Integer> queue = new Deque<>();
        Scanner s = new Scanner(System.in);
        int num = Integer.parseInt(s.nextLine());
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(" ");
            switch (tokens[0]) {
            case "pushLeft":
                queue.pushLeft(Integer.parseInt(tokens[1]));
                break;
            case "pushRight":
                queue.pushRight(Integer.parseInt(tokens[1]));
                break;
            case "size":
                System.out.println(queue.getSize());
                break;
            case "popLeft":
                queue.popLeft();
                break;
            case "popRight":
                queue.popRight();
                break;
            default:
                break;
            }
        }
    }
}