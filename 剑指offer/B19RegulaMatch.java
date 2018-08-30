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
		return matchCore(str, pattern,0,0);
	}
	// 该算法不能够匹配 "**" 的模式
	private boolean matchCore(String str,String pattern,int i,int j){
		// 如果都匹配到了末尾，则说明字符和模式匹配
		if(i==str.length() && j==pattern.length())
			return true;
		/*
		 *  当字符串和模式任意一个匹配完了而另一个没有匹配完时
		 *  说明两者不匹配
		 */
		if((i<str.length() && j==pattern.length()) || (i==str.length() && j<pattern.length()))
			return false;
		
		char st = str.charAt(i);
		char pa = pattern.charAt(j);
		if(j<pattern.length()-1 && pattern.charAt(j+1)=='*'){
			if(st==pa || (pa=='.' && i<str.length())){
				return matchCore(str,pattern,i+1,j+2) || 
					   matchCore(str,pattern,i+1,j) ||
					   matchCore(str,pattern,i,j+2); 
			}else{
				/*
				 *  如果该位置上字符和模式不匹配，说明 * 不起作用
				 *  字符位置不变，模式移动两个位置
				 */
				return matchCore(str, pattern, i, j+2);
			}
		}
		/*
		 *  如果字符和模式上字符相等，或者模式上字符为 '.'
		 *  则进行下一个字符的匹配
		 */		
		if(st==pa || (pa=='.' && i<str.length()))
			return matchCore(str, pattern, i+1, j+1);
		
		return false;
	}
	
	@Test
	public void test(){
		System.out.println(isMatch("","**"));
		//System.out.println(isMatch("aaa","a.a"));
		//System.out.println(isMatch("aaa","ab*ac*a"));
		//System.out.println(isMatch("aaa","ab*a"));
	}
}
