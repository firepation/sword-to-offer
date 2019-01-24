package leetcode;

import java.util.Stack;

import org.junit.Test;

public class EvaluateReversePolish {
	public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<Integer>();
        for(int i=0;i<tokens.length;i++){
            if(isOperate(tokens[i])){
            	int num1 = nums.pop();
            	int num2 = nums.pop();
                int result = caculate(tokens[i],num2,num1);
                nums.push(result);
            }
            else 
            	nums.push(Integer.parseInt(tokens[i]));
        }
        return nums.pop();
    }
    
    private int caculate(String oper,int num1,int num2){
        switch(oper){
            case "+":
                return num1+num2;
            case "-":
                return num1-num2;
            case "*":
                return num1*num2;
            case "/":
                return num1/num2;
            default:
                throw new RuntimeException("位置操作符");
        }
    }
    
    private boolean isOperate(String str){
        if(str.equals("*") || str.equals("-") || str.equals("+") || str.equals("/"))
            return true;
        return false;
    }
    
    @Test
    public void test(){
    	String[] express = {"4","1","+","3","*"};
    	System.out.println(evalRPN(express));
    }
}
