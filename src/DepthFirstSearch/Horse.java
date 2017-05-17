package DepthFirstSearch;
/*
 * ����������
 * ��һ����ά�������������ѡ��ķ���
 * ��ÿһ��back����ʱ����Ҫ�ѵ�ǰ�Ĳ���Ĩȥ
 */

public class Horse {

	private static final int N = 5; // ������¼���̸���
	int[][] a = new int[N][N]; //������¼ÿһ����λ�ã���Ϊ0��ʱ���ʾ��ǰλ��û���߹�
	int solution = 0; // ������¼��ĸ���
	int k = 0; //������¼��ǰ�Ĳ���������ǰ�ǵڼ���
	int[][] direction = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}}; // ������¼ÿ�ο����ߵİ˸�����
	
	private boolean isOK(int row, int col){
		if(row < 0 || row >= N || col < 0 || col >= N || a[row][col] != 0)
			return false;
		return true;
	}
	
	private void display(){
		System.out.println("��" + ++solution + "�ֽ⣺");
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
				if (k != N * N - 1) {  //���ҵ����һ����֮ǰ�Ѿ��߹���N * N ����
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

