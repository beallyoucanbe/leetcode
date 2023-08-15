package LinkedList;

/**
 * 这时要删除掉所有重复出现过的元素，只保留只出现过一次的元素
 * 看了题目知道，题目要求链表为升序排列的，故只需要考虑相邻的几个元素即可。
 * 1 在链表题中，灵活地运用虚拟表头会减少很多工作量 
 * 2 链表题往往在收尾处要多判断一下，防止corner case
 */

public class RemoveDuplicates2 {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.getNext() == null)
			return head;
		//构造一个新的虚拟头结点，。处理方便，防止会有删除第一个即表头的可能
		ListNode newhead = new ListNode(Integer.MIN_VALUE);
		newhead.setNext(head);

		ListNode pre = newhead;
		ListNode cur = pre.getNext();
		ListNode next = cur.getNext();
		
		boolean flag = false; //标志位,判断是否有重复
		while(next != null){		
			if(cur.getVal() != next.getVal()){
				if(flag){ //如果有重复的，就跳过
					pre.setNext(next);
					flag = false; //回复flag
				}else
					pre = cur;
				cur = next;
				next = next.getNext();
			}
			else if(cur.getVal() == next.getVal()){
				flag =true;
				next = next.getNext();
			}
		}
		//扫尾工作，针对例如{1， 1}的情况再判断一次
//		if(flag)
//			pre.next = next;
		return newhead.getNext();
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
