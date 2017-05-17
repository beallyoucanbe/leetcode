package DepthFirstSearch;
/*
 * DFS�����һ��������
 * 1 find, �����ĵ�ǰ�㣬��������������ҵ�OK�Ľڵ㣬����һ��ͨ��������֦��ֻ����OK�ģ�
 * 2 forWord�� ���ڵ�ǰ���ҵ�OK�Ľڵ㣬���ҵ�ǰ�㲻�����һ�㣬��OK�Ľڵ�ŵ� ��������һ�㣬���� find
 * 3 done,(right), �ڵ�ǰ���ҵ�OK�Ľڵ㣬���ҵ�ǰ�������һ�㣬��ӡ����� ���뵱ǰ�����һ�㣬����find��
 * 4 back �ڵ�ǰ��û���ҵ���OK�Ľڵ㣬������һ�㵱ǰ�ڵ����һ���ֵܽڵ㣬����find
 */

/*
 * �����ÿһ�ν����õ�һ�����飬���ҵ�һ���ʱ����û����ͼȥ���棬����ֱ�Ӱ����������Ļ
 * ������Ѱ������һ���ʱ���µĽ���ͻ��ԭ���ĸ����ǵ�
 */

public class EightQueen {
	private  static final int N = 8; //��������
	int[] a = new int[N];  //��ʾ���̣���Ϊͬһ��ֻ�ܷ�һ���ʺ󣬹���һά����Ϳ��Ա�ʾ�������a[2] = 2,�ͱ�ʾ�ڵ����е�2�з�һ���ʺ�
	                       //��������ᱻ��ʼ��Ϊ0�� ��Ҫ��1-9������ʾ
	int solution = 0;
	
	//�ж���row�У�col���Ƿ���Է��ûʺ�
	private boolean isOK(int row, int col){ 
		for(int i = 0; i < row; i++){
			if(a[i] == col || (Math.abs(a[i] - col) == row - i))
				return false;
		}
		return true;
	}
	
	private void display(){
		System.out.println("��" + ++solution + "�ֽ�");
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

