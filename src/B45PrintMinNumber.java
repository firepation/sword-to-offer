package chacpter5;

import org.junit.Test;

public class B45PrintMinNumber {
    /*
     * 题目：
     * 输入一个正整数数组，把数组里面所有数字拼接成起来排成一个数，
     * 打印能拼接出的所有数字中最小的一个。例如，输入数组{3,32,321}，则
     * 打印出这3个数字能排成的最小数字321323
     */
    public String solution(int [] numbers) {
        if(numbers==null || numbers.length==0)
            return "";
        // 将int数组转为字符串数组，避免大数问题
        String[] strs = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            strs[i] = numbers[i]+"";
        }
        
        // 利用自定义的排序规则排序
        quickSort(strs,0,strs.length-1);
        //返回最终的结果
        String result = "";
        for(int i=0;i<strs.length;i++){
            result+=strs[i];
        }
        return result;
    }
    
    private void quickSort(String[] strs,int left,int right){
        if(left<right){
            int pointer = partition(strs,left,right);
            quickSort(strs,left,pointer);
            quickSort(strs,pointer+1,right);
        }
    }
    
    private int partition(String[] strs,int start,int end){
    	String pointer = strs[start];
        while(start<end){
            while(start<end && isStr1MinStr2(pointer,strs[end]))
                end--;
            strs[start] = strs[end];
            while(start<end && isStr1MinStr2(strs[start],pointer))
                start++;
            strs[end] = strs[start];
        }
        strs[start] = pointer;
        return start;
    }
        
    private boolean isStr1MinStr2(String str1,String str2){
        String num1AndNum2 = str1+str2;
        String num2AndNum1 = str2+str1;
        for(int i=0;i<num1AndNum2.length();i++){
            char c1 = num1AndNum2.charAt(i);
            char c2 = num2AndNum1.charAt(i);
            if(c1!=c2)
                return c1<c2;
        }
        return true;
    }
    
    @Test
    public void test(){
    	int[] nums = {3,32,321};
    	System.out.println(solution(nums));
    }
}
