package LinkedList;
/*
 * ɾ������������ֵΪval�Ľڵ�
 * ������ָ��
 */

/*
 * 1. ����������ɾ����ǰ�ڵ�ʱ����Ҫ֪����ǰ�ڵ�ĸ��ڵ㡣
2. ���ڷ�ͷ�ڵ㣬ɾ�������ܷ��㣬����ͷ�ڵ���Ҫ����Ĳ�����
Ϊ���ڱ����Ĺ����У�����ɾ��������һ���Ժͱ�������ͷ�ڵ�ͷ�ͷ�ڵ㣬�����ַ��������������鷳��
�ٿ���Ϊ�������ø���ͷ�ڵ㣨����ԭ������ǰ����ͷ�ڵ㣩�������Ծ��и���ͷ�ڵ������
�ڱ���ʱ�Ͳ���������ͷ�ڵ�ͷ�ͷ�ڵ�����⡣
The key to solve this problem is using a helper node to track the head of the list.
�ڴ�ͷ�ڵ����һ���ڵ㿪ʼ��������ɾ����������ɺ��ٴ���ͷ�ڵ㡣
 */

/*
 * ������ֻ��һ��{3}��val = 3ʱ����һ�������ᱨ���������������У�˼��Ϊʲô��
 */
public class RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return head;
		while (head.val == val)
			head = head.next;     //����ֿ�ָ��Ŀ���
		ListNode cur = head;
		ListNode next = head.next;  
		while (next != null) {
			if (next.val == val) {
				cur.next = next.next;
				next = next.next;
			} else {
				next = next.next;
				cur = cur.next;
			}
		}
		return head;
	}
	
	public ListNode removeElements2(ListNode head, int val) {
		if (head == null)
			return head;
		ListNode cur = head;
		ListNode next = head.next;
		while (next != null) {
			if (next.val == val) {
				cur.next = next.next;
				next = next.next;
			} else {
				next = next.next;
				cur = cur.next;
			}
		}
		if(head.val == val)
			head = head.next;
		return head;
	}
	
	public ListNode removeElements3(ListNode head, int val) {
		if (head == null)
			return head;
		ListNode temp = new ListNode(0);
		temp.next = head;
		ListNode cur = temp;
		ListNode next = temp.next;
		while (next != null) {
			if (next.val == val) {
				cur.next = next.next;
				next = next.next;
			} else {
				next = next.next;
				cur = cur.next;
			}
		}
		head = temp.next;
		return head;
	}
	
	public static void main(String[] args){
		RemoveLinkedListElements test = new RemoveLinkedListElements();
		int[] nums = {3};
		ListNodeFunction node = new ListNodeFunction();
		ListNode head = node.arrayToList(nums);
		node.display(head);	
		
		ListNode newlist = test.removeElements2(head, 3);
		node.display(newlist);
	} 

}
