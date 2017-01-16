import java.util.ArrayList;
import java.util.HashSet;

/**
 * <pre>
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 
 * Example :
 * [1,1,2] have the following unique permutations:
 * 
 * [1,1,2]
 * [1,2,1]
 * [2,1,1]
 * 
 * 	NOTE : No 2 entries in the permutation sequence should be the same.
 *  
 * 	Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
 * 	Example : next_permutations in C++ / itertools.permutations in python.
 * 	If you do, we will disqualify your submission retroactively and give you penalty points.
 * 
 * </pre>
 */
public class Checkpoint5_1 {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(1);
		a.add(2);

		Checkpoint5_1 c = new Checkpoint5_1();
		ArrayList<ArrayList<Integer>> ps = c.permute(a);

		for (ArrayList<Integer> p : ps) {
			System.out.println(p);
		}
	}

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
		return new ArrayList<ArrayList<Integer>>(permute(a, new HashSet<ArrayList<Integer>>()));
	}

	public HashSet<ArrayList<Integer>> permute(ArrayList<Integer> a, HashSet<ArrayList<Integer>> ps) {
		if (a.isEmpty()) {
			return ps;
		}

		HashSet<ArrayList<Integer>> rps = new HashSet<ArrayList<Integer>>();

		for (int i = 0; i < a.size(); i++) {
			int n = a.get(i);

			HashSet<ArrayList<Integer>> nps = new HashSet<ArrayList<Integer>>();

			if (ps.size() == 0) {
				ArrayList<Integer> np = new ArrayList<Integer>();
				np.add(n);
				nps.add(np);
			} else {
				for (ArrayList<Integer> p : ps) {
					ArrayList<Integer> np = new ArrayList<Integer>(p);
					np.add(n);
					nps.add(np);
				}
			}

			ArrayList<Integer> na = new ArrayList<Integer>(a);
			na.remove(i);

			rps.addAll(permute(na, nps));
		}

		return rps;
	}
}
