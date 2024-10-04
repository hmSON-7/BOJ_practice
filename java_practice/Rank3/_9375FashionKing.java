import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _9375FashionKing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] res = new int[t];
        for(int j=0; j<t; j++) {
            int kind =  Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for(int i=0; i<kind; i++) {
                String[] cloth = br.readLine().trim().split(" ");
                map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
            }

            int cases = 1;
            for(int n : map.values()) {
                cases *= n+1;
            }

            res[j] = cases - 1;
        }

        for(int x : res) {
            System.out.println(x);
        }
    }
}
