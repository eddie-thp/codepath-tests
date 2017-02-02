package week3.tree;

import week3.tree.common.TreeNode;

/**
 * https://www.interviewbit.com/problems/balanced-binary-tree/
 * 
 * <pre>
 * Given a binary tree, determine if it is height-balanced.
 * 
 *  Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * 
 * Example :
 * 
 * Input : 
 *           1
 *          / \
 *         2   3
 * 
 * Return : True or 1 
 * 
 * Input 2 : 
 *          3
 *         /
 *        2
 *       /
 *      1
 * 
 * Return : False or 0 
 *          Because for the root node, left subtree has depth 2 and right subtree has depth 0. 
 *          Difference = 2 > 1.
 * </pre>
 */
public class BalancedBinaryTree {

	public static void main(String[] args) {
		BalancedBinaryTree p = new BalancedBinaryTree();
		
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		a.right = b;
		a.left = c;
		
		System.out.println("isBalanced ? " + (p.isBalanced(a) == 1 ? true : false));
		
		TreeNode d = new TreeNode(1);
		TreeNode e = new TreeNode(2);
		TreeNode f = new TreeNode(3);
		d.right = e;
		e.left = f;

		System.out.println("isBalanced ? " + (p.isBalanced(d) == 1 ? true : false));

	}

	public int isBalanced(TreeNode a) {
		int balanced = 1;

		if ((a.right == null && a.left != null && (a.left.right != null || a.left.left != null))
				|| (a.left == null && a.right != null && (a.right.right != null || a.right.left != null))) {
			balanced = 0;
		}

		if (balanced == 1 && a.right != null) {
			balanced = isBalanced(a.right);
		}

		if (balanced == 1 && a.left != null) {
			balanced = isBalanced(a.left);
		}

		return balanced;
	}

}
