/**
 * @author : Prasamsa.
 * date : 1st October,2018.
 */
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
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int num = Integer.parseInt(s.nextLine());
        Steque sq = new Steque();
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(" ");
            switch (tokens[0]) {
            case "push":
                sq.push(tokens[1]);
                System.out.println(sq);
                break;
            case "pop":
                try {
                    sq.pop();
                    System.out.println(sq);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "enqueue":
                sq.enqueue(tokens[1]);
                System.out.println(sq);
                break;
            default:
                sq = new Steque();
                System.out.println();
                break;
            }
        }
    }
}

