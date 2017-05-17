package TrieExemple;

import java.util.LinkedList;

public class Node {

	char content;
	boolean isEnd;
	int count;      //��ȷ���count�������壬����ʾ���о����ýڵ�ĵ��ʵĸ��� 
	LinkedList<Node> childList;
	
	public Node(char c){
		childList = new LinkedList();
		content = c;
		isEnd = false;
		count = 0;
	}
	//�жϵ�ǰ�ڵ���ӽڵ��Ƿ����ĳ���ַ�c
	public Node subNode(char c){
		if(childList != null){
			for(Node eachChild: childList)
				if(eachChild.content == c)
					return eachChild;
		}
		return null;
	}
}
