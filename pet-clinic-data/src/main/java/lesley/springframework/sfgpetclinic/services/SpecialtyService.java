package lesley.springframework.sfgpetclinic.services;

import lesley.springframework.sfgpetclinic.model.Speciality;
import org.springframework.stereotype.Service;

@Service
public interface SpecialtyService extends CrudService<Long, Speciality> {
}
