package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _2468_SafetyZone {
    static int n, maxHeight = 0, minHeight = 101, cntArea = 1;
    static int[][] area;
    static int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        area = new int[n][n];
        for(int i=0; i<n; i++) {
            String[] line = br.readLine().trim().split(" ");
            for(int j=0; j<n; j++) {
                area[i][j] = Integer.parseInt(line[j]);
                maxHeight = Math.max(maxHeight, area[i][j]);
                minHeight = Math.min(minHeight, area[i][j]);
            }
        }
        for(int i=minHeight; i<maxHeight; i++) {
            search(i);
        }
        System.out.println(cntArea);
    }

    static void search(int h) {
        boolean[][] visit = new boolean[n][n];
        int cnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(area[i][j] <= h || visit[i][j]) continue;
                visit[i][j] = true;
                Queue<int []> q = new LinkedList<>();
                q.add(new int[]{i, j});
                while(!q.isEmpty()) {
                    int[] pos = q.poll();
                    for(int[] dir : direction) {
                        int newY = pos[0] + dir[0];
                        int newX = pos[1] + dir[1];
                        if(newY < 0 || newX < 0 || newY >= n || newX >= n || visit[newY][newX] || area[newY][newX] <= h)
                            continue;
                        visit[newY][newX] = true;
                        q.add(new int[]{newY, newX});
                    }
                }
                cnt++;
            }
        }
        cntArea = Math.max(cntArea, cnt);
    }
}
