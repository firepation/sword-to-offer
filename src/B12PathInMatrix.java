import org.junit.Test;

public class B12PathInMatrix {
	/*
	 * 题目：
	 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某
	 * 字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以
	 * 在矩阵中向左、右、下、上移动一个。如果一条路径经过了矩阵的某一格，
	 * 那么该路径不能再次进入该格子。例如，在下面的 3*4 的矩阵中包含一条
	 * 字符串“bfce”的路径。但矩阵中不包含字符串“abfb”的路径，因为字符
	 * 串的第个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入
	 * 这个格子。
	 */
	
	
	public static boolean hasPath(char[][] matrix,String str){
		if(matrix==null || str==null)
			return false;
		
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		int pathIndex = 0;
		
		for(int row=0;row<matrix.length;row++){
			for(int col=0;col<matrix[0].length;col++){
				if(hasPathCore(matrix,row,col,str,pathIndex,visited)){
					return true;
				}
			}
		}
		
		return false;
	}
	private static boolean hasPathCore(char[][] matrix,int row,int col,String str,int pathIndex,boolean[][] visited){
		if(pathIndex==str.length())
			return true;
		
		boolean hasPath = false;
		
		if(row>=0 && col>=0 && row<matrix.length && col<matrix[0].length
		  && matrix[row][col]==str.charAt(pathIndex) && !visited[row][col]){
			pathIndex++;
			visited[row][col] = true;
			
			hasPath = hasPathCore(matrix,row,col+1,str,pathIndex,visited) ||
					  hasPathCore(matrix,row,col-1,str,pathIndex,visited) ||
					  hasPathCore(matrix,row+1,col,str,pathIndex,visited) ||
					  hasPathCore(matrix,row-1,col,str,pathIndex,visited);
			
			if(!hasPath){
				pathIndex--;
				visited[row][col] = false;
			}
		}
		
		return hasPath;
	}
	
	
	@Test
	public void test(){
		char[][] matrix = {{'a','b','t','g'},
						   {'c','f','c','s'},
						   {'j','d','e','h'}};
		String str = "abte";
		boolean hasPath = hasPath(matrix,str);
		if(hasPath)
			System.out.println("矩阵中包含 "+str);
		else 
			System.out.println("矩阵中不包含 "+str);
	}
}
