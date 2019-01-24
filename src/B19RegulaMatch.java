package chacpter3;

import org.junit.Test;

public class B19RegulaMatch {
	/*
	 * 题目：请实现一个函数来匹配包含 '.' 和 '*' 的正则表达式。模式中的
	 * 字符串 '.' 表示任意一个字符，而 '*' 表示它前面的字符可以出现任意次（含0次）。
	 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串 "aaa"
	 * 与模式  "a.a" 和 "ab*ac*a" 匹配，但与 "aa.a" 和 "ab*a" 均不匹配。
	 */
	
	public boolean isMatch(String str,String pattern){
		if(str==null || pattern==null)
			return false;
		return matchCore(str.toCharArray(),pattern.toCharArray(),0,0);
	}
	// 该算法不能够匹配 "**" 的模式
	private boolean matchCore(char[] str,char[] pattern,int i,int j){
		if(i==str.length && j==pattern.length)
			return true;
		if(j==pattern.length)
			return false;
		
		if(j<pattern.length-1 && pattern[j+1]=='*'){
			if((i<str.length && str[i]==pattern[j]) || (pattern[j]=='.' && i<str.length)){
				return matchCore(str,pattern,i+1,j) || matchCore(str,pattern,i,j+2);
			}
			else{
				return matchCore(str,pattern,i,j+2);
			}
		}
		
		if(i<str.length && (pattern[j]=='.' || str[i]==pattern[j] ))
			return matchCore(str,pattern,i+1,j+1);
		return false;
	}
	
	@Test
	public void test(){
		System.out.println(isMatch("a","ab*a"));
	}
}
