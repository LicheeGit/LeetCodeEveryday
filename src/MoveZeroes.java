/**
 * @Author Lichee
 * @Date 2020/9/14 17:34
 * @Version 1.0
 *
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/
 * Move Zeroes
 */
public class MoveZeroes {
    public static void main(String args[]){
        int[] nums = {0,1,0,3,0,11,12,0,0};
        moveZeroes(nums);
        for (int num:nums){
            System.out.println(num);
        }
    }

    // 空间效率应该是常数，原地操作，不能复制数组，使用尽量少的步骤
    public static void moveZeroes(int[] nums) {
        int count=0; // AKA: steps need to move forward.
        for(int i=0;i+count<nums.length;i++){
            while ((i+count)<nums.length&&nums[i+count]==0){
                count++;
            }
            if((i+count)==nums.length) break;
            if(count!=0&& nums[i+count]!=0){
                nums[i]=nums[i+count];
            }
        }
        for(int i=nums.length-count;i<nums.length;i++){
            nums[i]=0;
        }
    }
}
