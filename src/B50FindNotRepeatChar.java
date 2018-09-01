package chacpter5;

import org.junit.Test;

public class B50FindNotRepeatChar {
	/*
	 * 题目：
	 * 在字符串中找出第一个只出现一次的字符。
	 * 例如输入“abaccdeff”,则输出'b'
	 */
	public int solution(String str) {
        if(str==null || str.length()==0)
            return -1;
        char[] chars = str.toCharArray();
        int[] hashTable = new int[123];
        for(int i=0;i<chars.length;i++){
        	hashTable[chars[i]]++;
        }
        for(int i=0;i<chars.length;i++){
        	if(hashTable[chars[i]]==1)
        		return i+1;
        }
        return -1;
    }
	
	@Test
	public void test(){
		String str = "abaccdeff";
		System.out.println(solution(str));
	}
}
