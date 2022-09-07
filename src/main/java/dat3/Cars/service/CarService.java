package dat3.Cars.service;

import dat3.Cars.dto.CarRequest;
import dat3.Cars.dto.CarResponse;
import dat3.Cars.entity.Car;
import dat3.Cars.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    CarRepository carRepository;
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public List<CarResponse> getCars() {
        List<Car> cars = carRepository.findAll();
        List<CarResponse> response = cars.stream().map(car -> new CarResponse(car,false)).collect(Collectors.toList());
        return response;
    }

    public CarResponse getCarByID(int id){
        Car car = carRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Car not found"));
        return new CarResponse(car, false);
    }

    public List<CarResponse> getCarByBrand(String brand) {
        List<Car> cars  = carRepository.findCarByBrand(brand);
        List<CarResponse> response = cars.stream().map(car -> new CarResponse(car,false)).collect(Collectors.toList());
        return response;
    }

    public CarResponse addCar(CarRequest carRequest){
        //Later you should add error checks --> Missing arguments, email taken etc.

        Car newCar= CarRequest.getCarEntity(carRequest);
        newCar = carRepository.save(newCar);

        return new CarResponse(newCar, false);
    }

    public void editCar(int carId, CarRequest body){
       Car car = carRepository.findById(carId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Car not found"));
       car.setBrand(body.getBrand());
       car.setModel(body.getModel());
       car.setPricePerDay(body.getPricePerDay());
       car.setBestDiscount(body.getBestDiscount());
       carRepository.save(car);
    }

    public void editDiscount(int carId, int value){
        Car car = carRepository.findById(carId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Car not found"));
        car.setBestDiscount(value);
    }

    public void deleteCarById(int carId){
        Car car = carRepository.findById(carId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Car not found"));
        carRepository.delete(car);
    }

}
