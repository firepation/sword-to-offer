
import java.util.ArrayDeque;
import java.util.ArrayList;

public class B32PrintTree {
	/**
	 * 题目：不分行从上到下打印二叉树
	 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺
	 * 序打印。 
	 */
	
	 public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode current = root;
        if(current!=null){
            ArrayDeque<TreeNode> deque = new ArrayDeque<>();
            deque.add(current);
            while(!(deque.isEmpty())){
                current = deque.pop();
                list.add(current.val);
                if(current.left!=null)
                    deque.add(current.left);
                if(current.right!=null)
                    deque.add(current.right);
            }
        }
        return list;
	}
}
