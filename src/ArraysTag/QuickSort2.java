package ArraysTag;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class QuickSort2 {
		
		private static  int CUTOFF = 10;
		
		public void quicksort(int[] nums){
			quicksort(nums, 0, nums.length - 1);
		}

		protected void quicksort(int[] nums, int low, int high){
			if(high - low <= CUTOFF)
				insertionSort(nums, low, high);
			else{
				// 继续分割然后排序
				int middle = (low + high) / 2;
				if(nums[low] > nums[high])
					swap(nums, low, high);
				if(nums[middle] < nums[low])
					swap(nums, low, middle);
				if(nums[high] < nums[middle])
					swap(nums, middle, high);
				swap(nums, middle, high - 1);  //把选择的支点放在倒数第二个位置
				//选择支点
				int pivot = nums[high - 1];
				//开分割
				int i, j;
				for( i = low + 1, j = high - 1; ;){
					while(nums[i] < pivot)
						i++;
					while(nums[j] >= pivot)
						j--;
					if(i >= j)
						break;
					swap(nums, i, j);
				}
				//重置支点
				swap(nums, i, high - 1);
				quicksort(nums, low, i - 1);   //对子分割递归调用
				quicksort(nums, i, high - 1);  //对子分割递归调用
			}
		}
		//如任何对象的改变数值
		public static void swap(int[] nums, int i, int j){
			int temp = 0;
			temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		
		public static  void insertionSort(int[] nums, int low, int high) {
			for (int i = 1, j; i < nums.length; i++){
				int temp = nums[i];
				for(j = i; j > 0 && nums[j - 1] > temp; j--){
					nums[j] = nums[j - 1];
				}
				nums[j] = temp;
			}
		}

		public static void main(String[] args) {
			QuickSort2 test = new QuickSort2();
			int[] nums = new int[100];
			for(int i = 0; i < nums.length; i++)
				nums[i] = ((int)(Math.random() * 100));
			if(null == null)
				System.out.println("true");
			String abc = "adf";
			Map<String, String> map = new HashMap<String, String>();
			map.put("1", abc);
			System.out.println("排序前" + Arrays.toString(nums));
			test.quicksort(nums);
			System.out.println("排序后" + Arrays.toString(nums));
			
			
		}

	}


