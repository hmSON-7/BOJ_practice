package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2166_DimensionOfPolygon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] p = new int[n][2];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p[i][0] = Integer.parseInt(st.nextToken());
            p[i][1] = Integer.parseInt(st.nextToken());
        }
        long sum1 = 0, sum2 = 0;
        for(int i=0; i<n; i++) {
            sum1 += (long)p[i][0] * p[(i+1)%n][1];
            sum2 += (long)p[i][1] * p[(i+1)%n][0];
        }
        double dem = Math.abs(sum1 - sum2) / 2.0;
        System.out.printf("%.1f%n", dem);
    }
}
