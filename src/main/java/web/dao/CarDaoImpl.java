package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;


@Component
public class CarDaoImpl implements CarDao {

    private final List<Car> carDatabase;

    public CarDaoImpl() {
        this.carDatabase = new ArrayList<>(List.of(
                new Car("Toyota Camry", 2022, 30000),
                new Car("Honda Accord", 2023, 32500),
                new Car("BMW X5", 2021, 65000),
                new Car("Mercedes-Benz E-Class", 2023, 72000),
                new Car("Tesla Model 3", 2023, 45000)
              //  new Car("Test 6 car", 0000, 00000)
        ));
    }

    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(carDatabase);//Возвращаем копию
    }
}
