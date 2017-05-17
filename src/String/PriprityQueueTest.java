package String;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * priorityQueueĬ��ʵ��һ����С�ѣ����Ҫʵ��һ�����ԣ��򵥵����������ڶ��崫��һ��Comparatorʵ��
 * @author shuoyi.zhao
 *
 */

public class PriprityQueueTest {

	public void priorityQueueTest(int [] strs){
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new myComparator());
		for(Integer str: strs)
			heap.add(str);
		System.out.println(heap.poll());
	}
	public static void main(String[] args) {
		PriprityQueueTest test = new PriprityQueueTest();
		int[] strs = {3,4,5};
		test.priorityQueueTest(strs);
		System.out.println(Arrays.toString(strs));
	}
	class myComparator implements Comparator<Integer>{

		public int compare(Integer o1, Integer o2) {
			if(o1.compareTo(o2) < 0)
				return 1;
			else if(o1.compareTo(o2) > 0)
				return -1;
			else 
				return 0;
		}
	}
}
