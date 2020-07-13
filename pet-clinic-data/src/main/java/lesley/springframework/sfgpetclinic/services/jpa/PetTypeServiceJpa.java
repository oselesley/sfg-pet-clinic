package lesley.springframework.sfgpetclinic.services.jpa;

import lesley.springframework.sfgpetclinic.model.PetType;
import lesley.springframework.sfgpetclinic.repositories.PetTypeRepository;
import lesley.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile(value = "springdatajpa")
public class PetTypeServiceJpa implements PetTypeService {
    private PetTypeRepository petTypeRepository;

    public PetTypeServiceJpa(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public Set<PetType> findAll() {
        return petTypeRepository.findAll();
    }
}
