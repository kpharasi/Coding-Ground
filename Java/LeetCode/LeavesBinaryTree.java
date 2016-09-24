package leetcodeLocked;

import java.util.ArrayList;
import java.util.List;

public class LeavesBinaryTree {
	
	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data){
			this.data = data;
		}
	}
	
	public static List<List<Integer>> findleaves(TreeNode root) {
		
		List<List<Integer>> res = new ArrayList<>();
		height(root,res);
		return res;
	}
	
	public static int height(TreeNode root, List<List<Integer>> res) {
		if(root==null)
			return -1;
		
		int level = 1 + Math.max(height(root.left, res), height(root.right, res));
		
		if(res.size()<level+1)
			res.add(new ArrayList<Integer>());
		
		res.get(level).add(root.data);
		return level;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LeavesBinaryTree t = new LeavesBinaryTree();
		TreeNode root = createBinaryTree();
		List<List<Integer>> lRes = findleaves(root);
		
 		int len = lRes.size();
 		
 		for(List<Integer> l:lRes) {
 			System.out.println(l);
 		}
	}
	
	public static TreeNode createBinaryTree() {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		
		root.left = node2;
		root.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		return root;
	}

}
