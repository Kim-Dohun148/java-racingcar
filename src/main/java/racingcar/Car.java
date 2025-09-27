package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

class Car implements Move {
    private static final int MOVING_FORWARD = 4;
    private static final int START = 0;
    private static final int END = 9;
    private static final int MAX_LENGTH = 5;

    public String[] names;
    public int[] moveCount;

    private void getMove() {
        moveCount = new int[names.length];
    }

    public void move() {
        for (int i = 0; i < names.length; i++) {
            int random = Randoms.pickNumberInRange(START, END);
            if (random >= MOVING_FORWARD) {
                moveCount[i] += 1;
            }
        }
    }

    public void getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String string = Console.readLine();
        names = string.split(",");
        String name;

        for (int i = 0; i < names.length; i++) {
            name = names[i];
            if (name.length() > MAX_LENGTH) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
        getMove();
    }
}
