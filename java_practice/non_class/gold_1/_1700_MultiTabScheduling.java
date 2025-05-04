package gold_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _1700_MultiTabScheduling {
    static int n, k;
    static int[] arr;
    static HashSet<Integer> set = new HashSet<>();;
    public static void main(String[] args) throws IOException {
        read();
        System.out.println(solve());
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static int solve() {
        int cnt = 0;
        for(int i=0; i<k; i++) {
            int plug = arr[i];
            if(set.size() < n) {
                set.add(plug);
                continue;
            }
            if(set.contains(plug)) continue;
            int target = delete(i);
            set.remove(target);
            set.add(plug);
            cnt++;
        }
        return cnt;
    }

    private static int delete(int idx) {
        int toRemove = -1;
        int farthest = -1;

        for(int device : set) {
            int nextUse = Integer.MAX_VALUE;
            for(int j=idx+1; j<k; j++) {
                if(arr[j] == device) {
                    nextUse = j;
                    break;
                }
            }
            if (nextUse > farthest) {
                farthest = nextUse;
                toRemove = device;
            }
        }
        return toRemove;
    }
}
