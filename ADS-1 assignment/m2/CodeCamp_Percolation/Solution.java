
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * { main function to drive the program }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        Percolation perc = new Percolation(size);
        while (s.hasNext()) {
            perc.open(s.nextInt(), s.nextInt());
        }
        System.out.println(perc.percolates());
    }
}

