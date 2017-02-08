package week3.binarySearch;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/rotated-sorted-array-search/
 * 
 * <pre>
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).
 * 
 * You are given a target value to search. If found in the array, return its index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Input : [4 5 6 7 0 1 2] and target = 4
 * Output : 0
 * 
 * NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*
 * </pre>
 */
public class RotatedSortedArraySearch {

	public static void main(String[] args) {
		Integer[] aArr = { 4, 5, 6, 7, 0, 1, 2 };
		List<Integer> a = Arrays.asList(aArr);

		RotatedSortedArraySearch p = new RotatedSortedArraySearch();
		System.out.println(p.search(a, 4));
	}

	public int search(final List<Integer> a, int b) {
		int aSize = a.size();
		int valStart = a.get(0);
		int valEnd = a.get(aSize - 1);

		int start = 0;
		int end = aSize - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			int midVal = a.get(mid);

			if (b == midVal) {
				return mid;
			} else {
				if (b >= valStart) {
					if (midVal > valStart && midVal < b) {
						start = mid + 1;
					} else {
						end = mid - 1;
					}
				} else {
					if (midVal < valEnd && midVal > b) {
						end = mid - 1;
					} else {
						start = mid + 1;
					}
				}

			}
		}
		return -1;
	}
}
