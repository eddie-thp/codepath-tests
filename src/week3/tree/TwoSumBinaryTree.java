package week3.tree;

import java.util.ArrayList;
import java.util.List;

import week3.tree.common.TreeNode;

/**
 * <pre>
 * Given a binary search tree T, where each node contains a positive integer, and an integer K, you have to find whether or not there exist two different nodes A and B such that A.value + B.value = K.
 * 
 * Return 1 to denote that two such nodes exist. Return 0, otherwise.
 * 
 * Notes 
 * - Your solution should run in linear time and not take memory more than O(height of T).
 * - Assume all values in BST are distinct.
 * 
 * Example :
 * 
 * Input 1: 
 * 
 * T :       10
 *          / \
 *         9   20
 * 
 * K = 19
 * 
 * Return: 1
 * 
 * Input 2: 
 * 
 * T:        10
 *          / \
 *         9   20
 * 
 * K = 40
 * 
 * Return: 0
 * </pre>
 * @author eduar
 *
 */
public class TwoSumBinaryTree {

	public static void main(String[] args) {
		TreeNode a = new TreeNode(10);
		TreeNode b = new TreeNode(9);
		TreeNode c = new TreeNode(20);
		a.left = b;
		a.right = c;
		
		System.out.println((new TwoSumBinaryTree()).t2Sum(a, 40));
	}
	
    public int t2Sum(TreeNode A, int B) {
        return t2Sum(A, A, B);
    }
    
    public int t2Sum(TreeNode root, TreeNode A, int B) {
    	int result = 0;
    	if (A != null) {
	        int toSearch = B - A.val;
	        
	        if (toSearch != A.val) {
	        	result = search(root, toSearch);
	        }
        	
        	if (result == 0) {
        		result = t2Sum(root, A.left, B);
        	}

        	if (result == 0) {
        		result = t2Sum(root, A.right, B);
        	}
    	}        
        return result;
    }
    
    public int search(TreeNode node, int toSearch) {
    	int found = 0;

    	if (node != null) {
	    	if (node.val == toSearch) {
	    		found = 1;
	    	} else if (toSearch < node.val) {
	    		found = search(node.left, toSearch);
	    	} else {
	    		found = search(node.right, toSearch);
	    	}
    	}
    	
    	return found; 
    }

    

}
