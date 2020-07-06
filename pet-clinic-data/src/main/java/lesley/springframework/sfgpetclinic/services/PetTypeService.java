package lesley.springframework.sfgpetclinic.services;

import lesley.springframework.sfgpetclinic.model.PetType;
import org.springframework.stereotype.Service;

@Service
public interface PetTypeService extends CrudService<Long, PetType> {

}
