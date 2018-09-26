import java.util.Scanner;
import java.util. Arrays;
public class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size = s.nextInt();
		int count = 0;
		int[] arr = new int[size];
		System.out.println("Enter the elements");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1]) {
				count++;
			}
		}
		System.out.println("count is " + count);
}
}