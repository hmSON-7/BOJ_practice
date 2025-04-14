package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13305_GasStation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dist = new int[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int minCost = Integer.MAX_VALUE;
        long sum = 0;
        for(int i=0; i<n-1; i++) {
            int cost = Integer.parseInt(st.nextToken());
            minCost = Math.min(minCost, cost);
            sum += (long)dist[i] * minCost;
        }
        System.out.println(sum);
    }
}
