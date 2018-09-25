// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem
import java.util.Scanner;
/**
 * Class for percolation.
 */
final class Percolation {
    int[][] grid;
    int countOpenSites;
    WeightedQuickUnionUF wqu;
    int n;
    /**
     * Constructs the object.
     *
     * @param      n     { The n }
     */
    Percolation(int n) {
        this.n = n;
        grid = new int[n][n];
        countOpenSites = 0;
        wqu = new WeightedQuickUnionUF((n * n) + 2);
    }
    /**
     * { function to make the grid open }.
     *
     * @param      row   The row
     * @param      col   The col
     */
    public void open(int row, int col) {
        row = row - 1;
        col = col - 1;
        grid[row][col] = 1;
        countOpenSites++;
        if (row == 0) {
            wqu.union(0, component(row, col));
        }
        if (row == n - 1) {
            wqu.union(component(row, col), ((n * n) + 1));
        }
        if (row > 0 && grid[row - 1][col] == 1) {
            wqu.union(component(row, col), component(row - 1, col));
        }
        if (row < n - 1 && grid[row + 1][col] == 1) {
            wqu.union(component(row, col), component(row + 1, col));
        }
        if (col > 0 && grid[row][col - 1] == 1) {
            wqu.union(component(row, col), component(row, col - 1));
        }
        if (col < n - 1 && grid[row][col + 1] == 1) {
            wqu.union(component(row, col), component(row, col + 1));
        }
    }
    /**
     * { function to retrieve the element value }.
     *
     * @param      a     { row }
     * @param      b     { col }
     *
     * @return     { returns int value }
     */
    public int component(final int a, final int b) {
        return ((a * n) + b);
    }
    /**
     * Determines if open.
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return     True if open, False otherwise.
     */
    public boolean isOpen(final int row, final int col) {
        if (grid[row - 1][col - 1] == 1) {
            return true;
        }
        return false;
    }
    /**
     * Determines if full.
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return     True if full, False otherwise.
     */
    public boolean isFull(final int row, final int col) {
        if (grid[row - 1][col - 1] == 0) {
            return true;
        }
        return false;
    }
    /**
     * { function to determine the count of open blocks }.
     *
     * @return     { returns int value }
     */
    public int numberOfOpenSites() {
        return countOpenSites;
    }
    /**
     * { function to check whether there is a connection between virtual nodes }.
     *
     * @return     { returns true or false }
     */
    public boolean percolates() {
        return wqu.connected(0, ((n * n) + 1));
    }
}
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

