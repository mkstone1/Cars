package dat3.Cars.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @CreationTimestamp
    private LocalDateTime reservationDate;

    private LocalDate rentalDate;

    @ManyToOne()
    private Car car;

    @ManyToOne
    private Member member;

    public Reservation(Member member,Car car, LocalDate date){
        this.car = car;
        this.member = member;
        member.addReservation(this);
        car.addReservation(this);
        rentalDate = date;
    }
}
