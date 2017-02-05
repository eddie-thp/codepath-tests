package week3.tree;

import week3.tree.common.TreeNode;

/**
 * https://www.interviewbit.com/problems/valid-binary-search-tree/
 * <pre>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node’s key.
 * The right subtree of a node contains only nodes with keys greater than the node’s key.
 * Both the left and right subtrees must also be binary search trees.
 * Example :
 * 
 * Input : 
 *    1
 *   /  \
 *  2    3
 * 
 * Output : 0 or False
 * 
 * 
 * Input : 
 *   2
 *  / \
 * 1   3
 * 
 * Output : 1 or True 
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * 
 * SOLUTION APPROACH :
 * 
 * Complete solution in the hints.
 * </pre>
 */
public class IdentifyBinarySearchTrees {
	
	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		TreeNode g = new TreeNode(7);
		TreeNode h = new TreeNode(8);
		TreeNode i = new TreeNode(9);
		TreeNode j = new TreeNode(10);
		TreeNode k = new TreeNode(11);
		TreeNode l = new TreeNode(12);
		
		a.right = b;
		b.right = c;
		c.right = d;
		d.right = e;
		e.right = f;
		f.right = g;
		g.right = h;
		h.right = i;
		i.right = j;
		j.right = k;
		k.right = l;
		
		IdentifyBinarySearchTrees p = new IdentifyBinarySearchTrees();
		
		System.out.println((p.isValidBST(a) == 1 ? true : false));
		
		TreeNode m = new TreeNode(3);
		TreeNode n = new TreeNode(2);
		TreeNode o = new TreeNode(4);
		TreeNode q = new TreeNode(1);
		TreeNode r = new TreeNode(3);
		
		m.left = n;
		m.right = o;
		n.left = q;
		n.right = r;
		
		System.out.println((p.isValidBST(m) == 1 ? true : false));
	}
	
	public int isValidBST(TreeNode a) {
		return (isBST(a, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0);
	}

	boolean isBST(TreeNode node, int min, int max) {
		boolean isBST = true;
		if (node != null) {
			if (node.val > min && node.val < max) {
				isBST = isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
			} else {
				return isBST = false;
			}
		}
		return isBST;
	}

}
