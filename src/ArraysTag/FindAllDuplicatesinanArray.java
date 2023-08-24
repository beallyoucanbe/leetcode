package ArraysTag;
/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 Find all the elements that appear twice in this array.
 Could you do it without extra space and in O(n) runtime?
 Example:
 Input:
 [4,3,2,7,8,2,3,1]
 Output:
 [2,3]
 */
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by zhaosy-c on 2017/8/19.
 * 这道题的题目是找到重复的数字而已，并没有要求将数字放在正确的位置上，所以只需要去判断就可以了。
 */
public class FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int num: nums){
            int index = Math.abs(num) - 1;
            if(nums[index] < 0)
                res.add(Math.abs(num));
            else
                nums[index] = -nums[index];
        }
//        int i = 0;
//        while (i < nums.length){
//            if(nums[i] != i + 1){
//                int temp = nums[i];
//                if(temp != nums[temp - 1]){
//                    nums[i] = nums[temp - 1];
//                    nums[temp - 1] = temp;
//                }
//                else
//                    i++;
//            }
//            else
//                i++;
//        }
//
//        for(int j = 0; j < nums.length; j++)
//            if(nums[j] != j + 1) {
//                res.add(nums[j]);
//            }
        return res;
    }


    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i =0; i < nums.length; i++) {

            while (nums[i] != i + 1){
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }

        System.out.println(Arrays.toString(nums));
        return res;
    }

    public static void main(String[] args) {
        FindAllDuplicatesinanArray test = new FindAllDuplicatesinanArray();
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> res = new ArrayList<>();
        res = test.findDuplicates2(nums);
        System.out.println(res);
    }

}
