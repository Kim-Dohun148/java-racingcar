package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Racing {
    private int round;
    private Car car;

    public Racing() {
        car = new Car();
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
        for (int i = 0; i < car.names.length; i++) {
            System.out.printf("%s : ", car.names[i]);
            System.out.printf("%s", "-".repeat(car.moveCount[i]));
        }
        System.out.println();
    }

    public void end() {
        ArrayList<String> Winner = new ArrayList<String>();
        int max = car.moveCount[0];

        for (int i = 0; i < car.names.length; i++) {
            for (int j = i + 1; j < car.names.length; j++) {
                if (max <= car.moveCount[j]) {
                    max = car.moveCount[j];
                }
            }
        }
        // 우승자 리스트 추가
        for (int i = 0; i < car.names.length; i++) {
            if (car.moveCount[i] == max) {
                Winner.add(car.names[i]);
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
            car.move();
            display();
        }
        end();
    }
}
