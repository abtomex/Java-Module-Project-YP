import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static final int racerCount = 3;

    public static void main(String[] args) {

        System.out.println("Приветствуем вас на гонках Лемана");

        RacingCar[] racingCars = new RacingCar[racerCount];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < racerCount; i++) {

            System.out.printf("Введите название %d-го автомобиля\n", i+1);
            racingCars[i] = new RacingCar(scanner.nextLine(), getVelocity());
        }
        System.out.println("Все участники прибыли на старт!");
        Race race = new Race(racingCars);
        System.out.println("5!\n4!\n3!\n2!\n1!\nСТАРТ!!!");
        race.start();
        System.out.println("...................");
        race.checkResults();
        System.out.println("...................");
        System.out.printf("Поздравляем победителя %s!\n", race.getLeader().name);
        System.out.printf("За 24 часа больше всех проехал %s. Дистанция составила %d километров.\n", race.getLeader().name, race.getLeader().distance);
    }

    private static int getVelocity() {
        System.out.println("Введите скорость, км/ч с которой автомобиль движется");
        System.out.println("Обратите внимание, что скорость должна быть > 0 и ⩽250%n");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int velocity = scanner.nextInt();
                if (velocity > 0 && velocity <= 250) {
                    return velocity;
                }
                throw new RuntimeException("Скорость должна быть > 0 и ⩽250");
            } catch (Exception e) {
                System.out.println("Ошибка при вводе скорости. Введите целое число в пределах от 1 до 251");
                scanner = new Scanner(System.in); // если не переинициализировать scanner то scanner.nextInt() или scanner.next() всегда будет отдавать ошибочно введенный символ
            }
        }
    }
}

class RacingCar {
    String name;
    int velocity;
    int distance;

    public RacingCar(String name, int velocity) {
        this.name = name;
        this.velocity = velocity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return velocity == racingCar.velocity && Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, velocity);
    }
}

class Race {
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