package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _1092_Ship {
    static int crane, box;
    static List<Integer> cranes = new ArrayList<>();
    static List<Integer> boxes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        read();
        System.out.println(solve());
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        crane = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<crane; i++) {
            cranes.add(Integer.parseInt(st.nextToken()));
        }
        box = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<box; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }
    }

    private static int solve() {
        cranes.sort(Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());
        if(cranes.get(0) < boxes.get(0)) return -1;
        int[] pos = new int[crane];
        boolean[] moved = new boolean[box];
        int movedCnt = 0, min = 0;
        while(movedCnt < box) {
            for(int i=0; i<crane; i++) {
                int idx = pos[i];
                while(idx < box) {
                    int c = cranes.get(i);
                    if(moved[idx] || boxes.get(idx) > c) {
                        idx++; continue;
                    }
                    moved[idx] = true;
                    movedCnt++;
                    idx++;
                    break;
                }
                pos[i] = idx;
                if(movedCnt >= box) break;
            }
            min++;
        }
        return min;
    }
}
