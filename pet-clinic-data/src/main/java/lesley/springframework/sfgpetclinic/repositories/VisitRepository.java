package lesley.springframework.sfgpetclinic.repositories;

import lesley.springframework.sfgpetclinic.model.Visit;
import lesley.springframework.sfgpetclinic.services.CrudService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
