import java.util.Arrays;
import java.util.Scanner;
class Sort {
	int[] a;
	int[] aux;
	public void sort(int[] a) {
		this.a = a;
		aux = new int[a.length];
		sort(a, 0, a.length - 1);
	}
	public void sort(int[] a, int low, int high) {
		if (high <= low) return;
		int mid = low + (high - low) / 2;
		sort(a, low, mid);
		sort(a, mid + 1, high);
	}
	public void merge(int[] a, int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		for (int k = low; k <= high; k++) {
			aux[k] = a[k];
		}
		for (int k = low; k <= high; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > high) {
				a[k] = aux[i++];
			} else if (less(aux[i], aux[j])) {
				a[k] = aux[i++];
			} else {
				a[k] = aux[j++];
			}
		}
	}
	public boolean less(int i, int j) {
		if(i < j) {
			return true;
		}
		return false;
	}
	public String toString() {
		System.out.println(Arrays.toString(a));
		return "";
	}
}
public class Solution {
	private Solution() {
    }
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	Sort s = new Sort();
    	while (scan.hasNext()) {
    		String[] tokens = scan.nextLine().split(",");
    		int[] data = new int[tokens.length];
    		for (int i = 0; i < tokens.length; i++) {
    			data[i] = Integer.parseInt(tokens[i]);
            }
            s.sort(data);
            System.out.println(s);
    	}
    }
}