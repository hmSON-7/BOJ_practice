package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2448_AsteriskPattern_11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] stars = new String[n];
        stars[0] = "  *  ";
        stars[1] = " * * ";
        stars[2] = "*****";
        for(int i=1; (1<<i)*3 <= n; i++) {
            build(i, stars);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(stars[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void build(int x, String[] stars) {
        int bot = (1 << x) * 3;
        int mid = bot / 2;
        for(int i=mid; i<bot; i++) {
            stars[i] = stars[i-mid] + " " + stars[i-mid];
        }
        String space = " ".repeat(mid);
        for(int i=0; i<mid; i++) {
            stars[i] = space + stars[i] + space;
        }
    }
}
