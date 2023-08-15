package LinkedList;

public class ListNodeFunction {

	public static ListNode arrayToList(int[] nums){
		if(nums.length == 0)
			return null;
		ListNode head = new ListNode(nums[0]);
		ListNode tail = head;
		for(int i = 1; i < nums.length; i++){
			tail.setNext(new ListNode(nums[i]));
			tail = tail.getNext();
		}
		return head;
	}

	public static void display(ListNode head) {
		while (head != null) {
			if (head.getNext() != null)
				System.out.print(head.getVal() + "->");
			else
				System.out.print(head.getVal());
			head = head.getNext();
		}
		System.out.println();
	}

}
