package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _15686_ChickenDelivery {
    static int n, l, minDist = Integer.MAX_VALUE, lenH = 0, lenP = 0;
    static boolean[] selected;
    static int[][] totalDist, places, houses;
    static Integer[][] sortedPlaces;
    public static void main(String[] args) throws IOException {
        read(); getDistance();
        if(lenP == l) {
            Arrays.fill(selected, true);
            minDist = calcDistance();
        } else {
            backTracking(0, 0);
        }
        System.out.println(minDist);
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        houses = new int[n*2][2];
        places = new int[13][2];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int x = Integer.parseInt(st.nextToken());
                if(x == 2) {
                    places[lenP][0] = i;
                    places[lenP][1] = j;
                    lenP++;
                }
                else if(x == 1) {
                    houses[lenH][0] = i;
                    houses[lenH][1] = j;
                    lenH++;
                }
            }
        }
        selected = new boolean[lenP];
    }

    private static void getDistance() {
        totalDist = new int[lenH][lenP];
        for(int i=0; i<lenH; i++) {
            int[] h = houses[i];
            for(int j=0; j<lenP; j++) {
                int[] p = places[j];
                totalDist[i][j] = Math.abs(h[0] - p[0]) + Math.abs(h[1] - p[1]);
            }
        }
        sortedPlaces = new Integer[lenH][lenP];
        for(int i=0; i<lenH; i++) {
            int x = i;
            for(int j=0; j<lenP; j++) sortedPlaces[i][j] = j;
            Arrays.sort(sortedPlaces[i], Comparator.comparingInt(a -> totalDist[x][a]));
        }
    }

    private static void backTracking(int cnt, int idx) {
        if(cnt == l) {
            minDist = Math.min(minDist, calcDistance());
            return;
        }
        for(int i=idx; i<=lenP - (l-cnt); i++) {
            selected[i] = true;
            backTracking(cnt+1, i+1);
            selected[i] = false;
        }
    }

    private static int calcDistance() {
        int total = 0;
        for(int i=0; i<lenH; i++) {
            for(int j : sortedPlaces[i]) {
                if (selected[j]) {
                    total += totalDist[i][j];
                    break;
                }
            }
            if(total >= minDist) break;
        }
        return total;
    }
}
