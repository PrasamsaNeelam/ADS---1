import java.util.Scanner;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Solution {

    private Solution () {

    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        MinPQ<Float> minpq = new MinPQ<Float>(n);
        MaxPQ<Float> maxpq = new MaxPQ<Float>(n);

        Float median = 0.0f;
        for (int i = 0; i < n; i++) {
            Float val = s.nextFloat();
            if (val > median) {
                minpq.insert(val);
            } else {
                maxpq.insert(val);
            }

            if (minpq.size() - maxpq.size() > 1) {
                maxpq.insert(minpq.delMin());

            }
            if (maxpq.size() - minpq.size() > 1) {
                minpq.insert(maxpq.delMax());
                
            }

            if (minpq.size() == maxpq.size()) {
                median = (minpq.min() + maxpq.max()) / 2;
                System.out.println(median);
            }

            if (maxpq.size() > minpq.size()) {
                median = maxpq.max();
                System.out.println(median);
            }

            if (minpq.size() > maxpq.size()) {
                median = minpq.min();
                System.out.println(median);
            }

        }

    }
}
