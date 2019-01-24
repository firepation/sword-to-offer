import java.util.ArrayList;

import org.junit.Test;
public class B34FindTreePathSolution {
	/**
	 * 题目：
	 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点
	 * 值的和为输入整数的所有路径。路径定义为从树的根结点开始
	 * 往下一直到叶结点所经过的结点形成一条路径。
	 * (注意: 在返回值的list中，数组长度大的数组靠前)
	 */
	
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        int currentSum = 0;
        findPath(root,result,new ArrayList<Integer>(),currentSum,target);
        return result;
    }
    
    private void findPath(TreeNode node,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> path,int currentSum,int target){
        if(node==null)
            return ;
        currentSum += node.val;
        // 如果是叶节点，则判断当前路径和是否为目标值
        if(node.left == null && node.right == null){
            if(currentSum == target){
            	path.add(node.val);
            	// 这里需要重新构建一个 List，防止后续操作影响 path 的值。
                result.add(new ArrayList<Integer>(path));
                path.remove(path.size()-1);
            }
            return ;
        }
        
        // 如果不是叶节点，则继续遍历
        path.add(node.val);
        findPath(node.left,result,path,currentSum,target);
        findPath(node.right,result,path,currentSum,target);
        path.remove(path.size()-1);
    }
	
	static class TreeNode{
		int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	
	@Test
	public void test(){
		TreeNode node = new TreeNode(10);;
		node.left = new TreeNode(5);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(7);
		node.right = new TreeNode(12);
		
		System.out.println(FindPath(node, 22));
	}
}

