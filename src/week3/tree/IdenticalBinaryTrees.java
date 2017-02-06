package week3.tree;

import week3.tree.common.TreeNode;

/**
 * https://www.interviewbit.com/problems/identical-binary-trees/
 * <pre>
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * 
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * 
 * Example :
 * 
 * Input : 
 * 
 *    1       1
 *   / \     / \
 *  2   3   2   3
 * 
 * Output : 
 *   1 or True
 * </pre>
 */
public class IdenticalBinaryTrees {

	public static void main(String[] args) {
		IdenticalBinaryTrees p = new IdenticalBinaryTrees();
		
		int[] aVals = {1, 2, 3};
		TreeNode a = TreeNode.fromArray(aVals);

		int[] bVals = {1, 2, 3};
		TreeNode b = TreeNode.fromArray(bVals);
		
		System.out.println(p.isSameTree(a, b));
	}
	
	public int isSameTree(TreeNode a, TreeNode b) {
	    int same = 0;
	    
	    if (a == null && b == null) {
	        same = 1;
        } else if (a != null && b!= null && a.val == b.val) {
            if (isSameTree(a.left, b.left) == 1 && isSameTree(a.right, b.right) == 1) {
	            same = 1;
            }
        }

	    return same;
	}

}
