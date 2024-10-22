import java.io.*;
import java.util.Arrays;

public class _2805_EKO {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().trim().split(" ");
        int cnt = Integer.parseInt(info[0]);
        long want = Long.parseLong(info[1]);

        String[] treesInfo = br.readLine().trim().split(" ");
        long[] trees = Arrays.stream(treesInfo).mapToLong(Long::parseLong).toArray();
        Arrays.sort(trees);
        long top = trees[cnt-1]; long bot = 0;
        long middle = top / 2;

        while(top >= bot) {
            long sum = 0;
            for(long tree : trees) {
                sum += (int) Math.max(tree - middle, 0);
            }

            if(sum > want) {
                bot = middle + 1;
            } else if(sum < want) {
                top = middle - 1;
            } else break;

            middle = (bot + top) / 2;
        }

        System.out.println(middle);
    }
}
