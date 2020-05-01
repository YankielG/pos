package pl.edu.wszib.pos.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.edu.wszib.pos.model.Zgloszenie;
import pl.edu.wszib.pos.repository.ZgloszenieRepository;

public interface ZgloszenieService {
    Page<Zgloszenie> findAllPageable(Pageable pageable);

}
