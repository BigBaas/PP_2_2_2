package web.service;

import web.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car("Ford", "RED", 215));
        cars.add(new Car("Suzuki", "YELLOW", 265));
        cars.add(new Car("Ferrari", "BLACK", 310));
        cars.add(new Car("FIAT", "GREEN", 180));
        cars.add(new Car("BMW", "BLUE", 242));
    }

    @Override
    public List<Car> carsCount(int number) {
        cars = getAllCars();
        if (number == 0 || number > 5) {
            return cars;
        }
        if (number < 0) {
            return null;
        }
        return cars.stream().limit(number).collect(Collectors.toList());
        }

    @Override
    public List<Car> getAllCars() {
        return cars;
    }
}


