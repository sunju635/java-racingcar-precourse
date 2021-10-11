package racinggame.domain;

import racinggame.exception.GameException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author 정선주
 * @version 1.0
 * @since 1.0
 */
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

    /**
     * 새로운 Cars 객체 생성
     * <p>
     * 새로운 Cars 객체를 생성한다. Result에 게임 단계 별 Cars를 저장하기 위해 사용된다.
     * </p>
     */
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

    /**
     * 앞으로 전진
     * <p>
     * 랜덤한 숫자만큼 앞으로 전진한다.
     * </p>
     */
    public void forward() {
        for(Car car : this.cars) {
            car.forward();
        }
    }

    /**
     * 게임 결과 텍스트 생성
     * <p>
     * 게임 단계 별 결과를 텍스트로 생성한다.
     * </p>
     */
    public String getGameResultText() {
        StringBuilder builder = new StringBuilder();

        for(Car car : this.cars) {
            builder.append(car.getCar() + " : " + car.getStep().getResultStep() + "\n");
        }

        return builder.toString();
    }

    /**
     * 우승자 리스트 생성
     * <p>
     * 우승자 리스트를 생성한다.
     * </p>
     */
    public List<Car> getWinners() {
        sortByLank();

        List<Car> result = new ArrayList<>();
        boolean isPickedWinner = true;
        int index = 0;
        while (isPickedWinner) {
            result.add(this.cars.get(index));
            isPickedWinner = isPickedWinner(++index);
        }
        return result;
    }

    /**
     * 우승자인지 확인
     * <p>
     * 인덱스 별 Car가 우승자인지 확인한다.
     * </p>
     *
     * @param index 우승자
     */
    private boolean isPickedWinner(int index) {
        if(index >= this.cars.size()) {
            return false;
        }

        return this.cars.get(index).isWinner(this.cars.get(0));
    }

    /**
     * step을 기준으로 sorting한다.
     * <p>
     * step이 많은 순으로 sorting한다. 우승자 리스트를 생성할 때 사용된다.
     * </p>
     */
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
