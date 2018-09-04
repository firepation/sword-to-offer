import org.junit.Test;

public class B67StrToInt {
	
	@Test
	public void test(){
		System.out.println(solution("100"));
		System.out.println(solution("-100"));
		
		System.out.println(solution2("100"));
		System.out.println(solution2("-100"));
	}
	
	// 牛客网上看到的版本
	public int solution2(String str){
		if(str==null || "".equals(str.trim()))
			return 0;
		char[] chars = str.toCharArray();
		
		int oper = 1;
		if(chars[0]=='-')
			oper = -1;
		
		int result = 0;
		for(int i=(chars[0]=='-' || chars[0]=='+')?1:0;i<chars.length;i++){
			if(!('0' <= chars[i] && chars[i] <= '9')) 
				return 0;
			result = result*10 + (chars[i]-'0');
		}
		
		return result * oper;
		
	}
	
	// 我的版本
	public int solution(String str) {
		if(str==null || str.trim()=="")
			return 0;
		char[] chars = str.toCharArray();
		int index = 0;
		if(isOperation(chars[0]))
			index = 1;
		boolean flag = true;
		if(index==1 && chars[0]=='-')
			flag = false;
		if(!isIllegal(chars,index))
			return 0;
		
		return flag ? strToInt(chars,index) : -(strToInt(chars,index));
    }
	
	private int strToInt(char[] chars,int start){
		int result = 0;
		for(int i=start;i<chars.length;i++){
			result = result*10 + (chars[i]-'0');
		}
		return result;
	}
	
	private boolean isOperation(char c){
		if(c=='+' || c=='-')
			return true;
		return false;
	}
	
	private boolean isIllegal(char[] chars,int start){
		for(int i=start;i<chars.length;i++){
			if(chars[i]<48 || chars[i]>57)
				return false;
		}
		return true;
	}
}
