package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2960_SieveOfEratosthenes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(prime(n, k));
    }

    public static int prime(int n, int k) {
        int cnt = 0;
        boolean[] isPrime = new boolean[n+1];
        for(int i=2; i<=n; i++) isPrime[i] = true;
        for(int i=2; i<=n; i++) {
            if(!isPrime[i]) continue;
            for(int j=i; j<=n; j+=i) {
                if(isPrime[j]) {
                    isPrime[j] = false;
                    cnt++;
                    if(cnt == k) return j;
                }
            }
        }
        return -1;
    }
}
