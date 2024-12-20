package silver_5;

import java.io.*;
import java.util.*;

public class _11723_Set {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20
        };

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String[] info = br.readLine().trim().split(" ");
            switch(info[0]) {
                case "add":
                    set.add(Integer.parseInt(info[1]));
                    break;
                case "remove":
                    set.remove(Integer.parseInt(info[1]));
                    break;
                case "check":
                    if(set.contains(Integer.parseInt(info[1]))) {
                        sb.append(1).append("\n");
                    } else sb.append(0).append("\n");
                    break;
                case "toggle":
                    if(set.contains(Integer.parseInt(info[1]))) {
                        set.remove(Integer.parseInt(info[1]));
                    } else set.add(Integer.parseInt(info[1]));
                    break;
                case "all":
                    for(int num : nums) {
                        if(!set.contains(num)) {
                            set.add(num);
                        }
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }

        String str = sb.toString();
        System.out.println(str);
    }
}
