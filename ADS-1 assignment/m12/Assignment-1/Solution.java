/**
 * imports Scanner and comparator class.
 * @author: Prasamsa
 * Date: 06-10-2018
 */
import java.util.Scanner;
import java.util.Comparator;
/**
 * Class for student.
 */
class Student {
	private String studentName;
	private String dob;
	private Double sub1Marks;
	private Double sub2Marks;
	private Double sub3Marks;
	private Double totalMarks;
	private String reservation;
	/**
	 * Constructs the object.
	 *
	 * @param      name    The name
	 * @param      dob1    The dob 1
	 * @param      sub1    The sub 1
	 * @param      sub2    The sub 2
	 * @param      sub3    The sub 3
	 * @param      marks   The marks
	 * @param      reserv  The reserv
	 */
	Student(String name, String dob1, Double sub1, Double sub2, Double sub3, Double marks, String reserv) {
		this.studentName = name;
		this.dob = dob1;
		this.sub1Marks = sub1;
		this.sub2Marks = sub2;
		this.sub3Marks = sub3;
		this.totalMarks = marks;
		this.reservation = reserv;
	}
	/**
	 * Constructs the object.
	 *
	 * @param      name    The name
	 * @param      marks   The marks
	 * @param      reserv  The reserv
	 */
	Student(String name, Double marks, String reserv) {
		this.studentName = name;
		this.totalMarks = marks;
		this.reservation = reserv;
	}
	/**
	 * Gets the name.
	 *
	 * @return     The name.
	 */
	public String getName() {
		return this.studentName;
	}
	/**
	 * Gets the dob.
	 *
	 * @return     The dob.
	 */
	public String getDob() {
		return this.dob;
	}
	/**
	 * Gets the marks.
	 *
	 * @return     The marks.
	 */
	public Double getMarks() {
		return this.totalMarks;
	}
	/**
	 * Gets the reserv.
	 *
	 * @return     The reserv.
	 */
	public String getReserv() {
		return this.reservation;
	}
	// public int compareTo(Student std) {
 //    	if (!getMarks.equals())
 //    }
	public void addStudent(Student std) {

	}
}
/**
 * Class for insertion.
 */
class Insertion {
	/**
	 * Constructs the object.
	 */
    private Insertion() { 

    }
    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param      stdarr     The array
     * @param      lo    The lower
     * @param      hi    The higher
     */
    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
        assert isSorted(a, lo, hi);
    }
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo+1; i < hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    /**
     * checks whether the comparable is less.
     *
     * @param      v           The v
     * @param      w           The w
     * @param      totalMarks  The total marks
     *
     * @return     returns boolean.
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}

   /**
    * Class for solution.
    */
public class Solution {
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
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int vacancies = s.nextInt();
		int noOfUnreserved = s.nextInt();
		int noOfBC = s.nextInt();
		int noOfSC = s.nextInt();
		int noOfST = s.nextInt();
		int counter = 0;
		while (s.hasNext()) {
			String[] arr = s.nextLine().split(",");
			String[] dob = arr[1].split("-");
			Student std = new Student(arr[0], arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), Double.parseDouble(arr[4]), Double.parseDouble(arr[4]), arr[6]);
        	std.addStudent(std);
        }

		}
	}


