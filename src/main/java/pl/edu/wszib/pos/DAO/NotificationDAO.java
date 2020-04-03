package pl.edu.wszib.pos.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.pos.model.Notification;

import java.util.List;

@Repository
public interface NotificationDAO extends CrudRepository<Notification, Integer> {

    @Override
    List<Notification> findAll();

    @Override
    List<Notification> findAllById(Iterable<Integer> integers);

    List<Notification> findAllByOrOrderById();


}
