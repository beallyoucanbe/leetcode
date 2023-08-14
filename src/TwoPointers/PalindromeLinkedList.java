package TwoPointers;

import java.util.Vector;

/*
 * Given a singly linked list, determine if it is a palindrome(回文).
 * Could you do it in O(n) time and O(1) space?
 */
/*
 * 方法一，把内容取出来装在一个动态数组里，或是栈里 时间复杂度O（n）， 空间复杂度o(n)
 * 方法二， 找到链表的中点，然后把后面一半链表反转，
 */
public class PalindromeLinkedList {
	 public boolean isPalindrome(ListNode head) {
	        if(head == null || head.getNext() == null)
	        	return true;
	        ListNode node = head;
	        Vector<Integer> vals = new Vector();
	        while(node != null){
	        	vals.add(node.getVal());
	            node = node.getNext();
	        }
	        
	        for(int i = 0, j = vals.size() - 1; i <= j; i++, j--){
	        	if(vals.get(i)!= vals.get(j))
	        		return false;
	        }
	        return true;   
	    }
	 // 第二种方法，不使用额外的空间，先分割，在翻转即可，最后一一比较
	 public boolean isPalindrome2(ListNode head) {
	        if(head == null || head.getNext() == null)
	        	return true;
	        ListNode slow = head, fast =  head, pre = null;
	        while(fast != null && fast.getNext() != null){
	        	pre = slow;
	        	slow = slow.getNext();
	        	fast = fast.getNext();
	        }
	        pre.setNext(null);
	        ListNode left = head;
	        ListNode right = slow;
	        
	        right = reverseList(right);
	        while(left != null && right != null){
	        	if(left.getVal() != right.getVal())
	        		return false;
	        	left = left.getNext();
	        	right = right.getNext();
	        }     
	        return true;   
	    }
	 private ListNode reverseList(ListNode head){
		 if(head == null || head.getNext() == null)
			 return head;
		 ListNode second = head.getNext();
		 head.setNext(null);
		 while(second != null){
			 ListNode temp = second;
			 second = second.getNext();
			 temp.setNext(head);
			 head = temp;
		 } 
		 return head;
	 }
	public static void main(String[] args){
		// TODO Auto-generated method stub

		PalindromeLinkedList test = new PalindromeLinkedList();
		int[] nums = { 1 ,2,3,4,3,2,1};
		ListNode head = ListNodeFunction.arrayToList(nums);
		ListNodeFunction.display(head);
		System.out.println(test.isPalindrome2(head));
	}

}
