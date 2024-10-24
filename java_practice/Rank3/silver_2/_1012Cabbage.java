package silver_2;

import java.io.*;

public class _1012Cabbage {
    static int[][] dir = {
            {0, -1}, {-1, 0}, {1, 0}, {0, 1}
    };
    static int[][] map;
    static boolean[][] visit;
    static int w, h, v;

    public static void DFS(int y, int x) {
        visit[y][x] = true;

        for(int i=0; i<4; i++) {
            int now_x = x + dir[i][0];
            int now_y = y + dir[i][1];

            if(check(now_y, now_x) && !visit[now_y][now_x] && map[now_y][now_x] == 1) {
                DFS(now_y, now_x);
            }
        }
    }

    public static boolean check(int y, int x) {
        return (y < h && y >= 0 && x < w && x >= 0);
    }
    public static void main(String[] args) throws IOException{
        // 선언 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            // 밭의 넓이와 배추의 개수
            String[] info = br.readLine().trim().split(" ");
            w = Integer.parseInt(info[0]);
            h = Integer.parseInt(info[1]);
            v = Integer.parseInt(info[2]);

            // 배추의 위치 입력
            map = new int[h][w];
            visit = new boolean[h][w];
            for (int i = 0; i < v; i++) {
                String[] str = br.readLine().trim().split(" ");
                map[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = 1;
            }

            // 알고리즘
            int cnt = 0;
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(map[i][j] == 1 && !visit[i][j]) {
                        cnt++;
                        DFS(i, j);
                    }
                }
            }

            sb.append(cnt).append("\n");
        }
        String res = sb.toString();
        System.out.println(res);
    }
}