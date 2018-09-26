import java.util.Scanner;
import java.util.Arrays;
public class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size1 = s.nextInt();
		int size2 = s.nextInt();
		int[] arr1 = new int[size1];
		int[] arr2 = new int[size2];
		String[] str1 = s.nextLine().split(",");
		String[] str2 = s.nextLine().split(",");
		System.out.println(Arrays.toString(str1));
		for (int i = 0; i < size1; i++) {
			arr1[i] = Integer.parseInt(str1[i]);
		}
		for (int i = 0; i < size2; i++) {
			arr2[i] = Integer.parseInt(str2[i]);
		}
		// System.out.println(str1);
		// System.out.println(str2);
	}
}
	

