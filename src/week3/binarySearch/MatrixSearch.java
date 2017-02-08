package week3.binarySearch;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/matrix-search/
 * <pre>
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * 
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than or equal to the last integer of the previous row.
 * Example:
 * 
 * Consider the following matrix:
 * 
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return 1 ( 1 corresponds to true )
 * 
 * Return 0 / 1 ( 0 if the element is not present, 1 if the element is present ) for this problem
 * </pre>
 */
public class MatrixSearch {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		ArrayList<Integer> c = new ArrayList<Integer>();
		ArrayList<Integer> d = new ArrayList<Integer>();
		ArrayList<Integer> e = new ArrayList<Integer>();
		ArrayList<Integer> f = new ArrayList<Integer>();
		ArrayList<Integer> g = new ArrayList<Integer>();
		ArrayList<Integer> h = new ArrayList<Integer>();
		ArrayList<Integer> i = new ArrayList<Integer>();
		a.add(3);
		b.add(29);
		c.add(36);
		d.add(63);
		e.add(67);
		f.add(72);
		g.add(74);
		h.add(78);
		i.add(85);
		
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		matrix.add(a);
		matrix.add(b);
		matrix.add(c);
		matrix.add(d);
		matrix.add(e);
		matrix.add(f);
		matrix.add(g);
		matrix.add(h);
		matrix.add(i);

		System.out.println(new MatrixSearch().searchMatrix(matrix, 41));
	}
	
	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
	    int row = findRow(a, b);
	    if (row != -1) {
	        int col = findCol(a.get(row), b);
	        
	        if (col != -1) {
	            return 1;
	        }
	    }
	    return 0;
	}
	
	public int findCol(ArrayList<Integer> a, int b) {
	    int cols = a.size();
	    
	    int start = 0; 
	    int end = cols - 1;
	    while (start <= end) {
	        int mid = (start + end) / 2;
	        int midVal = a.get(mid);
	        if (midVal == b) {
	            return mid;
	        } else if (midVal > b) {
	            end = mid - 1;
	        } else {
	            start = mid + 1;
	        }
	    }
	    return -1;
	}
	
	public int findRow(ArrayList<ArrayList<Integer>> a, int b) {
	    int rows = a.size();
	    int cols = a.get(0).size();
	    
	    int start = 0; 
	    int end = rows - 1;
	    while (start <= end) {
	        int mid = (start + end) / 2;
	        int midValStart = a.get(mid).get(0);
	        int midValEnd = a.get(mid).get(cols - 1);
	        if (midValStart <= b) {
	            if ( midValEnd >= b) {
	                return mid;
	            } else {
	                start = mid + 1;
	            }
	            
	        } else {
	            end = mid - 1;
	        }
	    }
	    return -1;
	}
}
