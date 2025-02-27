package gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1069_Home {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dist = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        double totalDist = Math.sqrt(x*x + y*y);
        if(dist <= time) System.out.println(totalDist);
        else {
            if(totalDist <= dist) {
                double jumpTime = Math.min(time * 2, time + (dist - totalDist));
                System.out.println(Math.min(jumpTime, totalDist));
            } else {
                int jumpCnt = (int)(totalDist/dist);
                System.out.println(Math.min(time * (jumpCnt + 1), time * jumpCnt + (totalDist - (dist * jumpCnt))));
            }
        }
    }
}
