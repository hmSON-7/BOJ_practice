package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class _4358_HardwoodSpecies {
    static HashMap<String, Integer> map = new HashMap<>();
    static int n = 0;
    public static void main(String[] args) throws IOException {
        read();
        solve();
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while((str = br.readLine()) != null && !str.isEmpty()) {
            map.put(str, map.getOrDefault(str, 0) + 1);
            n++;
        }
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        String[] keys = map.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        for(String wood : keys) {
            sb.append(wood).append(" ").append(String.format("%.4f", (double)map.get(wood) / n * 100)).append("\n");
        }
        System.out.println(sb);
    }
}
