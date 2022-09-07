package dat3.Cars.service;

import dat3.Cars.dto.CarResponse;
import dat3.Cars.dto.ReservationRequest;
import dat3.Cars.dto.ReservationResponse;
import dat3.Cars.entity.Car;
import dat3.Cars.entity.Member;
import dat3.Cars.entity.Reservation;
import dat3.Cars.repository.CarRepository;
import dat3.Cars.repository.MemberRepository;
import dat3.Cars.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    ReservationRepository reservationRepository;
    MemberRepository memberRepository;
    CarRepository carRepository;

    public ReservationService(ReservationRepository reservationRepository, MemberRepository memberRepository, CarRepository carRepository) {
        this.reservationRepository = reservationRepository;
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;

    }

    public void createReservation(ReservationRequest reservationRequest){
        Member member = memberRepository.findById(reservationRequest.getUsername()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));
        Car car = carRepository.findById(reservationRequest.getCarId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car not found"));

        Reservation reservation = new Reservation(member, car, reservationRequest.getRentalDate());
        reservationRepository.save(reservation);
    }


    public void reserveCar(String username, int carId, LocalDate date) {
        Car carToAdd = carRepository.findById(carId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car not found"));
        Member memberToAdd = memberRepository.findById(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));


        if(reservationRepository.existsByCar_IdAndRentalDate(carId,date)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car reserved on this date");
        }
        Reservation res = new Reservation(memberToAdd, carToAdd, date);
        reservationRepository.save(res);

    }


}
