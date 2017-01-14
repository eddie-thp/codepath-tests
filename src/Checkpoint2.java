import java.util.ArrayList;

/**
 * <pre>
 * Print concentric rectangular pattern in a 2d matrix. 
 * Let us show you some examples to clarify what we mean.
 * 
 * Example 1:
 * 
 * Input: A = 4.
 * Output:
 * 
 * 4 4 4 4 4 4 4 
 * 4 3 3 3 3 3 4 
 * 4 3 2 2 2 3 4 
 * 4 3 2 1 2 3 4 
 * 4 3 2 2 2 3 4 
 * 4 3 3 3 3 3 4 
 * 4 4 4 4 4 4 4 
 * Example 2:
 * 
 * Input: A = 3.
 * Output:
 * 
 * 3 3 3 3 3 
 * 3 2 2 2 3 
 * 3 2 1 2 3 
 * 3 2 2 2 3 
 * 3 3 3 3 3 
 * The outermost rectangle is formed by A, then the next outermost is formed by A-1 and so on.
 * 
 * You will be given A as an argument to the function you need to implement, and you need to return a 2D array.
 * </pre>
 *
 */
public class Checkpoint2 {

	public static void main(String[] args) {
		Checkpoint2 c = new Checkpoint2();
		
		ArrayList<ArrayList<Integer>> lines = c.prettyPrint(4);
		
		for (ArrayList<Integer> line : lines) {
			for (Integer col : line) {
				System.out.print(col + " ");
			}
			System.out.println();
		}

	}

	public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
		ArrayList<ArrayList<Integer>> lines = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < (a * 2) - 1; i++) {
			ArrayList<Integer> cols = new ArrayList<Integer>();
			lines.add(cols);

			int lineVal = a - i;
			if (lineVal <= 0) {
				lineVal = (lineVal * -1) + 2;
			}

			for (int j = 0; j < (a * 2) - 1; j++) {
				int colVal = a - j;
				if (colVal <= 0) {
					colVal = (colVal * -1) + 2;
				}
				if (colVal > lineVal) {
					cols.add(colVal);
				} else {
					cols.add(lineVal);
				}
			}
		}
		return lines;
	}
}
