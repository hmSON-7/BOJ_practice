package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _6588_GoldbachConjecture {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        String str;
        while(!(str = br.readLine()).equals("0")) {
            list.add(Integer.parseInt(str));
        }
        int max = Collections.max(list);
        boolean[] isPrime = prime(max);
        for(int x : list) {
            boolean flag = false;
            for(int i=2; i<=x; i++) {
                if(isPrime[i] && isPrime[x-i]) {
                    flag = true;
                    sb.append(x).append(" = ").append(i).append(" + ").append(x-i).append("\n");
                    break;
                }
            }
            if(!flag) sb.append("Goldbach's conjecture is wrong.\n");
        }
        System.out.println(sb);
    }

    public static boolean[] prime(int max) {
        boolean[] isPrime = new boolean[max+1];
        for(int i=2; i<=max; i++) isPrime[i] = true;
        for(int i=2; i*i<=max; i++) {
            if(!isPrime[i]) continue;
            for(int j=i*i; j<max; j+=i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }
}
