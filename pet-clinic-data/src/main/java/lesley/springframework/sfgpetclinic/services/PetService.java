package lesley.springframework.sfgpetclinic.services;

import lesley.springframework.sfgpetclinic.model.Pet;
import org.springframework.stereotype.Service;

@Service
public interface PetService extends CrudService<Long, Pet>{
}
