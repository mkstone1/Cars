package dat3.Cars.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.Cars.entity.Car;
import dat3.Cars.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarResponse {

    private int id;

    private String brand;

    private String model;

    private double pricePerDay;

    private double bestDiscount;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private LocalDateTime dateCreated;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private LocalDateTime dateEdited;

    public CarResponse(Car c, boolean includeAll) {
        this.id = c.getId();
        this.brand= c.getBrand();
        this.model = c.getModel();
        this.pricePerDay = c.getPricePerDay();
        if(includeAll){
            this.bestDiscount = c.getBestDiscount();
            this.dateCreated = c.getDateCreated();
            this.dateEdited = c.getDateEdited();
        }
    }
}
