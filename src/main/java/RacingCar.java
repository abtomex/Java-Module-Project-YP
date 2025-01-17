import java.util.Objects;

public class RacingCar {
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

