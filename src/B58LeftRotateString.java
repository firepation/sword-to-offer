package chacpter6;

import org.junit.Test;

public class B58LeftRotateString {
	/*
	 * 题目：
	 * 字符串的左旋操作就是把字符串前面的若干个字符转移到
	 * 字符串的尾部。请定义一个函数实现字符串左旋操作的功能。比如，
	 * 输入字符串 "abcdefg" 和数字2,该函数将返回左旋转两位得到
	 * 结果为 "cdefgab"
	 */
	public String solution(String str,int index){
		if(str==null || str.length()==0){
			return "";
		}
		if(index<0 || index>str.length())
			return str;
		char[] c = reverse(str.toCharArray(),0,str.length()-1);
		int reverIndex = str.length()-index;
		c = reverse(c,0,reverIndex-1);
		c = reverse(c,reverIndex,str.length()-1);
		return new String(c);
	}
	private char[] reverse(char[] c,int start,int end){
		while(start<end){
			char temp = c[start];
			c[start] = c[end];
			c[end] = temp;
			start++;
			end--;
		}
		return c;
	}
	
	@Test
	public void test(){
		System.out.println(solution("abcdefg",2));
	}
}
