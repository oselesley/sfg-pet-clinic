package lesley.springframework.sfgpetclinic.services.map;

import lesley.springframework.sfgpetclinic.model.Speciality;
import lesley.springframework.sfgpetclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyServiceMap extends AbstractMapService<Long, Speciality> implements SpecialtyService {
}
