package dat3.Cars.service;


import dat3.Cars.dto.CarRequest;
import dat3.Cars.dto.CarResponse;
import dat3.Cars.entity.Car;
import dat3.Cars.repository.CarRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class CarServiceMockWithH2Test {
/*

    public  CarService carService;

    public  static CarRepository carRepository;

    static int car1ID,car2ID;
    @BeforeAll
    public static void setupData(@Autowired CarRepository car_repository){
        carRepository = car_repository;
        carRepository.deleteAll();
        Car car1 =  new Car("b1", "m1", 1);
        Car car2 = new Car("b2", "m1", 2);
        car1 = carRepository.save(car1);
        car2 = carRepository.save(car2);
        car1ID = car1.getId();
        car2ID = car2.getId();
        carRepository = car_repository;
    }

    @BeforeEach
    public void initCarService(){
        carService = new CarService(carRepository);
    }

    @Test
    void addCar(){
        CarRequest request = new CarRequest("b3","m3",3,3);
        CarResponse response = carService.addCar(request);
        assertTrue(response.getId() > 0);
    }

    @Test
    void findCarByID(){
        CarResponse response = carService.getCarByID(1);
        assertTrue(response.getId() ==1);
    }


    @Test
    void getCarByBrand(){
        List<CarResponse> response = carService.getCarByBrand("b1");
        assertTrue(response.size() > 0);
    }

    @Test
    void editCar(){
        Car carToedit = carRepository.findById(1).get();
        carToedit.setBrand("b3");
        carToedit.setBestDiscount(5);
        CarRequest request = new CarRequest(carToedit);
        carService.editCar(carToedit.getId(),request);
        Car editedCar = carRepository.findById(1).get();
        assertEquals(5, editedCar.getBestDiscount());
        assertTrue(carToedit.getBrand().equals("b3"));
    }

    @Test
    void editDiscount(){
        Car carToEdit = carRepository.findById(1).get();
        carService.editDiscount(1,10);
        Car editedCar = carRepository.findById(1).get();
        assertEquals(10,editedCar.getBestDiscount());
    }

    @Test
    void deleteCarById(){
        carService.deleteCarById(1);
        assertEquals(1,carRepository.findAll().size());
    }
    */

}
