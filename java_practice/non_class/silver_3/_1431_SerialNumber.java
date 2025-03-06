package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _1431_SerialNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PriorityQueue<Word> q = new PriorityQueue<>((a, b) -> a.getStr().length() != b.getStr().length()
                ? Integer.compare(a.getStr().length(), b.getStr().length()) : a.getSum() != b.getSum()
                ? Integer.compare(a.getSum(), b.getSum()) : a.getStr().compareTo(b.getStr()));
        while(t --> 0) {
            q.add(new Word(br.readLine()));
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            sb.append(q.poll().getStr()).append("\n");
        }
        System.out.println(sb);
    }
}

class Word {
    private final String str;
    private int sum;

    public Word(String str) {
        this.str = str;
        sum = 0;
        calcSum();
    }

    public String getStr() {
        return str;
    }

    public int getSum() {
        return sum;
    }

    public void calcSum() {
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9') {
                sum += c - '0';
            }
        }
    }
}