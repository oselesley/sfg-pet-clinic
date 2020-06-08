package lesley.springframework.sfgpetclinic.services;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface CrudService<T, ID> {
    T findById(ID id);

    T save(T object);

    Set<T> findAll();
}
