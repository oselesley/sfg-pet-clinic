package lesley.springframework.sfgpetclinic.repositories;

import lesley.springframework.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface VetRepository extends CrudRepository<Vet, Long> {
    Optional<Vet> findVetByLastName(String lastName);
}
