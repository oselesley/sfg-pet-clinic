package lesley.springframework.sfgpetclinic.repositories;

import lesley.springframework.sfgpetclinic.model.Speciality;
import lesley.springframework.sfgpetclinic.services.CrudService;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends CrudService<Long, Speciality> {
}
