import java.util.Scanner;
/**
 * Class for insertion sort.
 */
class InsertionSort {
    /**
     * function for checking less or not.
     *
     * time complexity for this method is O(1).
     *
     * @param      u     { parameter_description }
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    boolean less(final Comparable u, final Comparable v) {
        return u.compareTo(v) < 0;
    }
    /**
     * Swaps the elements.
     *
     * time complexity for this method is O(1).
     *
     * @param      a     { parameter_description }
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    void exch(final Comparable[] a, final int i, final int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    /**
     * Sorts the array.
     * time complexity for this method is O(n).
     * @param      a     { parameter_description }
     * @param      low   The low
     * @param      high  The high
     */
    void sort(final Comparable[] a, final int low, final int high) {
        System.out.println("insertionSort called");
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
}

/**
 * Class for quick.
 */
class Quick {
    /**
     * function which describes the less element.
     * time complexity for this method is O(1).
     *
     * @param      u     { parameter_description }
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    boolean less(final Comparable u, final Comparable v) {
        return u.compareTo(v) < 0;
    }
    /**
     * swaps the element.
     *
     * time complexity for this method is O(1).
     *
     * @param      a     { parameter_description }
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    void exch(final Comparable[] a, final int i, final int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * sorts the array.
     *
     * time complexity for this method is O(n).
     *
     * @param      a       { parameter_description }
     * @param      low     The low
     * @param      high    The high
     * @param      cutoff  The cutoff
     */
    void sort(final Comparable[] a,
              final int low,
              final int high,
              final int cutoff) {
        // if (low < high) {
        if (high - low < cutoff) {
            InsertionSort is = new InsertionSort();
            is.sort(a, low, high);
            // System.out.println("insertionSort called");
            return;
        }
        int pivot = partition(a, low, high);
        // System.out.println(as.toString(a));
        sort(a, low, pivot - 1, cutoff);
        sort(a, pivot + 1, high, cutoff);
    }
    /**
     * partition function.
     *
     * time complexity for this method is O(nlogn).
     *
     * @param      a     { parameter_description }
     * @param      low   The low
     * @param      high  The high
     *
     * @return     { description_of_the_return_value }
     */
    int partition(final Comparable[] a, final int low, final int high) {
        int i = low;
        int j = high;
        Comparable pivot = a[low];
        while (true) {
            while (j >= low && a[j].compareTo(pivot) > 0) {
                j--;
            }
            while (i <= high && a[i].compareTo(pivot) <= 0) {
                i++;
            }
            if (j < i) {
                i--;
                break;
            }
            exch(a, i, j);
            i++;
            j--;
        }
        a[low] = a[i];
        a[i] = pivot;
        System.out.println(toString(a));
        return i;
    }
    /**
     * Returns a string representation of the object.
     * time complexity for this method is O(n).
     * @param      a     { parameter_description }
     *
     * @return     String representation of the object.
     */
    public String toString(final Comparable[] a) {
        String str = "[";
        int i;
        for (i = 0; i < a.length - 1; i++) {
            str += a[i] + ", ";
        }
        str += a[a.length - 1] + "]";
        return str;
    }
}

/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int testcases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testcases; i++) {
            Quick qs = new Quick();
            int cutoff = Integer.parseInt(scan.nextLine());
            String line = scan.nextLine();
            if (line.equals("")) {
                System.out.println("[]");
            } else {
                Comparable[] a = line.split(" ");
                qs.sort(a, 0, a.length - 1, cutoff);
                System.out.println(qs.toString(a));
            }
        }
    }
}
