import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author Lichee
 * @Date 2020/9/14 8:50
 * @Version 1.0
 * <p>
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/
 * Intersection of Two Arrays II
 */
public class IntersectionofTwoArraysII {
    public static void main(String args[]) {
        int[] nums1 = {1, 2, 2}, nums2 = {2, 2, 4};
        int[] results = intersect2(nums1, nums2);
        for (int result : results) {
            System.out.println(result);
        }
    }

    // 抄来的答案
    // source:http://lovely-u.com/tutorial/leetcode/91.html
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1Map = new HashMap<>();
        for (int num : nums1) {
            nums1Map.put(num, nums1Map.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (nums1Map.containsKey(num) && nums1Map.get(num) != 0) {
                result.add(num);
                nums1Map.put(num, nums1Map.get(num) - 1);
            }
        }
        int[] resultArray = new int[result.size()];
        int index = 0;
        for (int item : result) {
            resultArray[index++] = item;
        }
        return resultArray;
    }

    // 上面的方法中，判断完Map里的重复出现之后先把值放到了List里，接下来才用List给Array赋值
    // 这里想要尝试跳过List那步，直接给Array赋值
    // 结果：行不通，因为Array初始时不知道数组大小应该给多少，
    // 总是要先遍历一边nums2数出有多少个，才能得到最终的数组
    // 所以这个版本中使用了两个数组，先获取一遍存进去并计数，再拿一个来得到最终数组
    public static int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1Map = new HashMap<>();
        for (int num : nums1) {
            nums1Map.put(num, nums1Map.getOrDefault(num, 0) + 1);
        }
        // 保证够存，但是比List费空间
        int[] tempArray = new int[Math.max(nums1.length, nums2.length)];
        int index = 0;
        for (int num : nums2) {
            if (nums1Map.containsKey(num) && nums1Map.get(num) != 0) {
                tempArray[index++] = num;
                nums1Map.put(num, nums1Map.get(num) - 1);
            }
        }
        int[] resultArray = new int[index];
        for (int i = 0; i < index; i++) {
            resultArray[i] = tempArray[i];
        }
        return resultArray;
    }

}
