package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _5635_Birthday {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Birthday> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            list.add(new Birthday(name, day, month, year));
        }
        list.sort((a, b) -> {
            if (a.year != b.year)
                return Integer.compare(a.year, b.year);
            else if (a.month != b.month)
                return Integer.compare(a.month, b.month);
            else
                return Integer.compare(a.day, b.day);
        });
        System.out.println(list.get(n-1).name + "\n" + list.get(0).name);
    }
}

class Birthday {
    String name;
    int day, month, year;

    public Birthday(String name, int day, int month, int year) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }
}