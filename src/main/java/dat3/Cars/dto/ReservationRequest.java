package dat3.Cars.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ReservationRequest {

    int carId;
    String username;
    LocalDate rentalDate;
}
