package pl.edu.wszib.pos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.pos.model.Notification;
@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long>, PagingAndSortingRepository<Notification, Long> {

}
