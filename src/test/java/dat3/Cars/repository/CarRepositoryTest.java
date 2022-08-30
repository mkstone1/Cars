package dat3.Cars.repository;

import dat3.Cars.entity.Car;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    CarRepository carRepository;

    @BeforeEach
    void setupBeforeEach(){
        Car bmw = Car.builder().model("z3").brand("BMW").pricePerDay(100).build();
        Car volvo = Car.builder().brand("Volvo").model("V10").pricePerDay(250).build();
        carRepository.save(bmw);
        carRepository.save(volvo);
    }

    @Test
    void findCarByModel() {
        List<Car> cars = carRepository.findCarByModel("z3");
        assertEquals(1,cars.size());
    }

    @Test
    void findCarByPricePerDayBetween() {
        List<Car> cars = carRepository.findCarByPricePerDayBetween(0,99);
        assertEquals(0,cars.size());

        cars = carRepository.findCarByPricePerDayBetween(0,100);
        assertEquals(1,cars.size());

        cars = carRepository.findCarByPricePerDayBetween(0,101);
        assertEquals(1, cars.size());

        cars = carRepository.findCarByPricePerDayBetween(0,250);
        assertEquals(2,cars.size());

        cars = carRepository.findCarByPricePerDayBetween(101,250);
        assertEquals(1,cars.size());

        cars=  carRepository.findCarByPricePerDayBetween(251,1000);
        assertEquals(0,cars.size());
    }

    @Test
    void findCarByBrand(){
        List<Car> cars = carRepository.findCarByBrand("BMW");
        assertEquals(1, cars.size());
    }
}