import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Lichee
 * @Date 2020/9/13 20:44
 * @Version 1.0
 *
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/
 * Single Number
 */
public class SingleNumber {
    public static void main(String args[]){
        int[] nums = {2,2,1};
        int singleNumber = singleNumber3(nums);
        System.out.println(singleNumber);
    }

    public static int singleNumber(int[] nums) {
        int singleNumber;
        Arrays.sort(nums);
        int index=0;
        while (index<nums.length&&(index+1)<nums.length&&(nums[index]-nums[index+1])==0){
            index+=2;
        }
        singleNumber = nums[index];
        return singleNumber;
    }

    public static int singleNumber2(int[] nums) {
        HashMap<Integer, Integer> hash_table = new HashMap<>();

        for (int i:nums){
            //
            hash_table.put(i, hash_table.getOrDefault(i, 0)+1);
        }
        for(int i:nums){
            if(hash_table.get(i)==1){
                return i;
            }
        }
        return 0;
    }

    // 另一种方法，2∗(a+b+c)−(a+a+b+b+c)=c

    // 异或的方法
    public static int singleNumber3(int[] nums) {
        int a=0;
        for(int i:nums){
            a ^= i;
        }
        return a;
    }
}
