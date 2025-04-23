package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _1339_WordMathematics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            String s = br.readLine();
            arr[i] = s;
            int x = 1;
            for(int j=s.length()-1; j>=0; j--) {
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + x);
                x *= 10;
            }
        }
        List<Character> keys = new ArrayList<>(map.keySet());
        keys.sort((a, b) -> map.get(b) - map.get(a));
        int sum = 0;
        for(int i=0; i<n; i++) {
            String s = arr[i];
            int curr = 0;
            for(int j=0; j<s.length(); j++) {
                curr *= 10;
                char c = s.charAt(j);
                curr += 9 - keys.indexOf(c);
            }
            sum += curr;
        }
        System.out.println(sum);
    }
}
