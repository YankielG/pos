package pl.edu.wszib.pos.service;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.pos.model.Notification;
import pl.edu.wszib.pos.repository.NotificationRepository;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification findById(Long nId) throws NotFoundException {
        Notification notification = notificationRepository.findById().orElse(null);
        if (notification==null) {
            throw new NotFoundException("Nie potrafię znaleźć zgłoszenia o  id : " + nId);
        }
        else return notification;
    }

    public Notification save(Notification notification) {
        return notificationRepository.save(notification);

    }
    public Long count(){
        return notificationRepository.count();
    }

    }

