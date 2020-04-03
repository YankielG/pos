package pl.edu.wszib.pos.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.pos.model.Notification;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Integer> {
}
