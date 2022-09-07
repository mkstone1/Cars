package dat3.Cars.api;


import dat3.Cars.dto.ReservationRequest;
import dat3.Cars.dto.ReservationResponse;
import dat3.Cars.entity.Reservation;
import dat3.Cars.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservation")
public class ReservationController {


    ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PutMapping
    void reserveCar(@RequestBody ReservationRequest reservationRequest){
        reservationService.createReservation(reservationRequest);

    }
}
