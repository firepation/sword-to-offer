import org.junit.Test;

public class B37SerializeBinaryTrees {
	/*
	 * 题目：
	 * 实现两个函数，分别用来序列化和反序列化二叉树。
	 * 
	 * 对于序列化，使用前序遍历，递归的将二叉树的值转化为
	 * 字符串，并且在每次二叉树的节点不为空时，在转化val
	 * 所得字符之后添加一个','作为分割。对于空节点则以'#'
	 * 代替。
	 * 
	 * 对于反序列化，按照前序顺序，递归的使用字符串中的字符
	 * 创建一个二叉树。
	 */
	public String serialize(TreeNode root){
		StringBuilder result = new StringBuilder();
		if(root==null){
			result.append("#,");
			return result.toString();
		}
		result.append(root.val+",");
		result.append(serialize(root.left));
		result.append(serialize(root.right));
		return result.toString();
	}
	
	int index = -1;
	public TreeNode deserialize(String str){
		if(str.length()==0)
			return null;
		String[] strs = str.split(",");
		return deserialize(strs);
	}
	private TreeNode deserialize(String[] strs){
		index++;
		if(!strs[index].equals("#")){
			TreeNode root = new TreeNode(Integer.parseInt(strs[index]));
			root.left = deserialize(strs);
			root.right = deserialize(strs);
			return root;
		}
		return null;
	}
	
	@Test
	public void test(){
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.right = new TreeNode(6);
		System.out.println(serialize(root));
		System.out.println(deserialize("4,3,2,#,#,#,6,#,#,").val);
	}
}
