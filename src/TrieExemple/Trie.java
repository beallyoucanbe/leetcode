package TrieExemple;

public class Trie {

	Node root;

	public Trie() {
		root = new Node(' ');
	}

	public void insert(String word) {
		if (search(word) == true)
			return;
		Node current = root;
		for (char c : word.toCharArray()) {
			if (current.subNode(c) != null) { // 原来的Trie中存在同样的前缀
				current = current.subNode(c);
			} else {
				Node temp = new Node(c); // 原来的Trie中不存在同样的前缀
				current.childList.add(temp);
				current = current.subNode(c);
			}
			current.count++;
		}
		current.isEnd = true;
	}

	public boolean search(String word) {
		if (word.length() == 0)
			return false;
		Node current = root;
		for (char c : word.toCharArray()) {
			if (current.subNode(c) == null)
				return false;
			else {
				current = current.subNode(c);
			}
		}
		if (current.isEnd == true)
			return true;
		else
			return false;
	}

	public void deleteWord(String word) {
		if (word.length() == 0 || search(word) == false)
			return;
		Node current = root;
		for (char c : word.toCharArray()) {
			Node child = current.subNode(c);
			if (current.count == 1) {
				current.childList.remove(child);
				current.count--;
				return;
			} else {
				current.count--;
				current = child;
			}
		}
		current.isEnd = false;
	}

	public static void main(String[] args) {
		Trie test = new Trie();
		test.insert("ball");
		test.insert("balls");
		test.insert("sense");

		// 测试方法
		System.out.println(test.search("balls"));
		System.out.println(test.search("ba"));
		test.deleteWord("balls");
		System.out.println(test.search("balls"));
		System.out.println(test.search("ball"));

	}
}
