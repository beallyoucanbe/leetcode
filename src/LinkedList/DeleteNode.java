package LinkedList;

/*
 * Write a function to delete a node (except the tail) in a singly linked list, 
 * given only access to that node.
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
 * the linked list should become 1 -> 2 -> 4 after calling your function.
 * 这道题的意思是删除给定的节点Node，跟以前给定链表头不同，这次并没有给出一个完整的链表，而只有一个节点
 * 实际上并没有删除当前节点，而是跨过了当前节点的额下一个节点，但是要把下一节点的所有信息复制到当前节点并覆盖，这就等价于
 * 删除了当前节点
 */

public class DeleteNode {

	public void deleteNode(ListNode node) {
		if(node == null)
			return;
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
