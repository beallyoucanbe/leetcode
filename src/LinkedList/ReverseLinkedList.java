package LinkedList;

/*
 * ��һ��������ת
 * �õݹ�͵������ַ�ʽ
 */

/*
 * ��ȷ��ʶ�ݹ飺�ݹ�͵�������ѭ����һ�֡��򵥵�˵���ݹ����ظ����ú�������ʵ��ѭ����
�����Ǻ�����ĳ�δ���ʵ��ѭ��������������ͨѭ���������ǣ�ѭ�������в�������ı���ͬʱ�Ǳ������ı�����
��ǰ����Ľ����Ϊ��һ��ѭ������ĳ�ʼֵ�� �ݹ�ѭ���У�����������ֹ���������ʱ��㷵����������
������ʹ�ü���������ѭ������Ȼ�ܶ�������Ƕ���ѭ����ϲ��ã���Ҫ���ݾ�������
 */
public class ReverseLinkedList {

	//���ַ���һֱ�ݹ鵽���һ����Ȼ���ٷ���
	public ListNode reverseList(ListNode head){
		if(head == null || head.next == null)
			return head;
		//get second node
		ListNode second = head.next;
		//set the first's next to be null
		head.next = null;
		ListNode rest = reverseList(second);	
		second.next = head;  //������ϲ���ʱ��second�ڵ��Ѿ����ƶ��������ĩβ����ֻ��Ҫ��head�ڵ����ĩβ���ɡ�
		return rest;
	}
	
	public ListNode reverseList2(ListNode head){
		if(head == null && head.next == null)
			return head;
		ListNode newhead = head;
		head = head.next;
		newhead.next = null;
		
		while(head != null){
			ListNode second = head.next;
			head.next = newhead;
			newhead = head;
			head = second;
		}
		return newhead;
	}

	public static void main(String[] args){
		ReverseLinkedList test = new ReverseLinkedList();
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
		ListNodeFunction node = new ListNodeFunction();
		ListNode head = node.arrayToList(nums);
		node.display(head);	
		
		ListNode newlist = test.reverseList(head);
		node.display(newlist);
	} 
}
