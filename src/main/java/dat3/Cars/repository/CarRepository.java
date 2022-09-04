package dat3.Cars.repository;

import dat3.Cars.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findCarByModel(String model);
    List<Car> findCarByPricePerDayBetween(double start, double end);

    List<Car> findCarByBrand(String brand);
}
