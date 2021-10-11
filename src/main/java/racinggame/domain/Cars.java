package racinggame.domain;

import racinggame.exception.GameException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public Cars makeNewCars() {
        List<Car> newCars = new ArrayList<>();
        for(Car car : this.cars) {
            newCars.add(new Car(car));
        }
        return new Cars(newCars);
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
        StringBuilder builder = new StringBuilder();

        for(Car car : this.cars) {
            builder.append(car.getCar() + " : " + car.getStep().getResultStep() + "\n");
        }

        return builder.toString();
    }

    public List<Car> getWinners() {
        sortByLank();

        List<Car> result = new ArrayList<>();
        Car winner = this.cars.get(0);

        for(Car car : this.cars) {
            if(!car.isWinner(winner)) {
                break;
            }
            result.add(winner);
        }

        return result;
    }

    private void sortByLank() {
        Collections.sort(this.cars, new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car2.getStep().getStep() - car1.getStep().getStep();
            }
        });
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
