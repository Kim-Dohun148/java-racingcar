package racingcar;

import camp.nextstep.edu.missionutils.Console;


public class Racing extends Car {
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

    public void display(Car Players) {
        for (int i = 0; i < Players.Car_Names.length; i++) {
            System.out.printf("%s : %s", Players.Car_Names[i], "-".repeat(Players.Move_count[i]));
        }
    }

    public void End(Car Players) {
        String[] Winner = new String[Players.Car_Names.length];
        int max = Players.Move_count[0];

        for (int i = 0; i < Players.Car_Names.length; i++) {
            for (int j = i + 1; j < Players.Car_Names.length; j++) {
                if (Players.Move_count[i] >= Players.Move_count[j]) {
                    max = Players.Move_count[i];
                }
            }
        }
        for (int i = 0; i < Players.Car_Names.length; i++) {
            if (Players.Move_count[i] == max) {
                Winner[i] = Players.Car_Names[i];
                }
            }
        }


    }



}
