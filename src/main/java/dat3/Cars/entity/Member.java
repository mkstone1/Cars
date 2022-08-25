package dat3.Cars.entity;

import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity

public class Member extends UserWithRoles {

    public Member(String username,  String password, String email, String firstName) {
        super(username, password, email );
        this.firstName = firstName;
    }


    private String firstName;

    private String lastName;

    private String street;

    private String city;

    private int zip;

    private boolean approved;

    private double ranking;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime dateEdited;

    public Member() {

    }
}
