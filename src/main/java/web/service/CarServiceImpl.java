package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.models.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarDao carDao;

    @Autowired
    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    //4. Создайте сервис с методом,
    //который будет возвращать указанное число машин из созданного списка.
    @Override
    public List<Car> getCars(int count) {
        List<Car> allCars = carDao.getAllCars();

        if (count <= 0) {
            throw new IllegalArgumentException("Count cant be less than 0");
        }
        //При count ≥ 5 выводить весь список машин.
        if (count >= allCars.size()) {
            return getAllCars();
        }

        return allCars.subList(0, count);
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }
}
