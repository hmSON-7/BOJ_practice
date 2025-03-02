package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class _1235_StudentID {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), cnt = 1;
        String[] arr = new String[n];
        for(int i=0; i<n; i++) {
            arr[i] = br.readLine();
        }
        while(cnt < arr[0].length()) {
            HashSet<String> set = new HashSet<>();
            for(int i=0; i<arr.length; i++) {
                String str = arr[i].substring(arr[i].length()-cnt);
                if(set.contains(str)) break;
                set.add(str);
            }
            if(set.size() == arr.length) break;
            cnt++;
        }
        System.out.println(cnt);
    }
}
