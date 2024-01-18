import java.io.*;

public class _18111MineCraft {
    public static void main(String[] args) throws IOException{
        // 선언 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] info = br.readLine().trim().split(" ");
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);
        int inv = Integer.parseInt(info[2]);

        int[][] map = new int[n][m];
        int max = 0, min = 256;
        for(int i=0; i<n; i++) {
            String[] height = br.readLine().trim().split(" ");
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(height[j]);
                if(map[i][j] > max) max = map[i][j];
                else if(map[i][j] < min) min = map[i][j];
            }
        }

        // 알고리즘 시작
        int h = max; boolean pos = true;
        int resSec = Integer.MAX_VALUE, resHeight = max;
        while(h >= min) {
            int sec = 0, curInv = inv;

            // 탐색
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(map[i][j] > h) {
                        sec += (map[i][j] - h) * 2;
                        curInv += map[i][j] - h;
                    } else if(map[i][j] < h) {
                        sec += h - map[i][j];
                        curInv -= h - map[i][j];
                    }
                }
            }

            if(curInv >= 0 && sec < resSec) {
                resSec = sec; resHeight = h;
            }

            h--;
        }

        sb.append(resSec).append(" ").append(resHeight);
        System.out.println(sb.toString());
    }
}
