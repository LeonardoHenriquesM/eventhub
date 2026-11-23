package groupe13.esgi.eventhub.controller;

import groupe13.esgi.eventhub.dto.EventDTO;
import groupe13.esgi.eventhub.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping
    public List<EventDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getOne(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EventDTO> create(@RequestBody EventDTO dto) {
        EventDTO created = service.create(dto);
        URI uri = URI.create("/api/v1/events/" + created.id());
        return ResponseEntity.created(uri).body(created);
    }
}