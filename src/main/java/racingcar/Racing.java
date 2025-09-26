package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Racing {
    private int round;
    private String[] players;
    private int[] playersMoveCount;

    private void getData(String[] names) {
        players = names.clone();
        playersMoveCount = new int[players.length];
    }

    public void getRound() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String input = Console.readLine();
        round = Integer.parseInt(input);

        if (round < 0) {
            throw new IllegalArgumentException("시도 횟수는 음수일 수 없습니다.");
        }
    }

    public void display() {
        for (int i = 0; i < players.length; i++) {
            System.out.printf("%s : ", players[i]);
            System.out.printf("%s", "-".repeat(playersMoveCount[i]));
        }
        System.out.println();
    }

    public void end() {
        ArrayList<String> Winner = new ArrayList<String>();
        int max = playersMoveCount[0];

        for (int i = 0; i < players.length; i++) {
            for (int j = i + 1; j < players.length; j++) {
                if (max <= playersMoveCount[j]) {
                    max = playersMoveCount[j];
                }
            }
        }
        // 우승자 리스트 추가
        for (int i = 0; i < players.length; i++) {
            if (playersMoveCount[i] == max) {
                Winner.add(players[i]);
            }
        }
        System.out.print("최종 우승자 : ");
        if (Winner.size() > 1) {
            String Winners = String.join(", ", Winner);
            System.out.print(Winners);
        }
        else {
            System.out.print(Winner.get(0));
        }

    }

    public void start(Car Players) {
        get_round();
        Players.get_Players_Move();

        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            Players.move();
            display(Players);
        }
        End(Players);
    }
}
