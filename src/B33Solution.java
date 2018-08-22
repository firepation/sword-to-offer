import org.junit.Test;

public class B33Solution {
	
	@Test
	public void test(){
		int[] sequence = {5,7,6,11,10,8};
		System.out.println(VerifySquenceOfBST(sequence));
	}
	
	/**
	 * 题目：
	 * 输入一个整数数组，判断该数组是不是某二叉搜索数的后序遍历的结果。
	 * 如果是则输出 Yes，否则输出 No。假设输入的数组的任意两个数字互不
	 * 相同。
	 */
	
    public boolean VerifySquenceOfBST(int [] sequence) {
    	if(sequence==null || sequence.length==0)
    		return false;
    	return isTree(sequence,0,sequence.length-1);
    }
    
    private boolean isTree(int[] sequence,int start,int end){
        if(end <= start)
            return true;
        int rootNumber = sequence[end];
        int i,j;
        
        // 寻找左子树成员
        for(i=start;i<end;i++){
            if(sequence[i]>rootNumber)
                break;
        }
        
        // 寻找右子树成员
        for(j=i;j<end;j++){
            if(sequence[j]<rootNumber)
                return false;
        }
        
        boolean left = isTree(sequence,start,i-1);
        boolean right = isTree(sequence,i,end-1);
        
        return left & right;
    }
}
