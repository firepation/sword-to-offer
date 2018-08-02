import org.junit.Test;

public class B17Print1ToMaxOfDigits {
	/*
	 * 题目：输入数字n,按顺序打印出从1到最大的n位十进制数。比如输
	 * 入3，则打印1,2,3一直到最大的3位数999
	 * */
	
	/*
	 * 这种做法并没有考虑到n值很大的情况，当
	 * n很大时，int类型和long类型都会溢出
	 * */
	public void method1(int n){
		int num = 1;
		int i=0;
		while(i++<n){
			num *= 10;
		}
		for(i=1;i<num;i++){
			System.out.println(i);
		}
	}
	
	/*
	 * 为了解决大数问题，可以使用字符串表示数字，
	 * 这样需要做两件事，首先模拟字符串的加减法，然后将
	 * 字符串对应的数字表示出来。
	 */
	public void method2(int n){
		if(n<=0)
			return ;
		
		char[] number = new char[n];
		for(int i=0;i<number.length;i++){
			number[i] = '0';
		}
		while(!increment(number)){
			printNumber(number);
		}
	}
	private boolean increment(char[] number){
		boolean isOverflow = false;
		int lastIndex = number.length-1;
		int nTakeOver = 0;
		for(int i=lastIndex;i>=0;i--){
			// 将第 n 为用数字表示
			int nSum = number[i]-'0'+nTakeOver;
			// 如果是最后一位，则加1
			if(i==lastIndex)
				nSum++;
			
			if(nSum>=10){
				if(i==0)
					isOverflow = true;
				else{
					nTakeOver = 1;
					nSum -= 10;
					number[i] = (char)('0'+nSum);
				}					
			}else{
				number[i] = (char)('0'+nSum);
				break;
			}
		}
		return isOverflow;
	}
	private void printNumber(char[] number){
		int length = number.length;
		boolean isBegin0 = true;
		for(int i=0;i<length;i++){
			if(isBegin0 && number[i]!='0'){
				isBegin0 = false;
			}
			if(!isBegin0)
				System.out.print(number[i]);
		}
		System.out.println();
	}
	
	
	/*
	 * 上面方法虽然能够解决问题，但是代码的实现过于复杂，
	 * 接下来是使用另一种方法实现，用递归的方式解决该问题
	 * 打印的过程相当于所有位置上的数字进行排列组合，每个位置
	 * 都是0-9
	 */
	public void method3(int n){
		if(n<=0)
			return;
		
		char[] number = new char[n];
		for(int i=0;i<10;i++){
			number[0] = (char)('0'+i);
			print1ToMaxOfNDigitsRecursively(number, 0);
		}
	}
	private void print1ToMaxOfNDigitsRecursively(char[] number,int index){
		if(index==number.length-1){
			printNumber(number);
			return ;
		}
		for(int i=0;i<10;i++){
			number[index+1] = (char)('0'+i);
			print1ToMaxOfNDigitsRecursively(number, index+1);
		}			
	}
	@Test
	public void testMethod(){
		method3(2);
	}
}
