import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * { main function to drive the program }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String data = s.nextLine();
		while (s.hasNext()) {
			String[] line = s.nextLine().split(" ");
			int people = Integer.parseInt(line[0]);
			int gap = Integer.parseInt(line[1]);
			Deque<Integer> queue = new Deque<>();
			createCircle(queue, people);
			queue.josephus(people, gap);
		}
	}
	/**
	 * Creates a circle.
	 *
	 * @param      queue   The queue
	 * @param      people  The people
	 */
	public static void createCircle(Deque<Integer> queue, int people) {
		for (int i = 0; i < people; i++) {
			queue.push(i);
		}
	}
}
