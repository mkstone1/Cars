package dat3.Cars.dto;

import dat3.Cars.entity.Car;
import dat3.Cars.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarRequest {

    private String brand;

    private String model;

    private double pricePerDay;

    private double bestDiscount;



    public static Car getCarEntity(CarRequest c){
        return new Car(c.brand,c.model, c.pricePerDay,c.bestDiscount);
    }

    public CarRequest(Car c){
        this.brand =c.getBrand();
        this.model = c.getModel();
        this.pricePerDay = c.getPricePerDay();
        this.bestDiscount = c.getBestDiscount();
    }
}
