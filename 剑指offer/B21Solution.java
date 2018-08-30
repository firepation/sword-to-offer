public class B21Solution {
	
	/**
	 * 题目
	 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
	 * 所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
	 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
	 */
	
	 public void reOrderArray(int [] array) {
        if(array==null || array.length==0)
            return ;
        
        int[] odd = new int[array.length];
        int[] even = new int[array.length];
        
        int oddIndex = 0;
        int evenIndex = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]%2==0){
                even[evenIndex] = array[i];
                evenIndex++;
            }
            else{
                odd[oddIndex] = array[i];
                oddIndex++;
            }
        }
        
        int index = 0;
        for(int i=0;i<oddIndex;i++){
            array[index] = odd[i];
            index++;
        }
        
        for(int i=0;i<evenIndex;i++){
            array[index] = even[i];
            index++;
        }
    }
}
