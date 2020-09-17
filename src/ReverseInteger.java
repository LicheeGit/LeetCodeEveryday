/**
 * @Author Lichee
 * @Date 2020/9/17 9:22
 * @Version 1.0
 * <p>
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/
 * Reveres Integer
 */
public class ReverseInteger {
    public static void main(String args[]) {
        int x = -2147483648;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        long result = 0;
        int temp[] = new int[32];
        int i = 0;
        boolean negetive = false;
        if (x > max || x < min) {
            return 0;
        }
        if (0 <= x && x <= 9) return x;
        if (x < 0) {
            negetive = true;
            x = 0 - x;
        }
        while (x > 0 && i < 32) { //其实这个32是没用的。。。到不了32位
            temp[i++] = x % 10;
            x /= 10;
        }
        int j = 0;
        while (j<32&&temp[j] == 0) {
            j++;
        }
        long v = 1;
        for (int k = i - 1; k >= j; k--) {
            result += temp[k] * v; // 直接越界了，下面判断的时候已经判断不到了
            // 出错原因：result得是long类型，不然直接溢出都判断不及，然后v也得是long类型，
            // 本来result long\result int 时，result依旧直接溢出，因为v溢出
            v *= 10;
            if (result > max || (0-result) < min) {
                return 0;
            }
            System.out.println(result);
        }
        if (negetive) result = 0 - result;

        return (int) result;
    }

    public static int reverse2(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        }
        return (int) res;
    }
}
