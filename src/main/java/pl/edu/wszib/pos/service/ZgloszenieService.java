package pl.edu.wszib.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wszib.pos.model.Zgloszenie;
import pl.edu.wszib.pos.repository.ZgloszenieRepository;

import java.util.Optional;

@Service
@Transactional
public class ZgloszenieService {

    @Autowired
    private ZgloszenieRepository repo;

//    public Zgloszenie findAllByIdAndDelIsTrue(Long id) {
//    return  repo.findAllByIdAndDelIsTrue();
//    }
////    public Page<Zgloszenie> getPaginated(Pageable pageable) {
//        return repo.findAll(pageable);
//    }


    public Zgloszenie get(Long id) {
        Zgloszenie zgloszenie = repo.findById(id).get();
        return zgloszenie;
    }
        //@Override
//     public Page<Zgloszenie> getPaginatedZgloszenia(Pageable pageable){
//         return repo.findAllByIdAndDelIsTrue(pageable);
//     }
    public void save(Zgloszenie zgloszenie) {
        repo.save(zgloszenie);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }



}
