package TrieExemple;

import java.util.LinkedList;

public class Node {

	char content;
	boolean isEnd;
	int count;      //正确理解count的毅意义，它表示所有经过该节点的单词的个数 
	LinkedList<Node> childList;
	
	public Node(char c){
		childList = new LinkedList();
		content = c;
		isEnd = false;
		count = 0;
	}
	//判断当前节点的子节点是否存在某个字符c
	public Node subNode(char c){
		if(childList != null){
			for(Node eachChild: childList)
				if(eachChild.content == c)
					return eachChild;
		}
		return null;
	}
}
