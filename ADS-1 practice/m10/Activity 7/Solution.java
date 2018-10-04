import java.util.Scanner;
class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int factorial = fact(n);
		System.out.println(fact(n));
	}
	public static int fact(int n) {
		if (n == 1 || n == 0) return 1;
		return n * fact(n - 1);
	}
}