package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;

public class CarServiceImp implements CarService{

    CarDao carDao;

    public CarServiceImp(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public void add(Car car) {
        carDao.add(car);
    }
}
