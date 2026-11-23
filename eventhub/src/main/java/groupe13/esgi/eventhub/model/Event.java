package groupe13.esgi.eventhub.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Titre;
    private String Description;
    private LocalDate dateEvenement;
    private double Prix;

    @Enumerated(EnumType.STRING)
    private EventStatus status;
}
