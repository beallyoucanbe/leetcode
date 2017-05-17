package LinkedList;
/*
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * ���ж��л�����ķ���ȥ������Ȱ�����һ������ӵ���һ������Ľ�β����Ȼ���ж��������Ļ�����ʼλ��
 */
public class IntersectionofTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null)
			return null;
		ListNode tailA = headA;
		while(tailA.next != null)   //�ҵ�����A��β�ڵ�
			tailA = tailA.next;
		//System.out.println(tailA);
		tailA.next = headB;  // ������B�ӵ�A�ĺ��� , ����һ���л�����
		
		ListNode slow = headA, fast = headA;  //������������ָ��, �ж��Ƿ���н���
		do{
			if(fast.next == null || fast.next.next == null){
				//System.out.println("û�н���");
				tailA.next = null;
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
		}while(slow != fast); ///����ָ���������Ȼ�󽫿�ָ���ƶ���A�ı�ͷ		
		fast = headA;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		tailA.next = null;
		//System.out.println("have intersection  " + slow);
		return slow;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntersectionofTwoLinkedLists test = new IntersectionofTwoLinkedLists();
		int[] nums1 = { 1,3,5,7,9,11,13,15,17,19,21};
		int[] nums2 = {2};
		ListNodeFunction node = new ListNodeFunction();
		ListNode headA = node.arrayToList(nums1);
		ListNode headB = node.arrayToList(nums2);
		ListNode newlist = test.getIntersectionNode(headA, headB);
	}
}
