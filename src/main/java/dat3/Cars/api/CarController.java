package dat3.Cars.api;


import dat3.Cars.dto.CarRequest;
import dat3.Cars.dto.CarResponse;
import dat3.Cars.dto.MemberRequest;
import dat3.Cars.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    // Security User
    @GetMapping
    List<CarResponse> getCars(){
        return carService.getCars();
    }
    // Security User
    @GetMapping("/{brand}")
    List<CarResponse> getCarByBrand(@PathVariable String brand){
        return carService.getCarByBrand(brand);
    }
    // Security ADMIN
    @PostMapping
    CarResponse addCar(@RequestBody CarRequest carRequest){
        return carService.addCar(carRequest);
    }
    // Security ADMIN
    @PutMapping("/{carId}")
    ResponseEntity<Boolean> editCar(@RequestBody CarRequest body, @PathVariable int carId){
        carService.editCar(carId,body);
        return null;
    }

    // Security ADMIN
    @PatchMapping("/discount/{carId}/{value}")
    void setRankingForUser(@PathVariable int carId, @PathVariable int value) {
        carService.editDiscount(carId, value);
    }

    // Security ADMIN
    @DeleteMapping("/{carId}")
    void deleteCarByID(@PathVariable int carId) {
        carService.deleteCarById(carId);
    }





}
