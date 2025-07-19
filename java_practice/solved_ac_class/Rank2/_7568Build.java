package Rank2;

import java.io.*;

public class _7568Build {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int[][] arr = new int[t][3];
        for(int i=0; i<t; i++) {
            String[] info = br.readLine().trim().split(" ");
            arr[i][0] = Integer.parseInt(info[0]);
            arr[i][1] = Integer.parseInt(info[1]);
            arr[i][2] = 1;
        }

        for(int i=0; i<t; i++) {
            for(int j=0; j<t; j++) {
                if(i == j) continue;

                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    arr[i][2]++;
                }
            }
            sb.append(arr[i][2]).append(" ");
        }

        String str = sb.toString();
        System.out.println(str);
    }
}