package pl.edu.wszib.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wszib.pos.model.Zgloszenie;
import pl.edu.wszib.pos.repository.ZgloszenieRepository;

@Service
@Transactional
public class ZgloszenieService {

    @Autowired
    private ZgloszenieRepository repo;

    public Iterable<Zgloszenie> findAll() {
        return repo.findAll();
    }

    public Page<Zgloszenie> getPaginated(Pageable pageable) {
        return repo.findAll(pageable);
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
