package silver_4;

import java.io.*;
import java.util.*;

public class _1764_Rando {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nums = br.readLine().split(" ");
        int nevHear = Integer.parseInt(nums[0]);
        int nevSee = Integer.parseInt(nums[1]);

        String[] nevHearName = new String[nevHear];
        String[] nevSeeName = new String[nevSee];
        for(int i=0; i<nevHear; i++) {
            nevHearName[i] = br.readLine();
        }
        Arrays.sort(nevHearName);
        for(int i=0; i<nevSee; i++) {
            nevSeeName[i] = br.readLine();
        }
        Arrays.sort(nevSeeName);

        int x = 0, y = 0, cnt = 0;
        ArrayList<String> nev = new ArrayList<>();
        while(x < nevHearName.length && y < nevSeeName.length) {
            int resultCmp = nevHearName[x].compareTo(nevSeeName[y]);
            if(resultCmp == 0) {
                cnt++;
                nev.add(nevSeeName[y]);
                x++; y++;
            } else if(resultCmp < 0) {
                x++;
            } else {
                y++;
            }
        }
        bw.write(Integer.toString(cnt));
        bw.write("\n");
        for(int i=0; i<nev.size(); i++) {
            bw.write(nev.get(i));
            bw.write("\n");
        }

        br.close();
        bw.close();
    }
}
