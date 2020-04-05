package pl.edu.wszib.pos.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wszib.pos.model.History;
import pl.edu.wszib.pos.repository.HistoryRepository;

@Service
@Transactional
public class HistoryService {
    private HistoryRepository historyRepository;

    public void save(History history) {
        historyRepository.save(history);
    }
}
