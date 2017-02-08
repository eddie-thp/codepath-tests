package week3.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://www.interviewbit.com/problems/allocate-books/
 * <pre>
 * N number of books are given. 
 * The ith book has Pi number of pages. 
 * You have to allocate books to M number of students so that maximum number of pages alloted to a student is minimum. A book will be allocated to exactly one student. Each student has to be allocated at least one book. Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
 * 
 * NOTE: Return -1 if a valid assignment is not possible
 * 
 * Input:
 *  List of Books M number of students 
 * 
 * Your function should return an integer corresponding to the minimum number.
 * 
 * Example:
 * 
 * P : [12, 34, 67, 90]
 * M : 2
 * 
 * Output : 113
 * 
 * There are 2 number of students. Books can be distributed in following fashion : 
 *   1) [12] and [34, 67, 90]
 *       Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
 *   2) [12, 34] and [67, 90]
 *       Max number of pages is allocated to student 2 with 67 + 90 = 157 pages 
 *   3) [12, 34, 67] and [90]
 *       Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
 * 
 * Of the 3 cases, Option 3 has the minimum pages = 113.
 * </pre> 
 */
public class AllocateBooks {

	public static void main(String[] args) {
		Integer b = 5;
		Integer[] aArr = {73, 58, 30, 72, 44, 78, 23, 9};
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(aArr));

		System.out.println(new AllocateBooks().books(a, b));
	}
	
	public boolean isPossible(ArrayList<Integer> a, int b, int possibleMin) {
		int aSize = a.size();
        int curSum = 0;
        int studentsRequired = 1;
        for (int i = 0; i < aSize; i++) {
        	int val = a.get(i);
            if (val > possibleMin) return false;
            if (curSum + val > possibleMin) {
                studentsRequired++;
                curSum = val; 
                if (studentsRequired > b) return false;
            } else {
                curSum += val;
            }
        }
        return true;
	}
	
	public int books(ArrayList<Integer> a, int b) {
		int aSize = a.size();
		
		int result = -1;
		if (aSize >= b) {
			
			int allBooksPages = 0;
			for (Integer bookPages : a) {
				allBooksPages += bookPages;
			}
			
			int start = 0;
			int end = allBooksPages;
			result = Integer.MAX_VALUE;
			while (start <= end) {
				int mid = (start + end) /2;
				if (isPossible(a, b, mid)) {
					result = Math.min(result, mid);
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		return result;
	}
}
