package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Racing {
    private int round;
    private Car players;

    public Racing(Car car) {
        players = car;
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
        for (int i = 0; i < players.names.length; i++) {
            System.out.printf("%s : ", players.names[i]);
            System.out.printf("%s", "-".repeat(players.moveCount[i]));
            System.out.println();
        }
        System.out.println();
    }

    public void end() {
        ArrayList<String> Winner = new ArrayList<String>();
        int max = players.moveCount[0];

        for (int i = 0; i < players.names.length; i++) {
            for (int j = i + 1; j < players.names.length; j++) {
                if (max <= players.moveCount[j]) {
                    max = players.moveCount[j];
                }
            }
        }
        // 우승자 리스트 추가
        for (int i = 0; i < players.names.length; i++) {
            if (players.moveCount[i] == max) {
                Winner.add(players.names[i]);
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

    public void start() {
        getRound();

        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            players.move();
            display();
        }
        end();
    }
}
