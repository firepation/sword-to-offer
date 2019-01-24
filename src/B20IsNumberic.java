import org.junit.Test;

public class B20IsNumberic {
	/*
	 * 题目：
	 * 请实现一个函数用来判断字符串是否表示数值(包括整数和小数).
	 * 例如，字符串 "+100","5e2","-123","3.1415"以及"-1E-16"
	 * 都表示数值,但"12e","1a3.14","1.2.3","+-5"以及"12e+5.4"
	 * 都不是
	 */
	public boolean solution(char[] str) {
        if(str==null)
           return false;
        int[] index = {0};
        boolean numeric = scanInteger(str,index);
        if(index[0]<str.length && str[index[0]]=='.'){
            index[0]++;
            numeric = scanUnsignedInteger(str,index);
        }
        if(index[0]<str.length && (str[index[0]]=='e' || str[index[0]]=='E')){
            index[0]++;
            numeric = numeric && scanInteger(str,index);
        }
        return index[0]==str.length && numeric;
    }
    
    private boolean scanInteger(char[] str,int[] index){
        if(index[0]<str.length && (str[index[0]]=='+' || str[index[0]]=='-'))
            index[0]++;
        return scanUnsignedInteger(str,index);
    }
    
    private boolean scanUnsignedInteger(char[] str,int[] index){
        int before = index[0];
        while(index[0]<str.length && str[index[0]]>='0' && str[index[0]]<='9')
            index[0]++;
        return index[0]>before;
    }
    

	@Test
	public void test(){
		char[] str = "12e".toCharArray();
		System.out.println(solution(str));
	}
}
