package week3.tree;

import week3.tree.common.TreeNode;

public class CountLeafNodes {

	public static void main(String[] args) {
		CountLeafNodes p = new CountLeafNodes();
		
		int[] aVals = {1, 2, 3};
		TreeNode a = TreeNode.fromArray(aVals);
		
		System.out.println("Leaf Nodes Count:  " + p.countLeafNodes(a));
		
		int[] bVals = {1, -1, 2, -1, -1, -1, 3};
		TreeNode b = TreeNode.fromArray(bVals);
		System.out.println("Leaf Nodes Count:  " + p.countLeafNodes(b));
		
		int[] cVals = {
				1, 
			  -1, 2, 
		  -1, -1, -1, 3, 
   -1, -1, -1, -1, -1, -1, -1, 4,
-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 5
		};
		TreeNode c = TreeNode.fromArray(cVals);
		System.out.println("Leaf Nodes Count:  " + p.countLeafNodes(c));
		
		int[] dVals = {3, 2, 4, 1, 3};
		TreeNode d = TreeNode.fromArray(dVals);

		System.out.println("Leaf Nodes Count:  " + p.countLeafNodes(d));
	}
	
	public int countLeafNodes(TreeNode node) {
		int count = 0;
		
		if (node != null) {
			if (node.left == null && node.right == null) {
				count = 1;
			} else {
				count += countLeafNodes(node.left) + countLeafNodes(node.right);
			}
		}
		return count;
	}

}
