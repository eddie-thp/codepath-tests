package week1.challenges;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/spiral-order-matrix-i/
 *
 * <pre>
 * Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * 
 * Example:
 * 
 * Given the following matrix:
 * 
 * [
 *     [ 1, 2, 3 ],
 *     [ 4, 5, 6 ],
 *     [ 7, 8, 9 ]
 * ]
 * 
 * You should return
 * 
 * [1, 2, 3, 6, 9, 8, 7, 4, 5]
 * Problem Approach :
 * 
 * Complete solution in the hints. (https://www.youtube.com/watch?v=siKFOI8PNKM)
 * </pre>
 */
public class Challenge3 {
	public static void main(String args[]) {
		Challenge3 c = new Challenge3();
		
		List<ArrayList<Integer>> rows = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> row1 = new ArrayList<Integer>();
		row1.add(1);
		row1.add(2);
		row1.add(3);

		ArrayList<Integer> row2 = new ArrayList<Integer>();
		row2.add(4);
		row2.add(5);
		row2.add(6);

		ArrayList<Integer> row3 = new ArrayList<Integer>();
		row3.add(7);
		row3.add(8);
		row3.add(9);

		rows.add(row1);
		rows.add(row2);
		rows.add(row3);

		// Test case 1
		c.printMatrix(rows);
		System.out.println("Spiral 1: " + c.spiralOrder(rows));
		
		//
		rows = new ArrayList<ArrayList<Integer>>();
		
		row1 = new ArrayList<Integer>();
		row1.add(1);
		row1.add(2);
		row1.add(3);
		row1.add(4);
		
		row2 = new ArrayList<Integer>();
		row2.add(5);
		row2.add(6);
		row2.add(7);
		row2.add(8);
		
		row3 = new ArrayList<Integer>();
		row3.add(9);
		row3.add(10);
		row3.add(11);
		row3.add(12);
		
		ArrayList<Integer> row4 = new ArrayList<Integer>();
		row4.add(13);
		row4.add(14);
		row4.add(15);
		row4.add(16);
		
		rows.add(row1);
		rows.add(row2);
		rows.add(row3);
		rows.add(row4);
		
		// Test case 2
		c.printMatrix(rows);
		System.out.println("Spiral: " + c.spiralOrder(rows));
		
		
		// Test case 3
		rows = new ArrayList<ArrayList<Integer>>();
		
		row1 = new ArrayList<Integer>();
		row1.add(1);
		row1.add(2);
		row1.add(3);
		row1.add(4);
		
		rows.add(row1);
		
		c.printMatrix(rows);
		System.out.println("Spiral: " + c.spiralOrder(rows));
		
		// Test case 4
		rows = new ArrayList<ArrayList<Integer>>();
		
		row1 = new ArrayList<Integer>();
		row1.add(1);
		row1.add(2);
		row1.add(3);
		
		row2 = new ArrayList<Integer>();
		row2.add(4);
		row2.add(5);
		row2.add(6);

		rows.add(row1);
		rows.add(row2);

		c.printMatrix(rows);
		System.out.println("Spiral: " + c.spiralOrder(rows));

	}

	public void printMatrix(final List<ArrayList<Integer>> a) {
		System.out.println("========= Matrix =======");
		for (ArrayList<Integer> row : a) {
			System.out.println(row);
		}
	}
	

	public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 
		 int totalRows = a.size();
		 int totalCols = a.get(0).size();
		 
		 int startRow = 0;
		 int startCol = 0;
		 int endRow = totalRows - 1;
		 int endCol = totalCols - 1;
		 while (startRow < totalRows 
				 && startCol < totalCols 
				 && startRow <= endRow 
				 && startCol <= endCol) {
			 
			 if (startCol <= endCol) {
				 readRowLeftRight(startRow, startCol, endCol, a, result);
			 }

			 if (startRow + 1 <= endRow) {
				 readColTopBottom(endCol, startRow + 1, endRow, a, result);
			 }

			 if ((endRow != startRow) && endCol - 1 >= startCol) {
				 readRowRightLeft(endRow, endCol - 1, startCol, a, result);
			 }

			 if ((startCol != endCol) && endRow - 1 >= startRow + 1) {
				 readColBottomTop(startCol, endRow - 1, startRow + 1, a, result);
			 }
			 
			 startRow++;
			 startCol++;
			 endRow--;
			 endCol--;
		 }
		 
		 return result;
	}
	
	public void readRowLeftRight(int line, int start, int end, final List<ArrayList<Integer>> a, ArrayList<Integer> result)
	{
		for (int i = start; i <= end; i++) {
			result.add(a.get(line).get(i));
		}
	}

	public void readColTopBottom(int col, int start, int end, final List<ArrayList<Integer>> a, ArrayList<Integer> result)
	{
		for (int i = start; i <= end; i++) {
			result.add(a.get(i).get(col));
		}
	}

	public void readRowRightLeft(int line, int start, int end, final List<ArrayList<Integer>> a, ArrayList<Integer> result)
	{
		for (int i = start; i >= end; i--) {
			result.add(a.get(line).get(i));
		}
	}

	public void readColBottomTop(int col, int start, int end, final List<ArrayList<Integer>> a, ArrayList<Integer> result)
	{
		for (int i = start; i >= end; i--) {
			result.add(a.get(i).get(col));
		}
	}
}

