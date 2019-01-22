package newcode.sort;

/**
 * 冒泡排序实现
 */
public class BubbleSort {
	public static void bubbleSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return ;
		}
		
		for(int end = arr.length-1;end > 0;end--) {
			
		}
	}
	
	public static void swap(int[] arr,int i,int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
