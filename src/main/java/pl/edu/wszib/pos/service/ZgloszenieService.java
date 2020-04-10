package pl.edu.wszib.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wszib.pos.model.Zgloszenie;
import pl.edu.wszib.pos.repository.ZgloszenieRepository;

import java.util.List;

@Service
@Transactional
public class ZgloszenieService {

    @Autowired
    private ZgloszenieRepository repo;

    public Iterable<Zgloszenie> listAll() {
        return repo.findAll();
    }

    public Zgloszenie get(Long id) {
        Zgloszenie zgloszenie = repo.findById(id).get();
        return zgloszenie;
    }

    public void save(Zgloszenie zgloszenie) {
        repo.save(zgloszenie);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }



}
