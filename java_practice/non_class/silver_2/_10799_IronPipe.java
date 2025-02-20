package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10799_IronPipe {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split("\\)", -1);
        int cnt = 0, pipe = 0;
        for(String s : line) {
            int n = s.length();
            if(n == 0) {
                cnt++; pipe--;
                continue;
            }
            pipe += n-1;
            cnt += pipe;
        }
        System.out.println(cnt - 1);
    }
}
