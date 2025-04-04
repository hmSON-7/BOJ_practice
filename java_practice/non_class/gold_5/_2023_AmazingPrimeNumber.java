package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2023_AmazingPrimeNumber {
    static StringBuilder sb = new StringBuilder();
    static int[] nextNums = {1, 3, 7, 9};
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        if(n == 1) {
            System.out.println("2\n3\n5\n7");
            return;
        }
        bt(2, 1);
        bt(3, 1);
        bt(5, 1);
        bt(7, 1);
        System.out.println(sb);
    }

    public static void bt(int x, int len) {
        if(len == n) {
            sb.append(x).append("\n");
            return;
        }
        int curr = x * 10;
        for(int next : nextNums) {
            if(isPrime(curr + next)) bt(curr+next, len+1);
        }
    }

    public static boolean isPrime(int n) {
        for(int i=3; i*i<=n; i+=2) {
            if(n%i == 0) return false;
        }
        return true;
    }
}
