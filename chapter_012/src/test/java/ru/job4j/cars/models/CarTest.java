package ru.job4j.cars.models;

import org.junit.Test;
import ru.job4j.cars.dao.CarDao;
import ru.job4j.cars.dao.DriverDao;
import ru.job4j.cars.dao.EngineDao;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class CarTest {
    private final EngineDao engineDao = EngineDao.getInstance();
    private final CarDao carDao = CarDao.getInstance();
    private final DriverDao driverDao = DriverDao.getInstance();
    private List<Driver> driverList;

    @Test
    public void whenAddCarWithDriverInside() {
        driverList = new ArrayList<>();
        Driver driver = new Driver();
        driver.setName("Voloday");
        driverList.add(driver);
        Car car = new Car();
        car.setName("Mersedes Benz");
        car.setDrivers(driverList);
        carDao.add(car);
        System.out.println(carDao.get(car));
        String expected = "Voloday";
        String actual = carDao.get(car).getDrivers().get(0).getName();
        assertThat(actual, is(expected));
        driverDao.deleteAll();
        carDao.deleteAll();
    }

    @Test
    public void whenUpdateCar() {
        Car car = new Car();
        car.setName("Lada");
        carDao.add(car);
        car.setName("Jeep");
        carDao.update(car);
        String expected = "Jeep";
        String actual = carDao.get(car).getName();
        assertThat(actual, is(expected));
        carDao.deleteAll();
    }

    @Test
    public void whenDeleteCar() {
        Car car = new Car();
        car.setName("Lada");
        carDao.add(car);
        String expected = "Lada";
        String actual = carDao.get(car).getName();
        assertThat(actual, is(expected));
        carDao.delete(car);
        assertThat(carDao.get(car), is(nullValue()));
    }

    @Test
    public void whenCreateCarAndAddEngineAndListOfDrivers() {
        Engine engine = new Engine();
        engine.setType("v8");
        engineDao.add(engine);
        driverList = new ArrayList<>();
        Driver driver1 = new Driver();
        driver1.setName("Voloday");
        driverList = new ArrayList<>();
        Driver driver2 = new Driver();
        driver2.setName("Shumaher");
        driverList.add(driver1);
        driverList.add(driver2);
        Car car = new Car();
        car.setName("Mersedes Benz");
        car.setEngine(engine);
        car.setDrivers(driverList);
        carDao.add(car);
        System.out.println(carDao.get(car));
        int expected = 2;
        int actual = carDao.get(car).getDrivers().size();
        assertThat(actual, is(expected));
        assertThat(carDao.get(car).getEngine().getType(), is("v8"));
        driverDao.deleteAll();
        carDao.deleteAll();
        engineDao.deleteAll();
    }
}