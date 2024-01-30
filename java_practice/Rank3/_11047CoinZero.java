import java.util.*;
import java.io.*;

public class _11047CoinZero {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().trim().split(" ");
        int n = Integer.parseInt(info[0]);
        int k = Integer.parseInt(info[1]);

        Stack<Integer> list = new Stack<>();
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x > k) break;

            list.push(x);
        }

        int cnt = 0;
        while(k > 0) {
            int coin = list.pop();
            cnt += k / coin;
            k %= coin;
        }

        System.out.println(cnt);
    }
}
