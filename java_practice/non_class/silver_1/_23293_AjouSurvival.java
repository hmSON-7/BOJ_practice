package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Player {
    int currentPlace;
    HashMap<Integer, Integer> items;

    public Player(int currentPlace, HashMap<Integer, Integer> items) {
        this.currentPlace = currentPlace;
        this.items = items;
    }

    public int getPlace() {
        return currentPlace;
    }

    public void setPlace(int place) {
        currentPlace = place;
    }

    public void addItem(int place) {
        items.put(place, items.getOrDefault(place, 0) + 1);
    }

    public boolean craft(int item1, int item2) {
        boolean cheatFlag = false;
        if(items.containsKey(item1) && items.get(item1) > 0) items.put(item1, items.get(item1) - 1);
        else cheatFlag = true;
        if(items.containsKey(item2) && items.get(item2) > 0) items.put(item2, items.get(item2) - 1);
        else cheatFlag = true;
        return cheatFlag;
    }
}

public class _23293_AjouSurvival {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int logs = Integer.parseInt(st.nextToken());
        int players = Integer.parseInt(st.nextToken());
        List<Integer> caughtLogsNum = new ArrayList<>();
        Set<Integer> targets = new TreeSet<>();
        Player[] playerList = new Player[players+1];
        for (int i = 1; i <= players; i++) {
            playerList[i] = new Player(1, new HashMap<>());
        }
        for(int i=0; i<logs; i++) {
            st = new StringTokenizer(br.readLine());
            int logNum = Integer.parseInt(st.nextToken());
            int currentPlayer = Integer.parseInt(st.nextToken());
            char act = st.nextToken().charAt(0);
            switch(act) {
                case 'M':
                    playerList[currentPlayer].setPlace(Integer.parseInt(st.nextToken()));
                    break;
                case 'F':
                    int place = Integer.parseInt(st.nextToken());
                    playerList[currentPlayer].addItem(place);
                    if(place != playerList[currentPlayer].getPlace()) caughtLogsNum.add(logNum);
                    break;
                case 'C':
                    int item1 = Integer.parseInt(st.nextToken());
                    int item2 = Integer.parseInt(st.nextToken());
                    if(playerList[currentPlayer].craft(item1, item2)) caughtLogsNum.add(logNum);
                    break;
                case 'A':
                    int opponent = Integer.parseInt(st.nextToken());
                    if(playerList[currentPlayer].getPlace() != playerList[opponent].getPlace()) {
                        caughtLogsNum.add(logNum);
                        targets.add(currentPlayer);
                    }
                    break;
                default: break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(caughtLogsNum.size()).append("\n");
        if(!caughtLogsNum.isEmpty()) {
            for(int log : caughtLogsNum) sb.append(log).append(" ");
            sb.append("\n");
        }
        sb.append(targets.size()).append("\n");
        if(!targets.isEmpty()) {
            for(int t : targets) sb.append(t).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
