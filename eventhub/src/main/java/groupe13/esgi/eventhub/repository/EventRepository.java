package groupe13.esgi.eventhub.repository;

import groupe13.esgi.eventhub.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}