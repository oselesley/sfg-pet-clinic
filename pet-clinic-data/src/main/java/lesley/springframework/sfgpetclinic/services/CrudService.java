package lesley.springframework.sfgpetclinic.services;

import java.util.Set;

public interface CrudService<T, I> {
    T findById(I id);

    T save(T owner);

    Set<T> findAll();
}
