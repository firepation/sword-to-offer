import java.util.Random;

import org.junit.Test;

public class ArraySortUtil {	
	/*
	 * 排序的稳定性是指如果在排序的序列中，存在前后相同的两个
	 * 元素的话，排序前和排序后他们的相对位置不发生变化。
	 * */
	
	/*
	 *  冒泡排序
	 *  时间复杂度    O(N2)
	 *  空间复杂度   O(1)
	 */
	public static void bubbleSort(int[] arr){
		if(arr==null)
			return ;
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					swap(arr,j,j+1);
				}
			}
		}
	}
	
	/* 插入排序
	 * 时间复杂度   O(N2)，当数组趋向于正序排列时,时间复杂度趋向于 O(N)
	 * 空间复杂度  O(1)
	 */
	public static void insertionSort(int[] arr){
		
		if(arr==null)
			return ;
		
		for(int i=1;i<arr.length;i++){
			int number = arr[i];
			int insertIndex = i;
			for(int j=i-1;j>=0 && arr[j]>number;j--){
				arr[j+1] = arr[j];
				insertIndex = j;
			}
			arr[insertIndex] = number;			
		}
	}
	
	/*
	 *  选择排序
	 *  时间复杂度：  O(N2)
	 *  空间复杂度： O(1)
	 */
	public static void selectionSort(int[] arr){
		
		if(arr==null)
			return ;
		
		int minIndex;
		for(int i=0;i<arr.length-1;i++){
			minIndex = i;
			for(int j=i;j<arr.length;j++){
				if(arr[j]<arr[minIndex])
					minIndex = j;
			}
			swap(arr,i,minIndex);
		}
	}
	
	/*
	 *  希尔排序
	 *  本质上时一个插入排序
	 *  利用了插入排序越接近正序时时间复杂度越接近 O(N)的特点
	 */
	public static void shellSort(int[] arr){
		/*
		 *  需要选择一个步长，取值没有统一要求
		 *  只需要保证最后的值为 1
		 */
		int gap = 1;
		while(gap<arr.length/3)
			gap = gap*3+1;
		
		while(gap>=1){
			for(int i=gap;i<arr.length;i++){
				int number = arr[i];
				int insertIndex = i;
				for(int j=i-gap;j>=0&&arr[j]>number;j-=gap){
					arr[j+gap] = arr[j];
					insertIndex = j;
				}
				arr[insertIndex] = number;
			}
			gap = gap /3 ;
		}
	}
	
	/*
	 *  堆排序
	 *  时间复杂度： O(nlogn)
	 *  空间复杂度：O(1)
	 */
	public static void heapSort(int[] arr){
		
		// 进行堆的构建
		for(int i=arr.length/2-1;i>=0;i--){
			adjustHeap(arr,i,arr.length);
		}
		
		// 
		for(int i=arr.length-1;i>0;i--){
			swap(arr,0,i);
			adjustHeap(arr,0,i);
		}
		
	}
	private static void adjustHeap(int[] arr,int parent,int length){
		int parentNumber = arr[parent];
		int child = parent*2+1;
		while(child<length){
			if(child+1<length&&arr[child]<arr[child+1])
				child++;
			if(parentNumber>arr[child])
				break;
			
			swap(arr,parent,child);
			parent = child;
			child = parent*2+1;
		}
	}
	
	// 归并排序
	public static void mergeSort(int[] arr){
		int gap = 1;
		int left = 0;
		int mid = left+gap-1;
		int right = mid+gap;
		while(gap<arr.length){
			if(right>=arr.length){
				right = arr.length;
			}
			while(mid<arr.length-1){
				merge(arr,left,mid,right);
				left=right+1;
				mid=left+gap-1;
				right=mid+gap;
			}
			gap=gap*2;
		}
	}
	private static void merge(int[] arr,int left,int mid,int right){
		int i= left;
		int j= mid+1;
		int t = left;
		int[] tempArr = new int[arr.length];
		
		while(i<=mid && j<=right){
			if(arr[i]<arr[j]){
				tempArr[t] = arr[i++];
			}else{
				tempArr[t] = arr[j++];
			}
			t++;
		}
		while(i<=mid){
			tempArr[t] = arr[i++];
			t++;
		}
		while(j<=right){
			tempArr[t] = arr[j++];
			t++;
		}
		for(int start=left;start<=right;start++){
			arr[start] = tempArr[start];
		}
	}
	
	/*
	 *  快速排序
	 *  时间复杂度：最差 O(N2)，平均 O(NlogN)
	 */
	public static void quickSort(int[] arr){
		quickSortPartial(arr,0,arr.length-1);	
	}
	private static void quickSortPartial(int[] arr,int left,int right){
		
		if(left==right)
			return ;
		
		int index = new Random().nextInt(right-left+1)+left;
		swap(arr,index,right);
		
		int small = left-1;
		for(index=left;index<right;index++){
			if(arr[index]<arr[right]){
				small++;
				if(small!=index){
					swap(arr,small,index);
				}
			}
		}
		small++;
		swap(arr,small,right);
		
		if(small>left)
			quickSortPartial(arr, left, small-1);
		if(small<right)
			quickSortPartial(arr, small+1, right);
			
	}
	/*
	private static void quickSortPartial(int[] arr,int left,int right){
		
		if(left>=right)
			return ;
		
		int key = arr[left];
		int i = left;
		int j = right;
		while(i<j){
			while(i<j && arr[j]>=key){
				j--;
			}
			while(i<j && arr[i]<=key){
				i++;
			}			
			swap(arr,j,i);
		}
		if(arr[left]>arr[j])
			swap(arr,left,j);
		quickSortPartial(arr, left, j-1);
		quickSortPartial(arr, j+1, right);
	}
	*/

	@Test
	public void test(){
		int[] arr1 = {5,2,6,8,0,9,1,7,3,4};
		System.out.print("原数组为       ：");
		ArraySortUtil.printArray(arr1);
		
		ArraySortUtil.bubbleSort(arr1);
		System.out.print("冒泡排序结果：");
		ArraySortUtil.printArray(arr1);
		
		int[] arr2 = {5,2,6,8,0,9,1,7,3,4};
		ArraySortUtil.insertionSort(arr2);
		System.out.print("插入排序结果：");
		ArraySortUtil.printArray(arr2);
		
		int[] arr3 = {5,2,6,8,0,9,1,7,3,4};
		ArraySortUtil.selectionSort(arr3);
		System.out.print("选择排序结果：");
		ArraySortUtil.printArray(arr3);
		
		int[] arr4 = {5,2,6,8,0,9,1,7,3,4};
		ArraySortUtil.shellSort(arr4);
		System.out.print("希尔排序结果：");
		ArraySortUtil.printArray(arr4);
		
		int[] arr5 = {5,2,6,8,0,9,1,7,3,4};
		ArraySortUtil.heapSort(arr5);
		System.out.print("堆排序结果   ：");
		ArraySortUtil.printArray(arr5);
		
		int[] arr6 = {5,2,6,8,0,9,1,7,3,4};
		ArraySortUtil.heapSort(arr6);
		System.out.print("归并排序结果：");
		ArraySortUtil.printArray(arr6);
		
		int[] arr7 = {5,2,6,8,1,1,9,7,3,3};
		ArraySortUtil.quickSort(arr7);
		System.out.print("快速排序结果：");
		ArraySortUtil.printArray(arr7);
	}
	
	// 交换两个元素之间的位置
	private static void swap(int[] arr,int x,int y){
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	
	// 打印数组内容
	public static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
}
