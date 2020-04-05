package pl.edu.wszib.pos.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wszib.pos.model.Role;
import pl.edu.wszib.pos.repository.RoleRepository;

@Service
@Transactional
public class RoleService {
    private RoleRepository roleRepository;

    public void save(Role role) {
        roleRepository.save(role);

    }

    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    public Iterable<Role> ListAll() {
        return roleRepository.findAll();
    }
}
