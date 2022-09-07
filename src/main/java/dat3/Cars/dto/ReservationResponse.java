package dat3.Cars.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.Cars.entity.Car;
import dat3.Cars.entity.Member;
import dat3.Cars.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationResponse {

    private int id;
    private int carId;
    private String carBrand;
    private LocalDate rentalDate;

    public ReservationResponse(Reservation reservation) {
        this.carBrand = reservation.getCar().getBrand();
        this.rentalDate = reservation.getRentalDate();
        this.carId = reservation.getCar().getId();
        this.id = reservation.getId();
    }
}
