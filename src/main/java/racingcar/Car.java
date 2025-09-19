package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

class Car {
    private static final int MOVING_FORWARD = 4;
    private static final int start = 0;
    private static final int end = 9;

    private int Move_count;

    void Move() {
        int random = Randoms.pickNumberInRange(start, end);
        if (random >= MOVING_FORWARD) {
            Move_count += 1;
        }
    }
}
