package week3.tree;

import java.util.ArrayList;

import week3.tree.common.TreeNode;

/**
 * <pre>
 * Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 * 
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 
 * return
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * </pre>
 */
public class RootToLeafPathWithSums {

	public static void main(String[] args) {
		RootToLeafPathWithSums p = new RootToLeafPathWithSums();
		
		int[] aVals = {
				5,
				4, 8,
				11, -1, 13, 4,
				7, 2, -1, -1, -1, -1, 5, 1};
		TreeNode a = TreeNode.fromArray(aVals);
		
		System.out.println(p.pathSum(a, 22));

	}

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> currentPath = new ArrayList<Integer>();

		pathSum(result, currentPath, root, sum);

		return result;
	}

	public void pathSum(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> currentPath, TreeNode node, int sum) {

		if (node != null) {
			sum = sum - node.val;
			if (sum == 0 && node.left == null && node.right == null) {
				ArrayList<Integer> pathSum = new ArrayList<Integer>();
				pathSum.addAll(currentPath);
				pathSum.add(node.val);
				result.add(pathSum);
			} else {
				currentPath.add(node.val);
				pathSum(result, currentPath, node.left, sum);
				pathSum(result, currentPath, node.right, sum);
				currentPath.remove(currentPath.size() - 1);
			}
		}
	}
}
