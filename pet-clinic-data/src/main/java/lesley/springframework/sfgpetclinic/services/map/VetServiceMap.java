package lesley.springframework.sfgpetclinic.services.map;

import lesley.springframework.sfgpetclinic.model.Vet;
import lesley.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VetServiceMap extends  AbstractMapService<Long, Vet> implements VetService {
    private SpecialtyServiceMap specialtyServiceMap;

    public VetServiceMap(SpecialtyServiceMap specialtyServiceMap) {
        this.specialtyServiceMap = specialtyServiceMap;
    }

    @Override
    public Vet findByLastName(String lastname) {
        List<Vet> mapValues = (List) getAbstMap().values();

        for (Vet vet : mapValues) {
            if (vet.getLastName().equalsIgnoreCase(lastname))
                return vet;
        }

        return null;
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    speciality = specialtyServiceMap.save(speciality);
                }
            });

            return super.save(object);
        }
        return super.save(object);
    }
}
