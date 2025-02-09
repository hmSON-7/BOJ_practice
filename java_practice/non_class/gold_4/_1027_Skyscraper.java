package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1027_Skyscraper {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        if(n <= 3) System.out.println(n-1);
        else {
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(line[i]);
            int max = 0, cnt;
            double maxTan = 0;
            for(int i = 0; i < n; i++) {
                cnt = 0;
                for(int j=i-1; j>=0; j--) {
                    if(j == i-1) {
                        maxTan = arr[j] - arr[i];
                        cnt++; continue;
                    }
                    double tan = (double)(arr[j] - arr[i])/(double)(i-j);
                    if(tan <= maxTan) continue;
                    maxTan = tan;
                    cnt++;
                }
                for(int j=i+1; j<n; j++) {
                    if(j == i+1) {
                        maxTan = arr[j] - arr[i];
                        cnt++; continue;
                    }
                    double tan = (double)(arr[j] - arr[i])/(double)(j-i);
                    if(tan <= maxTan) continue;
                    maxTan = tan;
                    cnt++;
                }
                max = Math.max(max, cnt);
            }
            System.out.println(max);
        }
    }
}
