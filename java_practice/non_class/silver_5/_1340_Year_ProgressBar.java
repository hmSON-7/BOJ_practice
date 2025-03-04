package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

enum MONTH {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY,
    AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
}

public class _1340_Year_ProgressBar {
    static int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ,:");
        String monthStr = st.nextToken();
        int month = MONTH.valueOf(monthStr.toUpperCase()).ordinal() + 1;
        int day = Integer.parseInt(st.nextToken());
        int year = Integer.parseInt(st.nextToken());
        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        int totalDays = 365;
        if(year%400 == 0 || (year%4 == 0 && year%100 != 0)) {
            months[1]++;
            totalDays++;
        }
        int totalMinutes = totalDays * 24 * 60;
        int elapsed = 0;
        for(int i=0; i<month-1; i++) {
            elapsed += months[i];
        }
        elapsed += (day - 1);
        elapsed = (elapsed * 24 * 60) + (hour * 60) + min;
        double remainder = (double)elapsed / totalMinutes;
        System.out.println(remainder * 100);
    }
}
