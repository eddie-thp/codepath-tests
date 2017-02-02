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
		// TODO Auto-generated method stub

	}
	
    public int t2Sum(TreeNode A, int B) {
        List<Integer> processedValues = new ArrayList<Integer>();
        processedValues.add(A.val);
        
        int result = t2Sum(processedValues, A.right, B);
        
        if (result == 0) {
            result = t2Sum(processedValues, A.left, B);
        }
        
        return result;
    }
    
    public int t2Sum(List<Integer> processedValues, TreeNode A, int B) {
        int result = 0;
        
        if (A != null) {
            int val = A.val;
            
            for (int pVal : processedValues) {
                if (B == pVal + val) {
                    result = 1;
                    break;
                }
            }

            processedValues.add(val);            

            if (result == 0) {
                result = t2Sum(processedValues, A.right, B);
            }
            
            if (result == 0) {
                result = t2Sum(processedValues, A.left, B);
            }
        }
        return result;
    }

}
