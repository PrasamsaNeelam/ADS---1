/**
 * @author : Prasamsa Neelam.
 * Date : 08th Octobr,2018.
 */
import java.util.Scanner;
/**
 * Class for minheap.
 *
 * @param      <E>   Generic
 */
class Minheap<E extends Comparable<E>> {
    private E[] array;
    /**
     * Constructs the object.
     *
     * @param      arr   The arr
     */
    Minheap(final E[] arr) {
        this.array = arr;
    }
    /**
     * Determines if minheap.
     *
     * @param      arr   The arr
     *
     * @return     True if minheap, False otherwise.
     */
    public boolean isMinheap(final E[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (!less(arr[i], arr[i + 1])) {
                return false;
            }
        }
        return true;
    }
    /**
     * Checks the element to be less.
     *
     * @param      i     i index
     * @param      j     j index
     *
     * @return     boolean value
     */
    public boolean less(final E i, final E j) {
        return i.compareTo(j) <= 0;
    }
}
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
     * main function to drive the program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String data = s.nextLine();
        switch (data) {
        case "String":
            int testcases = Integer.parseInt(s.nextLine());
            for (int i = 0; i < testcases; i++) {
                String[] input = s.nextLine().split(",");
                Minheap<String> m = new Minheap<String>(input);
                System.out.println(m.isMinheap(input));
            }
            break;
        case "Integer":
            int tests = Integer.parseInt(s.nextLine());
            for (int i = 0; i < tests; i++) {
                String str = s.nextLine();
                String[] tokens = str.split(",");
                Integer[] intarr = new Integer[tokens.length];
                for (int j = 0; j < tokens.length; j++) {
                    intarr[j] = Integer.parseInt(tokens[j]);
                }
                Minheap<Integer> m = new Minheap<Integer>(intarr);
                System.out.println(m.isMinheap(intarr));
            }
            break;
        case "Float":
            int n = Integer.parseInt(s.nextLine());
            for (int i = 0; i < n; i++) {
                String string = s.nextLine();
                if (string.equals("")) {
                    System.out.println("false");
                } else {
                    String[] tokens = string.split(",");
                    Float[]  floarr = new Float[tokens.length];
                    for (int j = 0; j < tokens.length; j++) {
                        floarr[j] = Float.parseFloat(tokens[j]);
                    }
                    Minheap<Float> m = new Minheap<Float>(floarr);
                    System.out.println(m.isMinheap(floarr));
                }
            }
            break;
        case "Double":
            int cases = Integer.parseInt(s.nextLine());
            for (int i = 0; i < cases; i++) {
                String st = s.nextLine();
                String[] tokens = st.split(",");
                Double[]  douarr = new Double[tokens.length];
                for (int j = 0; j < tokens.length; j++) {
                    douarr[j] = Double.parseDouble(tokens[j]);
                }
                Minheap<Double> m = new Minheap<Double>(douarr);
                //int len = douarr.length;
                System.out.println(m.isMinheap(douarr));
            }
            break;
        default:
            break;
        }
    }
}
