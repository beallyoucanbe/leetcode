package TwoPointers;

public class ListNodeFunction {

	public static ListNode arrayToList(int[] nums){
		if(nums.length == 0)
			return null;
		ListNode head = new ListNode(nums[0]);
		ListNode tail = head;
		for(int i = 1; i < nums.length; i++){
			tail.next = new ListNode(nums[i]);
			tail = tail.next;
		}
		return head;
	}

	public static void display(ListNode head) {
		while (head != null) {
			if (head.next != null)
				System.out.print(head.val + "->");
			else
				System.out.print(head.val);
			head = head.next;
		}
		System.out.println();
	}

}
