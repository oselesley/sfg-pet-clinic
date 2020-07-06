package lesley.springframework.sfgpetclinic.services;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface CrudService<ID, T> {
    T findById(ID id);

    T save(T object);

    Set<T> findAll();
}
