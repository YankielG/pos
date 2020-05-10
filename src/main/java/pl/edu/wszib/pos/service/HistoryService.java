package pl.edu.wszib.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wszib.pos.model.History;
import pl.edu.wszib.pos.repository.HistoryRepository;

import java.util.List;

@Service
@Transactional
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    public void save(History history) {
        historyRepository.save(history);
    }


}
