package dat3.Cars.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 20)
    private String brand;

    @Column(nullable = false, length = 10)
    private String model;

    @Column(length = 10)
    private double pricePerDay;

    @Column(length = 10)
    private double bestDiscount;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime dateEdited;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    List<Reservation> reservations = new ArrayList<>();

    public void addReservation (Reservation res){
        reservations.add(res);
    }

    public Car(String brand, String model, double pricePerDay) {
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    public Car(String brand, String model, double pricePerDay, double bestDiscount) {
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.bestDiscount = bestDiscount;
    }
}