package Rank5.gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _1644_SumOfConsecutivePrimeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] isPrime = prime(n);
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            if(isPrime[i]) list.add(i);
        }
        int left = 0, right = 0, sum = 0, cnt = 0;
        while(right < list.size()) {
            sum += list.get(right++);
            if(sum == n) cnt++;
            while(sum > n) {
                sum -= list.get(left++);
                if(sum == n) cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static boolean[] prime(int max) {
        boolean[] isPrime = new boolean[max+1];
        for(int i=2; i<=max; i++) isPrime[i] = true;
        for(int i=2; i*i<=max; i++) {
            if(!isPrime[i]) continue;
            for(int j=i*i; j<=max; j+=i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }
}
