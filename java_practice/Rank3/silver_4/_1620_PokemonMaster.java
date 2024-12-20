package silver_4;

import java.io.*;
import java.util.*;

public class _1620_PokemonMaster {
    public static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nums = br.readLine().split(" ");
        int m = Integer.parseInt(nums[0]);
        int test = Integer.parseInt(nums[1]);

        Map<Integer, String> mapIS = new HashMap<>();
        Map<String, Integer> mapSI = new HashMap<>();
        for(int i=0; i<m; i++) {
            String monster = br.readLine();
            mapIS.put(i+1, monster);
            mapSI.put(monster, i+1);
        }

        for(int i=0; i<test; i++) {
            String t = br.readLine();

            if(isNumeric(t)) {
                bw.write(mapIS.get(Integer.parseInt(t)));
                bw.write("\n");
            } else {
                bw.write(Integer.toString(mapSI.get(t)));
                bw.write("\n");
            }
        }

        br.close();
        bw.close();
    }
}
