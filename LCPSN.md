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
  
  ------
  
- ### Contains Duplicate
  
  (2020/09/13提交)
  
  检查数组中是否有重复的元素并返回结果，常规的两重循环的方法写出来运行之后被判超时，时间效率是$O(n^2)$。解决办法是使用*Java.util*的*Arrays.sort()*函数排序后遍历检查相邻两个数是否相等，时间效率应该是$O(nlogn)$，排序操作决定了整个时间；或者使用HashSet的类型转存，然后通过set.contains()来判断，都是只需要一层循环，时间效率是$O(n)$。
  
  ------
  
- ### Rotate Array
  
  (2020/09/13提交)
  
  对数组进行循环，给定一个数组和循环的位数，比如1234567，向右循环三次变成了5671234这样。
  
  第一次使用了简单直接的循环，就是使用两层循环嵌套，一次又一次地将最后一位移到第一位并将其他的数后移一位。没有问题，代码通过了。
  
  第二次考虑了之前数据结构中遇到过的reverse方法，通过将整个数组头尾颠倒一次，再将后k个到最后一个、第一个到第k-1个分别倒置一次，就得到了想要的结果。关键在于reverse的编写也可以有不同的写法。比如可以startIndex++和endIndex--每次交换，我使用的就没有这么聪明，在循环里初始了一个i进行计数，最大是到(endIndex-startIndex)/2*（可以取到）*，然后每次startIndex+i，endIndex-i，两个索引指向的数进行交换。
  
  看了一下别人的solution，好像时间空间效率都差不多，所以这两种方法应该是够用了。
  
- ### Single Number
  (2020/09/13提交)
  这道题需要从数组中找出唯一一个仅出现一次的数，除这个数以外均出现两次。要求时间控制在线性的范围内，并且尽量别使用额外的空间。
  从讨论中找到了一个超级好的solution，记录一下：使用异或的原理
  
  - $a\bigoplus a=0 $
  
  - $a\bigoplus 0=a $
  
  - $a\bigoplus b \bigoplus a = (a\bigoplus a)\bigoplus b=0\bigoplus b=b$
  
  ```java
  class Solution {
    public int singleNumber(int[] nums) {
      int a = 0;
      for (int i : nums) {
        a ^= i;
      }
      return a;
    }
  }
  ```
  
  

## Tips:

刷题大忌：对着出错的input去修改代码，应该自己提交前考虑到所有的边界情况

在面试过程中，尽可能多的考虑可能出现的边界情况，如果有没有说明的及时提问，会是一个很好的问题。