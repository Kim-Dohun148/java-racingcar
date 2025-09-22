package racingcar;

import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static void main(String[] args) {
        Car car = new Car();
        Racing Game = new Racing();

        car.get_Car_Names();
        Game.Start(car);
    }
}
