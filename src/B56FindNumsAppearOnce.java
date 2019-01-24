import org.junit.Test;

public class B56FindNumsAppearOnce {
	/*
	 * 题目：
	 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。
	 * 请写程序找出这两个只出现一次的数字。
	 * 将结果存在 num1 和 num2 数组中，两者长度都为1。
	 */
	public void solution(int[] array,int[] num1,int[] num2){
		if(array==null || array.length<2)
			return ;
		// 对数组中所有数进行异或操作
		int resultOR = 0;
		for(int i=0;i<array.length;i++){
			resultOR ^= array[i];
		}
		int indexOfBit1 = findFirstBit1(resultOR);
		
		/*
		 * 按照倒数第indexOfBit1是否为1来进行分组,然后依据 
		 * 任何数异或0都不变,异或本身为0,因此异或后的数是不重复的数
		 */
		for(int i=0;i<array.length;i++){
			if(isBit1(array[i],indexOfBit1))
				num1[0] ^= array[i];
			else
				num2[0] ^= array[i];
		}
	}
	
	// 找出倒数第几位出现1,将数组按照这个分类
	private int findFirstBit1(int num){
		int indexOfBit1 = 0;
		while((num&1)==0){
			num = num>>1;
			indexOfBit1++;
		}
		return indexOfBit1;
	}
	
	private boolean isBit1(int num,int indexOfBit1){
		int result = num>>indexOfBit1;
		return (result&1)==1;
	}
	
	@Test
	public void test(){
		int[] array = {2,4,3,6,3,2,5,5};
		int[] num1 = {0};
		int[] num2 = {0};
		solution(array,num1,num2);
		System.out.println("两个数为"+num1[0]+num2[0]);
	}
}
