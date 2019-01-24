import java.util.ArrayList;

import org.junit.Test;

public class B29PrintMatrix{
	/**
	 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
	 * 例如，如果输入如下4 X 4矩阵：
	 *  1  2  3  4 
	 *  5  6  7  8
	 *  9 10 11 12 
	 * 13 14 15 16 
	 * 则依次打印出数字
	 * 1,  2,  3,  4,
	 * 8, 12, 16, 15,
	 *14, 13,  9,  5,
	 * 6, 7,  11, 10.
	 */
	
	@Test
	public void test(){
		// int[][] matrix = {{1,2},{3,4},{5,6},{7,8}};
		int[][] matrix= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printMatrix(matrix);
	}
	
	public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix==null)
            return null;
        
        int start = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        // 打印的结束条件
        while(matrix.length>start*2 && matrix[0].length>start*2){
            printMatrixInCircle(matrix,start,list);
            start++;
        }
        System.out.println(list);
        return list;
    }
	
	private void printMatrixInCircle(int[][] matrix,int start,ArrayList<Integer> list){
		int endX = matrix.length-1-start;
		int endY = matrix[0].length-1-start;
		// 从左到右
		for(int j=start;j<=endY;j++){
			list.add(matrix[start][j]);
		}
		// 从上到下
		if(start<endX){
			for(int i=start+1;i<=endX;i++){
				list.add(matrix[i][endY]);
			}
		}
		// 从右到左
		if(endY>start && endX>start){
			for(int j=endY-1;j>=start;j--)
				list.add(matrix[endX][j]);
		}
		// 从下到上
		if(start<endX && start<endY){
			for(int i=endX-1;i>start;i--){
				list.add(matrix[i][start]);
			}
		}
	}
}
