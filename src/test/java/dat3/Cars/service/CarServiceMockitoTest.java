package dat3.Cars.service;

import dat3.Cars.dto.CarRequest;
import dat3.Cars.dto.CarResponse;
import dat3.Cars.dto.MemberResponse;
import dat3.Cars.entity.Car;
import dat3.Cars.entity.Member;
import dat3.Cars.repository.CarRepository;
import dat3.Cars.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class CarServiceMockitoTest {
    @Mock
    CarRepository carRepository;

    @Autowired
    CarService carService;


    @BeforeEach
    public void setup() {
        carService = new CarService(carRepository);
    }


    @Test
    void getCars() {
        Mockito.when(carRepository.findAll()).thenReturn(List.of(
                new Car("b1", "m1", 1),
                new Car("b2", "m1", 2)
        ));
        List<CarResponse> cars = carService.getCars();
        assertEquals(2, cars.size());
    }

    @Test
    void addCar(){
        Car carWithId = new Car("b3","m2",3);
        carWithId.setId(3);
        Mockito.when(carRepository.save(any(Car.class))).thenReturn(carWithId);
        CarRequest request = new CarRequest(carWithId);
        CarResponse res = carService.addCar(request);
        assertEquals(3 ,res.getId());

    }


}
