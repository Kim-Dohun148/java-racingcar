package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

class Car {
    private static final int MOVING_FORWARD = 4;
    private static final int start = 0;
    private static final int end = 9;
    protected String[] Car_Names;
    protected int[] Move_count;

    // 자동차 수 만큼 int 배열 정의
    protected void get_Players_Move() { Move_count = new int[Car_Names.length]; }

    // 자동차 전진 및 정지
    protected void Move() {
        for (int i = 0; i < Car_Names.length; i++) {
            int random = Randoms.pickNumberInRange(start, end);
            if (random >= MOVING_FORWARD) { Move_count[i] += 1; }
        }
    }

    protected void get_Car_Names() {
        // 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String Car_String = Console.readLine();
        Car_Names = Car_String.split(",");
        String Car_Name;

        // 이름 예외 처리
        for (int i = 0; i < Car_Names.length; i++) {
            Car_Name = Car_Names[i];
            if (Car_Name.length() > 5) { throw new IllegalArgumentException("이름은 5자 이하만 가능합니다."); }
        }
    }
}
