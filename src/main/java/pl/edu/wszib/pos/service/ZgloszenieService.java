package pl.edu.wszib.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Zgloszenie> listAll() {
        return (List<Zgloszenie>) repo.findAll();
    }

    public Zgloszenie get(Long id) {
        Zgloszenie zgloszenie = repo.findById(id).get(id);
        return zgloszenie;
    }

    public void save(Zgloszenie zgloszenie) {
        repo.save(zgloszenie);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}
