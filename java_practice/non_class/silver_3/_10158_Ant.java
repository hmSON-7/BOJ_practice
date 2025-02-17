package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10158_Ant {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        if((p+t) / w % 2 == 0) {
            p = (p + t) % w;
        } else {
            p = w - ((p + t) % w);
        }
        if((q+t) / h % 2 == 0) {
            q = (q + t) % h;
        } else {
            q = h - ((q + t) % h);
        }
        System.out.println(p + " " + q);
    }
}
