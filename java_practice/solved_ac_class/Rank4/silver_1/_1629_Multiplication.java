package Rank4.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1629_Multiplication {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int e = Integer.parseInt(line[1]);
        int mod = Integer.parseInt(line[2]);
        System.out.println(pow(n, e, mod));
    }

    static long pow(long n, long e, int mod) {
        if(e == 0) return 1 % mod;
        long half = pow(n, e / 2, mod);
        half = (half * half) % mod;
        if (e % 2 != 0) {
            half = (half * (n % mod)) % mod;
        }
        return half;
    }
}
