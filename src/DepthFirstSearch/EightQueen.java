package DepthFirstSearch;
/*
 * DFS问题的一般解决步棸
 * 1 find, 在树的当前层，横向遍历，尝试找到OK的节点，（这一步通常叫做剪枝，只留下OK的）
 * 2 forWord， 若在当前层找到OK的节点，并且当前层不是最后一层，把OK的节点放到 ，进入下一层，跳到 find
 * 3 done,(right), 在当前层找到OK的节点，并且当前层是最后一层，打印结果； 进入当前层的下一点，跳到find；
 * 4 back 在当前层没有找到的OK的节点，返回上一层当前节点的下一个兄弟节点，跳到find
 */

/*
 * 在这里，每一次结果会得到一个数组，当找到一组解时，并没有试图去保存，而是直接把它输出到屏幕
 * 当继续寻找另外一组解时，新的结果就会把原来的给覆盖掉
 */

public class EightQueen {
	private  static final int N = 8; //棋盘行数
	int[] a = new int[N];  //表示棋盘，因为同一行只能放一个皇后，故用一维数组就可以表示结果，如a[2] = 2,就表示在第三行第2列放一个皇后
	                       //由于数组会被初始化为0， 故要用1-9列来表示
	int solution = 0;
	
	//判断在row行，col列是否可以放置皇后
	private boolean isOK(int row, int col){ 
		for(int i = 0; i < row; i++){
			if(a[i] == col || (Math.abs(a[i] - col) == row - i))
				return false;
		}
		return true;
	}
	
	private void display(){
		System.out.println("第" + ++solution + "种解");
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(a[i] == j)
					System.out.print(i + " ");
				else
					System.out.print("# ");
			}
			System.out.println();
		}
		System.out.println("------------------");
	}
	
	public void dfsFunction(int row){
		for(int col = 0; col < N; col++){
			//find
			if(isOK(row, col)){
				a[row] = col;
				//forword
				if(row != N-1)
					dfsFunction(row + 1);
				else //done
					display();
			}
		}		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EightQueen test = new EightQueen();
		test.dfsFunction(0);	
	}

}

