import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Lichee
 * @Date 2020/9/13 18:11
 * @Version 1.0
 *
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/
 * Contains Duplicate
 */
public class ContainsDuplicate {
    public static void main(String args[]){
        int[] nums = {1,2,3,3};
        boolean ContainsDuplicate = containsDuplicate2(nums);
        if(ContainsDuplicate){
            System.out.println("true.");
        }
    }

    public static boolean containsDuplicate(int[] nums) {
        boolean ContainsDuplicate = false;
        for(int i=0;i<nums.length;i++){
            for (int j=i+1;j< nums.length;j++){
                if(nums[i]==nums[j]){
                    ContainsDuplicate=true;
                    return ContainsDuplicate;
                }
            }
        }
        return ContainsDuplicate;
    } // 超时了。

    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for(int x:nums){
            if(set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }

    public static boolean containsDuplicate3(int[] nums){
        Arrays.sort(nums);
        for (int i=0;i< nums.length;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
