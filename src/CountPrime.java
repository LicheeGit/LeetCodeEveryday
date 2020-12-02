import java.util.ArrayList;

/**
 * @Author Lichee
 * @Date 2020/9/21 11:14
 * @Version 1.0
 * <p>
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/744/
 * Count Primes
 */
public class CountPrime {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(countPrimes(n));
        /*ArrayList<Integer> sint = new ArrayList<Integer>();
        sint.add(0);
        sint.add(2);
        sint.add(-2);
        int cint = 1;
        int dint = -1;
        for (int i = 0; i+1 <= sint.size(); i++) {
            if(sint.get(i)<cint && sint.get((i+1)%sint.size())>cint){
                sint.add((i+1)%sint.size(),cint);
                System.out.println(sint.size());
            }
        }
        for (int i = 0; i+1 <= sint.size(); i++) {
            if(sint.get(i)<dint && sint.get((i+1)%sint.size())>dint){
                sint.add((i+1)%sint.size(),dint);
                System.out.println(sint.size());
            }
        }
        for (int i:sint){
            System.out.println(i);
        }*/
    }

    public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            System.out.printf("i=%d\n", i);
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
                System.out.printf("j=%d\n", j);
            }
        }
        // i=2 j=4 j=6 j=8
        // i=3 j=9
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}
