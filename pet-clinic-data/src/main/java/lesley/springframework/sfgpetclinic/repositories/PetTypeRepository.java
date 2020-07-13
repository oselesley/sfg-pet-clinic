package lesley.springframework.sfgpetclinic.repositories;

import lesley.springframework.sfgpetclinic.model.PetType;
import lesley.springframework.sfgpetclinic.services.CrudService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
