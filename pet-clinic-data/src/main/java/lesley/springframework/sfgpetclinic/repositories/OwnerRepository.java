package lesley.springframework.sfgpetclinic.repositories;

import lesley.springframework.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Optional<Owner> findOwnerByLastName (String lastname);
}
