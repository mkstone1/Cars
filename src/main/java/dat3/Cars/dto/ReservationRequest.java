package dat3.Cars.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservationRequest {

    int carId;
    String username;
    LocalDate rentalDate;
}
