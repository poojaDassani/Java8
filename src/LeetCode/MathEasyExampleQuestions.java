package LeetCode;

public class MathEasyExampleQuestions {
    public static void main(String[] args) {
        int n = 27;

        //Count Primes
        System.out.println(countPrimes(n));

        // Power of three
        System.out.println(isPowerOfThree(n));
    }

    // One way
    public static int countPrimes(int n) {
        int prime = 0;
        for (int i = 2; i < n ; i++) {
            for (int j = 2; j < n ; j++) {
                if(i%j==0) {
                    if (i != j)
                        break;
                    else
                        prime++;
                }
            }
        }
        return prime;
    }

    // Second Way
    public static int countPrime(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++) {
            primes[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (primes[i]) {
                for (int j = i * i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                count++;
            }
        }
        return count;
    }


    public static boolean isPowerOfThree(int n) {
        for (int i = 0; i * i <= n ; i++) {

        }
        return false;
    }
}
