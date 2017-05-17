package Backtracking;

import java.util.Arrays;
/*
 * ѧϰ�±��˵����������ö����boolean�������ж�
 * ���ǣ����������һ���ܴ��ȱ�ݣ������ö���������������Ƿ���ʹ�������ֱ����ԭ�����Ͻ����޸ģ�
 * ��ô��һ������������֮����������һ�������ͻ���ִ�����ΪҪ�����������Ѿ����ı���
 */

public class WordSearchnew {

	public boolean exist(char[][] board, String word) {
	    int m = board.length;
	    int n = board[0].length;
	 
	    boolean result = false;
	    
	    for(int i=0; i<m; i++){
	        for(int j=0; j<n; j++){
	           if(dfs(board,word,i,j,0)){
	               result = true;
	           }
	        }
	    } 
	    return result;
	}
	 
	public boolean dfs(char[][] board, String word, int i, int j, int k){
	    int m = board.length;
	    int n = board[0].length;
	 
	    if(i<0 || j<0 || i>=m || j>=n){
	        return false;
	    }
	 
	    if(board[i][j] == word.charAt(k)){
	        char temp = board[i][j];
	        board[i][j]='#';
	        if(k==word.length()-1){
	            return true;
	        }else if(dfs(board, word, i-1, j, k+1)
	        ||dfs(board, word, i+1, j, k+1)
	        ||dfs(board, word, i, j-1, k+1)
	        ||dfs(board, word, i, j+1, k+1)){
	            return true;
	        }
	        board[i][j]=temp;
	    }
	 
	    return false;
	}
	
	public static void main(String[] args) {
		WordSearchnew test = new WordSearchnew();
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } };
		for (char[] chars : board)
			System.out.println(Arrays.toString(chars));
		String word1 = "BCCED";
		String word2 = "ASADEE";
		String word3 = "ABCB";
		if (test.exist(board, word2))
			System.out.println("word2 Ϊtrue");
		if (test.exist(board, word3))
			System.out.println("word3 Ϊtrue");
	}

}
