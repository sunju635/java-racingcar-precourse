package racinggame.domain;

import racinggame.exception.GameException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(String cars) throws GameException {
        String[] carArray = cars.split(",");
        this.cars = new ArrayList<>();
        for(String car : carArray) {
            this.cars.add(new Car(car.trim()));
        }
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> toList() {
        return Collections.unmodifiableList(cars);
    }

    public Car get(int i) {
        return cars.get(i);
    }

    public int size() {
        return cars.size();
    }

    public void forward() {
        for(Car car : this.cars) {
            car.forward();
        }
    }

    public String getGameResultText() {
        /*Collections.sort(this.cars, new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car1.getStep().getStep() - car2.getStep().getStep();
            }
        });

        List<Car> result = new ArrayList<>();
        Car winner = this.cars.get(0);

        for(Car car : this.cars) {
            if(!car.isWinner(winner)) {
                break;
            }
            result.add(winner);
        }*/

        StringBuilder builder = new StringBuilder();

        for(Car car : this.cars) {
            builder.append(car.getCar() + " : " + car.getStep().getResultStep() + "\n");
        }

        return builder.toString();
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
