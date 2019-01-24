package newcode.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertionSort {
	public static void insertionSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return ;
		}
		for(int i = 1;i < arr.length;i++) {
			for(int j = i -1;j >= 0 && arr[j] > arr[j+1];j--) {
				swap(arr,j,j+1);
			}
		}
	}
	
	public static void swap(int[] arr,int i,int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}
	
	// 生成随机数组
	public static int[] generateRandomArray(int size,int value) {
		int[] arr = new int[(int)((size+1) * Math.random())];
		for(int i = 0;i < arr.length;i++) {
			arr[i] = (int)((value + 1) * Math.random() - (int) (value * Math.random()));
		}
		return arr;
	}
	
	// 复制数组
	public static int[] copyArray(int[] a) {
		int[] res = new int[a.length];
		for(int i = 0;i<a.length;i++) {
			res[i] = a[i];
		}
		return res;
	}
	
	public static void rightMathod(int[] arr) {
		Arrays.sort(arr);
	}
	
	public static boolean isEuqal(int[] arr1,int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	
	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			insertionSort(arr1);
			rightMathod(arr2);
			if (!isEuqal(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		insertionSort(arr);
		printArray(arr);
	}
}
