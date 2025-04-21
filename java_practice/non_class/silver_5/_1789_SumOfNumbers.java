package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1789_SumOfNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int x = 1;
        while(true) {
            n -= x;
            if(n <= x) break;
            x++;
        }
        System.out.println(x);
    }
}
