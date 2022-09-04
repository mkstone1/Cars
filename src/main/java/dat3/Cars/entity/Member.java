package dat3.Cars.entity;

import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Entity
public class Member extends UserWithRoles {

    @Column(length = 30)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(length = 50)
    private String street;

    @Column(length = 50)
    private String city;

    @Column(length = 20)
    private String zip;


    private boolean approved;
    private int ranking;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime dateEdited;


    public Member(String user, String password, String email, String firstName, String lastName, String street, String city, String zip) {
        super(user, password, email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }
}
