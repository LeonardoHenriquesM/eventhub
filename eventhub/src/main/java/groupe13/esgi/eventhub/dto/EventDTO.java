package groupe13.esgi.eventhub.dto;

import groupe13.esgi.eventhub.model.EventStatus;
import java.time.LocalDate;

public record EventDTO(
        Long id,
        String titre,
        String description,
        LocalDate dateEvenement,
        double prix,
        EventStatus status
) {}