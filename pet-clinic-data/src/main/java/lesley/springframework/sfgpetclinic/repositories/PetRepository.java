package lesley.springframework.sfgpetclinic.repositories;

import lesley.springframework.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
}
