/**
 * @author : Prasamsa.
 * date : 2nd October,2018.
 */
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for team.
 */
class Team implements Comparable<Team> {
	/**
	 * { var for team name }.
	 */
	private String teamName;
	/**
	 * { var for win }.
	 */
	private int wins;
	/**
	 * { var for losses }.
	 */
	private int losses;
	/**
	 * { var for draws }.
	 */
	private int draws;
	/**
	 * Constructs the object.
	 *
	 * @param      name  The name
	 * @param      win   The window
	 * @param      loss  The loss
	 * @param      draw  The draw
	 */
	Team(final String name, final int win, final int loss, final int draw) {
		this.teamName = name;
		this.wins = win;
		this.losses = loss;
		this.draws = draw;
	}

	/**
	 * Gets the team name.
	 *
	 * @return     The team name.
	 */
	public String getTeamName() {
		return teamName;
	}
	/**
	 * { function for comparing }.
	 *
	 * @param      obj   The object
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int compareTo(final Team obj) {
		if (this.wins > obj.wins) {
			return 1;
		}
		if (this.wins < obj.wins) {
			return -1;
		}
		if (this.losses > obj.losses) {
			return -1;
		}
		if (this.losses < obj.losses) {
			return 1;
		}
		if (this.draws > obj.draws) {
			return 1;
		}
		if (this.draws < obj.draws) {
			return -1;
		}
		return 0;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		return this.teamName;
		//return this.wins + " " + this.losses + " " + this.draws;
	}
}

/**
 * Class for sort.
 */
class Sort {
	/**
	 * { var for team array}.
	 */
	private Team[] arr = new Team[10];
	/**
	 * count to keep track in array.
	 */
	int count;
	/**
	 * Constructs the object.
	 */
	Sort() {
		count = 0;
	}
	/**
	 * Adds a team.
	 * 
	 * Time complexity is N.
	 *
	 * @param      team  The teamgiven
	 */
	void addTeam(final Team team) {
		try {
			arr[count++] = team;
			return;
		} catch (Exception e) {
			resize();
		}
		arr[count++] = team;
	}
	/**
	 * Resizes the array and makes a copy of the array.
	 */
	void resize() {
		arr = Arrays.copyOf(arr, 2 * count);
	}

	/**
	 * Swaps the values and places the smaller one in the beginning.
	 * Time complexity is 1 only assigning of values.
	 *
	 * @param      team  The teams
	 * @param      i      { Index value. }
	 * @param      j      { Index value. }
	 */
	void exchange(final Team[] team, final int i, final int j) {
		Team t = team[j];
		team[j] = team[i];
		team[i] = t;
	}

	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		String str = "";
		for (int i = 0; i < count; i++) {
			str += arr[i].getTeamName() + ",";
		}
		return str.substring(0, str.length() - 1);
	}

	/**
	 * Selection sort.
	 *
	 * The time complexity of this technique is N^2.
	 * For each and every iteration the value is taken
	 * The object is compared to the adjecent one checking if the value is
	 * lesser or not if less the exchange is happening.
	 *
	 */
	void Selectionsort() {
		for (int i = 0; i < count - 1; i++) {
			int min = i;
			for (int j = i + 1; j < count; j++) {
				if (less(arr, j, min)) {
					min = j;
				}
			}
			exchange(arr, i, min);
		}
		//System.out.println(toString());
	}

	/**
	 * Less comparision.
	 *
	 * @param      arr   The arr
	 * @param      i     { Index value. }
	 * @param      j     { Index value. }
	 *
	 * @return     { Boolean value based on the comparision }
	 */
	boolean less(Team[] arr, int i , int j) {
		return arr[i].compareTo(arr[j]) > 0;
	}
}
/**
 * Class for solution.
 */
class Solution {
	/**
	 * Constructs the object.
	 */
	Solution() {

	}
	/**
	 * Creates a team.
	 *
	 * @param      array  The array
	 *
	 * @return     { description_of_the_return_value }
	 */
	public static Team createTeam(final String[] array) {
        String name = array[0];
        //System.out.println(name);
        int wins = Integer.parseInt(array[1]);
        int losses = Integer.parseInt(array[2]);
        int draws = Integer.parseInt(array[2 + 1]);
        return new Team(name, wins, losses, draws);
    }
    /**
     * { main function }.
     *
     * @param      args  The arguments
     */
	public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Sort s = new Sort();
        while (scan.hasNextLine()) {
            String[] input = scan.nextLine().split(",");
            s.addTeam(createTeam(input));
        }
        s.Selectionsort();
        System.out.println(s);
    }
}
