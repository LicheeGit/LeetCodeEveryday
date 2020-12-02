import java.util.HashMap;
import java.util.Map;

/**
 * @Author Lichee
 * @Date 2020/12/1 21:37
 * @Version 1.0
 *
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/
 */
public class TwoSum {
    public static void main(String[] args){
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = twoSum(nums, target);
        for(int i:result){
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
