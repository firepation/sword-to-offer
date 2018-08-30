import org.junit.Test;

public class B11RevolveArray {
	/*
	 * 题目：
	 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为
	 * 数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小
	 * 元素。例如，数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小
	 * 值为1.
	 * */
	
	
	@Test
	public void test(){
		//int[] arr = {5,6,7,8,9,0,1,2,3,4};
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		System.out.println("最小数字为 : "+findMin(arr));
	}
	
	/*
	 * 没有MinInOrder的情况下，这个函数可以解决大部分问题，例如
	 * [5,6,7,8,9,0,1,2,3,4]
	 * 然而这种情况就没有考虑到
	 * [1,0,1,1,1,1]
	 * 此时需要辅助函数 MinInOrder
	 */
	public int findMin(int[] arr){
		if(arr==null || arr.length<=0)
			throw new RuntimeException("不合法的输入");
		int left = 0;
		int right = arr.length-1;
		int mid = left;
		
		while(arr[left]>=arr[right]){
			if(right-left==1){
				mid = right;
				break;
			}
			mid = (left+right)/2;
			
			// 如果三个数都相等，那么使用正常的查找方法
			if(arr[left]==arr[right]&&arr[left]==arr[mid])
				return findInOrder(arr,left,right);
			
			if(arr[mid]>arr[left])
				left = mid;
			else if(arr[mid]<arr[right])
				right = mid;
		}
		return arr[mid];
	}
	
	private int findInOrder(int[] arr,int left,int right){
		int result = arr[left];
		for(int i=left;i<right-1;i++){
			if(arr[left]>arr[i]){
				result = i;
				break;
			}
		}
		return result;
	}
}
