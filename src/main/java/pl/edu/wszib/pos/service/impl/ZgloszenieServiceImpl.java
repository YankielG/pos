package pl.edu.wszib.pos.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.edu.wszib.pos.model.Zgloszenie;
import pl.edu.wszib.pos.repository.ZgloszenieRepository;
import pl.edu.wszib.pos.service.ZgloszenieService;

import java.util.Optional;

@Service
public class ZgloszenieServiceImpl implements ZgloszenieService {
    private final ZgloszenieRepository zgloszenieRepository;

    public ZgloszenieServiceImpl(ZgloszenieRepository zgloszenieRepository) {
        this.zgloszenieRepository = zgloszenieRepository;
    }

    @Override
    public Page<Zgloszenie> findAllPageable(Pageable pageable) {
        return zgloszenieRepository.findAll(pageable);
    }

//    public Page<Zgloszenie> finaAllPageableByIdAndDelIsFalse(Long id, Pageable pageable) {
//        return zgloszenieRepository.findAllByIdAndDelIsFalse(id, pageable);
//    }

    public void save(Zgloszenie zgloszenie) {
        zgloszenieRepository.save(zgloszenie);
    }

    public Zgloszenie get(Long id) {
        return zgloszenieRepository.findById(id).get();
    }

}
