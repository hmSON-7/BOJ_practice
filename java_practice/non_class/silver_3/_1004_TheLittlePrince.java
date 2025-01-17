package silver_3;

import java.io.*;
import java.util.StringTokenizer;

public class _1004_TheLittlePrince {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                int centerX = Integer.parseInt(st.nextToken());
                int centerY = Integer.parseInt(st.nextToken());
                int radius = Integer.parseInt(st.nextToken());

                boolean checkStart = checkDistance(startX, startY, centerX, centerY, radius);
                boolean checkEnd = checkDistance(endX, endY, centerX, centerY, radius);
                if((checkStart && !checkEnd) || (!checkStart && checkEnd)) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static boolean checkDistance(int x1, int y1, int x2, int y2, int radius) {
        double dist = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
        return dist <= radius;
    }
}
