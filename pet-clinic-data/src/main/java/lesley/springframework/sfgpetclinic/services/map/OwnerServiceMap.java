package lesley.springframework.sfgpetclinic.services.map;

import lesley.springframework.sfgpetclinic.model.Owner;
import lesley.springframework.sfgpetclinic.model.Pet;
import lesley.springframework.sfgpetclinic.services.OwnerService;
import lesley.springframework.sfgpetclinic.services.PetService;
import lesley.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Long, Owner> implements OwnerService {
    private PetService petService;
    private PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Owner findByLastName(String lastname) {
        Collection<Owner> mapIterator = getAbstMap().values();

        for (Owner owner : mapIterator) {
            if (owner.getLastName().equalsIgnoreCase(lastname)) return  owner;
        }

        return  null;
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required!!");
                    }

                    if (pet.getId() == null) {
                        Pet pet1 = petService.save(pet);
                        pet.setId(pet.getId());
                    }
                });
            }
            return super.save(object);
        } else return null;
    }

    @Override
    public Owner findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Long aLong) {
        super.delete(aLong);
    }

    @Override
    public void deleteByObject(Owner object) {
        super.deleteByObject(object);
    }
}
