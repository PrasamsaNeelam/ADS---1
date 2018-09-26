import java.util.Scanner;
import java.util. Arrays;
public class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size = s.nextInt();
		int count = 1;
		int sum = 0;
		int[] arr = new int[size];
		System.out.println("Enter the elements");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < size - 1; i++) {
			if (i == size - 2 && arr[i] == arr[i + 1]) {
				count++;
				sum += count * (count - 1) / 2;
				count = 1;
				break;
			}
			if (arr[i] == arr[i + 1]) {
				count++;
				continue;
			}
			if (count > 1 && arr[i] != arr[i + 1]) {
				sum += count * (count - 1) / 2;
				count = 1;
			}
		}
		System.out.println("count is " + sum);
	}
}