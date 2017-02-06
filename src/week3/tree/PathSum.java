package week3.tree;

import week3.tree.common.TreeNode;

/**
 * https://www.interviewbit.com/problems/path-sum/
 * <pre>
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 
 * Example :
 * 
 * Given the below binary tree and sum = 22,
 * 
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * </pre>
 */
public class PathSum {

	public static void main(String[] args) {
		
		PathSum p = new PathSum();
		
		int[] aVals = { 1000, 2000, -1, -3001, -1, -1, -1 };
		TreeNode a = TreeNode.fromArray(aVals);
		
		System.out.println("Has path sum ? " + p.hasPathSum(a, -1));
		
		int[] bVals = { 1000, 200, -1, -1, -1 };
		TreeNode b = TreeNode.fromArray(bVals);
		
		System.out.println("Has path sum ? " + p.hasPathSum(b, 1000));

		int[] cVals = { 1000, -1, -1, -1, -1 };
		TreeNode c = TreeNode.fromArray(cVals);
		
		System.out.println("Has path sum ? " + p.hasPathSum(c, 1000));
		
	}
	
	public int hasPathSum(TreeNode a, int b) {
	    if (a != null) {
	        
	        if (a.val == b && a.right == null && a.left == null) {
	            return 1;
	        } else {
    	        int pathSum = b - a.val;
    	        if (hasPathSum(a.left, pathSum) == 1) {
    	            return 1;
    	        } else if (hasPathSum(a.right, pathSum) == 1) {
    	            return 1;
    	        }
	        }
	    }
	    return 0;
	}

}
