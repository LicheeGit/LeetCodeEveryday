/**
 * @Author Lichee
 * @Date 2020/9/21 11:14
 * @Version 1.0
 *
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/744/
 * Count Primes
 */
public class CountPrime {
    public static void main(String[] args){
        int n=10;
        System.out.println(countPrimes(n));
    }
    public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for(int i=2;i<n;i++){
            isPrime[i]=true;
        }
        for(int i=2;i*i<n;i++){
            if(!isPrime[i]) continue;
            System.out.printf("i=%d\n",i);
            for(int j=i*i;j<n;j+=i){
                isPrime[j]=false;
                System.out.printf("j=%d\n",j);
            }
        }
        // i=2 j=4 j=6 j=8
        // i=3 j=9
        int count = 0;
        for(int i=2;i<n;i++){
            if(isPrime[i]) count++;
        }
        return count;
    }
}
