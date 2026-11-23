package groupe13.esgi.eventhub.service;

import groupe13.esgi.eventhub.dto.EventDTO;
import groupe13.esgi.eventhub.model.Event;
import groupe13.esgi.eventhub.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EventService {

    private final EventRepository eventRepository;

    public List<EventDTO> findAll() {
        return eventRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public Optional<EventDTO> findById(Long id) {
        return eventRepository.findById(id)
                .map(this::toDTO);
    }

    @Transactional
    public EventDTO create(EventDTO dto) {
        log.info("Création de l'événement : {}", dto.titre());

        Event event = new Event();
        event.setTitre(dto.titre());
        event.setDescription(dto.description());
        event.setDateEvenement(dto.dateEvenement());
        event.setPrix(dto.prix());
        event.setStatus(dto.status());

        Event saved = eventRepository.save(event);
        return toDTO(saved);
    }

    private EventDTO toDTO(Event e) {
        return new EventDTO(
                e.getId(),
                e.getTitre(),
                e.getDescription(),
                e.getDateEvenement(),
                e.getPrix(),
                e.getStatus()
        );
    }
}