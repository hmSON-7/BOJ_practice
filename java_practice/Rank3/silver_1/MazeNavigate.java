package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Location {
    private int y, x, dist;

    public Location(int y, int x, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getDist() {
        return dist;
    }
}

public class MazeNavigate {
    static int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
    static Queue<Location> q = new LinkedList<>();
    static boolean[][] map;

    static int y, x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().trim().split(" ");
        y = Integer.parseInt(info[0]);
        x = Integer.parseInt(info[1]);
        map = new boolean[y][x];
        for(int i=0; i<y; i++) {
            String[] line = br.readLine().trim().split("");
            for(int j=0; j<x; j++) {
                map[i][j] = line[j].equals("1");
            }
        }
        int res = bfs();
        System.out.println(res);
    }

    static int bfs() {
        q.add(new Location(0, 0, 1));
        map[0][0] = false;
        while(!q.isEmpty()) {
            Location loc = q.poll();
            if(loc.getY() == y-1 && loc.getX() == x-1) {
                return loc.getDist();
            }

            for(int[] dir : directions) {
                int newY = loc.getY() + dir[0];
                int newX = loc.getX() + dir[1];
                if(newX < 0 || newY < 0 || newX >= x || newY >= y || !map[newY][newX]) {
                    continue;
                }
                q.add(new Location(newY, newX, loc.getDist() + 1));
                map[newY][newX] = false;
            }
        }
        return 0;
    }
}
