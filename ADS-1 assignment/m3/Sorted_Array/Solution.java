import java.util.Scanner;
import java.util.Arrays;
public class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size1 = Integer.parseInt(s.nextLine());
		int size2 = Integer.parseInt(s.nextLine());
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
		int i = 0;
		int j = 0;
		int k = 0;
		int[] arr3 = new int[size1 + size2];
		while (k < size1 + size2) {
			if (i < size1 && j < size2) {
				if (arr1[i] < arr2[j]) {
					arr3[k] = arr1[i];
					i++;
					k++;
				} else if (arr1[i] > arr2[j]) {
					arr3[k] = arr2[j];
					j++;
					k++;
				} else {
					arr3[k] = arr1[i];
					i++;
					k++;
					arr3[k] = arr2[j];
					j++;
					k++;
				}
			}
			if (i < size1) {
				while (i < size1) {
					arr3[k] = arr1[i];
					i++;
					k++; 
				}
			}
			if (j < size2) {
				while (j < size2) {
					arr3[k] = arr2[j];
					j++;
					k++;
				}
			}
		}
		for (int x = 0; x < arr3.length - 1; x++) {
			System.out.println(arr3[x] + ",");
		}
		System.out.println(arr3[arr3.length - 1]);
	}
}
	

