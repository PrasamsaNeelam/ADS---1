import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		System.out.println(Star(str));
	}
	public static String Star(String str) {
		if (str.length() <= 1) {
			return str;
		}
		if (str.charAt(0) == (str.charAt(1))) {
			return str.charAt(0) + "*" + Star(str.substring(1));
		}
		return str.charAt(0) + Star(str.substring(1));
	}
}