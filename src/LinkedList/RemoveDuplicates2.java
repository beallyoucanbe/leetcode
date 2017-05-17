package LinkedList;

/*
 * ��ʱҪɾ���������ظ����ֹ���Ԫ�أ�ֻ����ֻ���ֹ�һ�ε�Ԫ��
 * ������Ŀ֪������ĿҪ������Ϊ�������еģ���ֻ��Ҫ�������ڵļ���Ԫ�ؼ��ɡ�
 * 1 ���������У��������������ͷ����ٺܶ๤���� 
 * 2 ��������������β��Ҫ���ж�һ�£���ֹcorner case
 */

public class RemoveDuplicates2 {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		//����һ���µ�����ͷ��㣬�������㣬��ֹ����ɾ����һ������ͷ�Ŀ���
		ListNode newhead = new ListNode(Integer.MIN_VALUE);
		newhead.next = head;

		ListNode pre = newhead;
		ListNode cur = pre.next;
		ListNode next = cur.next;
		
		boolean flag = false; //��־λ,�ж��Ƿ����ظ�
		while(next != null){		
			if(cur.val != next.val){
				if(flag){ //������ظ��ģ�������
					pre.next = next;
					flag = false; //�ظ�flag
				}else
					pre = cur;
				cur = next;
				next = next.next;
			}
			else if(cur.val == next.val){
				flag =true;
				next = next.next;
			}
		}
		//ɨβ�������������{1�� 1}��������ж�һ��
//		if(flag)
//			pre.next = next;
		return newhead.next;
	}

	public static void main(String[] args) {
		RemoveDuplicates2 test = new RemoveDuplicates2();
		int[] nums = {1,2,3,3,4,5,5,5,6,6,6,6,7,7,7,7,7,8};
		ListNodeFunction node = new ListNodeFunction();
		ListNode head = node.arrayToList(nums);
		node.display(head);

		ListNode newlist = test.deleteDuplicates(head);
		node.display(newlist);
	}

}
