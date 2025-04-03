package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9020_GoldbachConjecture {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] isPrime = prime();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int mid = n/2;
            for(int i=mid; i>=2; i--) {
                if(isPrime[i] && isPrime[n-i]) {
                    sb.append(i).append(" ").append(n-i).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    public static boolean[] prime() {
        boolean[] isPrime = new boolean[10001];
        for(int i=2; i<=10000; i++) isPrime[i] = true;
        for(int i=2; i*i<=10000; i++) {
            if(!isPrime[i]) continue;
            for(int j=i*i; j<10000; j+=i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }
}
