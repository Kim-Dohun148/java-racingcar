package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Racing {
    public int get_round() {
        // 시도 횟수 입력
        System.out.println("시도할 횟수는 몇회인가요?");
        String input = Console.readLine();
        int round = Integer.parseInt(input);

        // 입력 에외 처리
        if (round < 0) {
            throw new IllegalArgumentException("시도할 횟수는 음수일 수 없습니다.");
        }
        return round;
    }

    public void display(String[] Players) {
        for (int i = 0; i < Players.length; i++) {
            System.out.printf("%s : %s", Players[i], "-".repeat(2));
        }
    }

    /*public void Start() {
        int round = get_round();

        for (int i = 0; i < round; i++) {
            //display();
            //End();
        }
    }*/



}
