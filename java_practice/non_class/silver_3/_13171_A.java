package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _13171_A {
    static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long e = Long.parseLong(br.readLine());
        System.out.println(pow(n, e));
    }

    static long pow(long n, long e) {
        if(e == 0) return 1 % MOD;
        long half = pow(n, e / 2);
        half = (half * half) % MOD;
        if (e % 2 != 0) {
            half = (half * (n % MOD)) % MOD;
        }
        return half;
    }
}
