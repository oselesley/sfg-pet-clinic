package lesley.springframework.sfgpetclinic.services.map;

import lesley.springframework.sfgpetclinic.model.PetType;
import lesley.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeServiceMap extends AbstractMapService<Long, PetType> implements PetTypeService {

}
