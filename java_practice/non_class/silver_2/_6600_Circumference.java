package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6600_Circumference {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String line = br.readLine();
            if(line == null || line.trim().isEmpty()) {
                break;
            }
            StringTokenizer st = new StringTokenizer(line, " ");
            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            double x2 = Double.parseDouble(st.nextToken());
            double y2 = Double.parseDouble(st.nextToken());
            double x3 = Double.parseDouble(st.nextToken());
            double y3 = Double.parseDouble(st.nextToken());
            double d = 2 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
            double centerX = ((x1 * x1 + y1 * y1) * (y2 - y3)
                    + (x2 * x2 + y2 * y2) * (y3 - y1)
                    + (x3 * x3 + y3 * y3) * (y1 - y2)) / d;
            double centerY = ((x1 * x1 + y1 * y1) * (x3 - x2)
                    + (x2 * x2 + y2 * y2) * (x1 - x3)
                    + (x3 * x3 + y3 * y3) * (x2 - x1)) / d;
            double r = Math.sqrt(Math.pow(centerX - x1, 2) + Math.pow(centerY - y1, 2));
            sb.append(Math.round(2 * r * Math.PI * 100) / 100.0).append("\n");
        }
        System.out.println(sb);
    }
}
