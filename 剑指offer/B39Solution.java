package chacpter5;

import org.junit.Test;

public class B39Solution {
	public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null || array.length==0)
            return 0;
        
        int times = 0;
        int result = array[0];
        
        for(int i=0;i<array.length;i++){
            if(times==0){
                result=array[i];
                times++;
            }else if(result==array[i]){
                times++;
            }else{
                times--;
            }
        }
        
        times = 0;
        for(int i=0;i<array.length;i++){
        	if(result == array[i])
        		times++;
        }
        return times>array.length/2 ? result : 0;
    }
	
	@Test
	public void test(){
		int[] a = {1,2,3,2,4,2,5,2,3};
		System.out.println(MoreThanHalfNum_Solution(a));
	}
}
