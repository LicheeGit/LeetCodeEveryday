/**
 * @Author Lichee
 * @Date 2020/9/13 15:53
 * @Version 1.0
 * <p>
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/
 * Rotate Array
 */
public class RotateArray {
    public static void main(String args[]) {
        int[] nums = {1};
        int k = 0;
        rotate2(nums, k);
    }

    public static void rotate(int[] nums, int k) {
        if (k > nums.length - 1) {
            k = k % nums.length;
        }
        while (k > 0) {
            int temp;
            temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            k--;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ", nums[i]);
        }
    }

    public static void rotate2(int[] nums, int k) {
        if (k > nums.length - 1) {
            k = k % nums.length;
        }
        if(k!=0){ // 关键，出错的地方，因为k==0时下面k-1会是负数，导致reverse里计算索引时越界
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ", nums[i]);
        }
    }

    public static void reverse(int[] nums, int startIndex, int endIndex) {
        for (int i = 0; i <= (endIndex - startIndex) / 2; i++) {
            int temp = nums[startIndex + i];
            nums[startIndex + i] = nums[endIndex - i];
            nums[endIndex - i] = temp;
        }
    }
}
