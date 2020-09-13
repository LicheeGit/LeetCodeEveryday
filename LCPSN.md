# LCPSN 

(LeetCode Problems Solving Notes)

- ### Remove Duplicates from Sorted Array

  (2020/09/11 提交 )

  是一道从整数数组中提取出不重复的数并计数的问题，问题本身没有什么难度，

  ```java
  class Solution {
      public int removeDuplicates(int[] nums) {
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
                      i--;
                      break;
                  }
              }
              if (!findIt) {
                  count++;
              }
          }
          // 题目要求的输出
          for (int i=0;i<length;i++){
              System.out.println(nums[i]);
          }
          return count;
      }
  }
  ```

  使用了一层for循环对数组进行遍历，对其中出现的每个数字依次，再使用一层for循环，检查在其之前是否出现过相同的数字，如果没有就直接计数，然后再看下一个；如果出现过，就把数组中这个数字之后的所有数字往前移一位（第三层for循环），覆盖掉这个重复的数。

  本题的关键点在于1、删除重复数字之后，数组的遍历长度进行变化，不变化的话对结果没有影响但是影响运行效率，2、将重复位置后面的数字前移后，最外层的遍历需要重新过一遍这个被删除位置，因为该索引的数字已经不是原来那个数了，变成了新的数。3、使用布尔值findIt标识是否重复。