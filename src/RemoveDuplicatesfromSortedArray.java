/**
 * @Author Lichee
 * @Date 2020/9/11 11:33
 * @Version 1.0
 * <p>
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/727/
 * Remove Duplicates from Sorted Array Solution
 */
public class RemoveDuplicatesfromSortedArray {

    public static void main(String args[]) {
        int[] nums = {1,1,2};
        int result = removeDuplicates(nums);
        System.out.println(result);
//        int[] newNums = arrayDecOne(nums, 2);
    }

    public static int removeDuplicates(int[] nums) {
        int count = 1;
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            boolean findIt = false;
            int currentNum = nums[i];
            for (int j = 0; j < i; j++) {
                int prevNum = nums[j];
                if (currentNum == prevNum) {
                    findIt = true;
                    // 从数组中删除重复的值
                    for (int k=i+1;k<length;k++){
                        nums[k-1] = nums[k];
                    }
                    length--;
                    i--; // Line33关键！从数组中把index=i的值覆盖掉之后，应该把i位置的数再过一遍，因为不是原来那个数了（而是原来i+1w位置的数）
                    break;
                }
            }
            if (!findIt) {
                count++;
            }
        }
        for (int i=0;i<length;i++){
            System.out.println(nums[i]);
        }
        return count;
    }
}
