/**
 * @Author Lichee
 * @Date 2020/9/16 11:31
 * @Version 1.0
 * <p>
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/770/
 * Rotate Image
 */
public class RotateImage {
    public static void main(String args[]) {
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        // Output: [[7,4,1],[8,5,2],[9,6,3]]
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        // Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
//        int[][] matrix = {{4,8},{3,6}};
        rotate(matrix);

    }

    public static void rotate(int[][] matrix) {
        int order = matrix.length; // 阶数
        int floor = 0; // 层数
        while (order > 1) {
            int step = order - 1; // 往前走的步数
            int last = matrix.length-floor-1;
            int[] tempArray = new int[step];
            // 暂存第一列的数字 (3,0)(2,0)(1,0)
            for (int i = floor; i < last; i++) {
                tempArray[i-floor] = matrix[i][floor];
            }
            // 将最后一行的数字往前移step步（到第一列上）
            for (int i = floor; i <= last; i++) {
                matrix[i][floor] = matrix[last][i];
            }
            // 将最后一列的数字移到最后一行上
            for (int i = floor; i < last; i++) {
                matrix[last][last+floor-i] = matrix[i][last];
            }
            // 将第一行的数字移到最后一列上
            for (int i = floor+1; i < last; i++) {
                matrix[i][last] = matrix[floor][i];
            }
            // 将temp的数放到第一行上
            for (int j : tempArray) {
//                System.out.println(j);
                matrix[floor][last--] = j;
            }
            floor++;
            order -= 2;
        }
    }
}
