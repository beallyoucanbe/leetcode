package DepthFirstSearch;
/*
 * 马走日问题
 * 用一个二维数组来保存可以选择的方向
 * 在每一次back操作时，都要把当前的步棸抹去
 */

public class Horse {

	private static final int N = 5; // 用来记录棋盘格数
	int[][] a = new int[N][N]; //用来记录每一步的位置，当为0的时候表示当前位置没走走过
	int solution = 0; // 用来记录解的个数
	int k = 0; //用来记录当前的步数，即当前是第几步
	int[][] direction = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}}; // 用来记录每次可以走的八个方向
	
	private boolean isOK(int row, int col){
		if(row < 0 || row >= N || col < 0 || col >= N || a[row][col] != 0)
			return false;
		return true;
	}
	
	private void display(){
		System.out.println("第" + ++solution + "种解：");
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------------------");
		
	}
	
	public void dfsFunction(int row, int col) {
		for (int i = 0; i < 8; i++) {
			int newrow = row + direction[i][0];
			int newcol = col + direction[i][1];
			if (isOK(newrow, newcol)) {
				if (k != N * N - 1) {  //在找到最后一个点之前已经走过了N * N 个点
					a[newrow][newcol] = ++k;
					//forward
					dfsFunction(newrow, newcol);
					//back
					a[newrow][newcol] = 0;
					k--;
				} else{
					a[newrow][newcol] = N * N;
					display();
					a[newrow][newcol] = 0;
					}
			}
		}
	}
	public static void main(String[] args) {
		Horse test = new Horse();
		test.a[0][0] = 1;
		test.k = 1;
		test.dfsFunction(0, 0);

	}

}

