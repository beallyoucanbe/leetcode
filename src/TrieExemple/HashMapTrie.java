package TrieExemple;

import java.util.HashMap;

/*
 * 这里节点用hash表来存储
 * 
 */

class TrieNode {
	
	char val;
	HashMap<Character, TrieNode> children;
	boolean isWord;
    // Initialize your data structure here.
	public TrieNode(){
		 val = ' '; 
		 children = new HashMap<Character, TrieNode>();
	     isWord = false;
	}
    public TrieNode(char c) {
        val = c;
        children = new HashMap<Character, TrieNode>();
        isWord = false;
    }
}

public class HashMapTrie {
    private TrieNode root;

    public HashMapTrie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(search(word) == true)
        	return;
        TrieNode current = root;
        for(char c: word.toCharArray()){
        	if(current.children.containsKey(c))
        		current = current.children.get(c);
        	else{
        		TrieNode temp = new TrieNode(c);
        		current.children.put(c, temp);
        		current = temp;
        	}
        }
        current.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(word.length() == 0)
        	return false;
        TrieNode current = root;
        for(char c: word.toCharArray()){
        	if(!current.children.containsKey(c))
        		return false;
        	else
        		current = current.children.get(c);
        }
        if(current.isWord == true)
        	return true;
        else
        	return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(char c: prefix.toCharArray()){
        	if(!current.children.containsKey(c))
        		return false;
        	else
        		current = current.children.get(c);
        }
       return true;
    }
    
    public static void main(String[] args) {
    	HashMapTrie test = new HashMapTrie();
		test.insert("ball");
		test.insert("balls");
		test.insert("sense");

		// 测试方法
		System.out.println(test.search("balls"));
		System.out.println(test.search("ba"));
	
		System.out.println(test.search("balls"));
		System.out.println(test.search("ball"));

	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");