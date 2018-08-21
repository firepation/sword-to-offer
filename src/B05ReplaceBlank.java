/*
	题目：请实现一个函数，把字符串中的每个空格替换成 "%20"。例如，
	输入 "We are happy",则输出 "We%20are%20happy"。
	
	思路：对输入的字符数组从后面开始遍历，按照要求给新的字符数组
	赋值。
*/

public class ReplaceBlank {
	public String replaceBlank(char[] str){
		if(str==null || str.length==0){
			return null;
		}
		
		int count = 0;
		// 计算字符串中有多少个空格
		for(int i=0;i<str.length;i++){
			if(str[i]==' '){
				count++;
			}
		}
		
		int newStrLength = count*2 + str.length;
		char[] newStr = new char[newStrLength];
		
		
		/*
			从字符串后面开始匹配，如果为空格，则在新的数组中
			替换为 %20，如果不是，则直接复制进新的字符串数组。
		*/
		
		for(int i=str.length-1;i>=0;i--){
			char c  = str[i];
			newStrLength--;
			if(c==' '){
				newStr[newStrLength]='0';
				newStr[--newStrLength]='2';
				newStr[--newStrLength]='%';
			}else{
				newStr[newStrLength]=c;
			}
		}
		
		return String.valueOf(newStr);
	}
	
	@Test
	public void replace(){
		String str = "Weare happy";
		// String str = "Weare    happy";
		// String str = "";
		String newStr = replaceBlank(str.toCharArray());
		System.out.println(newStr);
	}
}
