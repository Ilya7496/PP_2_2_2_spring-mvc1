package web.Service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    private final List<Car> cars = Arrays.asList(
            new Car(1, "AUDI", 1996),
            new Car(2, "BMW", 1997),
            new Car(3, "TOYOTA", 1997),
            new Car(4, "MERCEDES", 1995),
            new Car(5, "FORD", 1995));

    public List<Car> getCars(Optional<Integer> carsQuantity) {
        return carsQuantity.map(i -> {
            if (i <= cars.size()) {
                return cars.subList(0, i);
            } else {
                return cars;
            }
        }).orElseGet(() -> cars);
    }
}
