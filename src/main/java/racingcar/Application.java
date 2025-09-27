package racingcar;

import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static void main(String[] args) {
        Car car = new Car();
        car.getNames();

        Racing game = new Racing(car);
        game.start();
    }
}
