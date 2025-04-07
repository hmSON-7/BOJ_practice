package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class _20291_FileOrganization {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> map = new TreeMap<>();
        for(int i=0; i<n; i++) {
            String file = br.readLine();
            for(int j=0; j<file.length(); j++) {
                if(file.charAt(j) == '.') {
                    String extension = file.substring(j+1);
                    map.put(extension, map.getOrDefault(extension, 0) + 1);
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String key : map.keySet()) {
            sb.append(key).append(" ").append(map.get(key)).append("\n");
        }
        System.out.println(sb);
    }
}
