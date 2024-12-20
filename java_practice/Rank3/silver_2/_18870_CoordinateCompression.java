package silver_2;

import java.io.*;
import java.util.*;

public class _18870_CoordinateCompression {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        int[] temp = new int[n];
        String numStr = br.readLine();
        String[] numSplit = numStr.split(" ");
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(numSplit[i]);
            temp[i] = Integer.parseInt(numSplit[i]);
        }

        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();
        int x = 0;
        for(int t : temp) {
            if(!map.containsKey(t)) {
                map.put(t, x++);
            }
        }

        for(int i=0; i<n; i++) {
            temp[i] = map.get(nums[i]);
            bw.write(temp[i] + " ");
        }

        br.close();
        bw.close();
    }
}
