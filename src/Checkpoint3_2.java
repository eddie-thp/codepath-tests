import java.util.ArrayList;

public class Checkpoint3_2 {

	/**
	 * <pre>
	 * Given an array of non negative integers A, and a range (B, C), 
	 * find the number of continuous subsequences in the array which have sum S in the range [B, C] or B <= S <= C
	 * 
	 * Continuous subsequence is defined as all the numbers A[i], A[i + 1], .... A[j]
	 * where 0 <= i <= j < size(A)
	 * 
	 * Example :
	 * 
	 * A : [10, 5, 1, 0, 2]
	 * (B, C) : (6, 8)
	 * ans = 3 
	 * as [5, 1], [5, 1, 0], [5, 1, 0, 2] are the only 3 continuous subsequence with their sum in the range [6, 8]
	 * 
	 * NOTE : The answer is guranteed to fit in a 32 bit signed integer. 
	 * </pre>
	 */
	public static void main(String[] args) {
		Checkpoint3_2 c = new Checkpoint3_2();
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(10);
		a.add(5);
		a.add(1);
		a.add(0);
		a.add(2);
		
		System.out.println("Result: " + c.numRange(a, 6, 8));

	}

	public int numRange(ArrayList<Integer> a, int b, int c) {
		int count = 0;
		for (int i = 0; i < a.size(); i++) {
			int sum = 0;

			for (int j = i; j < a.size(); j++) {
				sum += a.get(j);

				if (b <= sum && sum <= c) {
					count++;
				} else if (sum < b) {
					continue;
				} else {
					break;
				}
			}

		}
		return count;
	}
}
