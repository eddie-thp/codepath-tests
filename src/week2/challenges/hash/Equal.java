package week2.challenges.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Equal {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(3);
		a.add(4);
		a.add(7);
		a.add(1);
		a.add(2);
		a.add(9);
		a.add(8);
		
		//System.out.println(new Equal().equal(a));
		
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(1);
		b.add(1);
		b.add(1);
		b.add(1);
		b.add(1);
		b.add(1);
		b.add(1);
		
		System.out.println(new Equal().equal(b));
	}

	public ArrayList<Integer> equal(ArrayList<Integer> a) {
		int aSize = a.size();

		Map<Integer, ArrayList<Integer>> sumIndexes = new HashMap<Integer, ArrayList<Integer>>();

		for (int i = 0; i < aSize - 1; i++) {
			int n1 = a.get(i);

			for (int j = i + 1; j < aSize; j++) {

				int n2 = a.get(j);
				int sum = n1 + n2;

				if (!sumIndexes.containsKey(sum)) {
					sumIndexes.put(sum, new ArrayList<Integer>());
				}

				ArrayList<Integer> vals = sumIndexes.get(sum);

				if (i < j) {
					vals.add(i);
					vals.add(j);
				} else {
					vals.add(j);
					vals.add(i);
				}

			}
		}

		ArrayList<Integer> result = new ArrayList<Integer>();

		for (ArrayList<Integer> possibleResult : sumIndexes.values()) {
			if (possibleResult.size() >= 4) {
				int a1 = possibleResult.get(0);
				int b1 = possibleResult.get(1);
				int c1 = possibleResult.get(2);
				int d1 = possibleResult.get(3);

				if (result.size() == 0) {
					result.add(a1);
					result.add(b1);
					result.add(c1);
					result.add(d1);
				} else {
					// Compare lexicographicaly
					/*
					 * S1 is lexicographically smaller than S2 iff A1 < A2 OR A1
					 * = A2 AND B1 < B2 OR A1 = A2 AND B1 = B2 AND C1 < C2 OR A1
					 * = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
					 */
					int a2 = result.get(0);
					int b2 = result.get(1);
					int c2 = result.get(2);
					int d2 = result.get(3);

					if (a1 < a2 || (a1 == a2 && b1 < b2) || (a1 == a2 && b1 == b2 && c1 < c2)
							|| (a1 == a2 && b1 == b2 && c1 == c2 && d1 < d2)) {
						result.set(0, a1);
						result.set(1, b1);
						result.set(2, c1);
						result.set(3, d1);
					}
				}
			}
		}

		return result;
	}
}
