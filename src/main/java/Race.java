import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Race {
    final int RACE_DURATION = 24;
    Set<RacingCar> racers;
    RacingCar leader;

    public Race(RacingCar[] racingCars) {
        racers = new HashSet<>();
        Collections.addAll(racers, racingCars);
    }

    public void start() {
        System.out.println("Гонка началась!!!");

        for (RacingCar car : racers) {
            car.distance = car.velocity * RACE_DURATION;
        }
        System.out.println("Гонка завершена.");
    }

    public void checkResults() {
        System.out.println("Подведение итогов");
        int maxDistance = 0;
        for (RacingCar car : racers) {
            if (car.distance > maxDistance) {
                maxDistance = car.distance;
                leader = car;
            }
        }
    }

    public RacingCar getLeader() {
        return leader;
    }
}