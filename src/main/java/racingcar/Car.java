package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

class Car {
    private static final int MOVING_FORWARD = 4;
    private static final int start = 0;
    private static final int end = 9;

    private int Move_count;

    public void Move() {
        int random = Randoms.pickNumberInRange(start, end);
        if (random >= MOVING_FORWARD) {
            Move_count += 1;
        }
    }

    public String[] get_Car_Names() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String Car_String = Console.readLine();
        String[] Car_Names = Car_String.split(",");
        String Car_Name;

        for (int i = 0; i < Car_Names.length; i++) {
            Car_Name = Car_Names[i];
            if (Car_Name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
        return Car_Names;
    }

}
