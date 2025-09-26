package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Racing extends Car {
    private int round;

    public void getRound() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String input = Console.readLine();
        round = Integer.parseInt(input);

        if (round < 0) {
            throw new IllegalArgumentException("시도 횟수는 음수일 수 없습니다.");
        }
    }

    // 게임 진행 상황 출력 함수
    public void display(Car Players) {
        for (int i = 0; i < Players.Car_Names.length; i++) {
            System.out.printf("%s : %s\n", Players.Car_Names[i], "-".repeat(Players.Move_count[i]));
        }
        System.out.println();
    }

    // 게임 종료 및 우승자 출력 함수
    public void end(Car Players) {
        ArrayList<String> Winner = new ArrayList<String>();
        int max = Players.Move_count[0];

        // 최대 이동횟수 찾기
        for (int i = 0; i < Players.Car_Names.length; i++) {
            for (int j = i + 1; j < Players.Car_Names.length; j++) {
                if (max <= Players.Move_count[j]) {
                    max = Players.Move_count[j];
                }
            }
        }
        // 우승자 리스트 추가
        for (int i = 0; i < Players.Car_Names.length; i++) {
            if (Players.Move_count[i] == max) {
                Winner.add(Players.Car_Names[i]);
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
