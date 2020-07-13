package lesley.springframework.sfgpetclinic.services.map;

import lesley.springframework.sfgpetclinic.model.Visit;
import lesley.springframework.sfgpetclinic.services.VisitService;
import org.springframework.stereotype.Service;

@Service
public class VisitServiceMap extends AbstractMapService<Long, Visit> implements VisitService {
    @Override
    public Visit save(Visit object) {
        if (object.getPet() == null || object.getPet().getId() == null
                || object.getPet().getOwner() == null || object.getPet().getOwner().getId() == null)
            throw new RuntimeException("Invalid Visit");
        return super.save(object);
    }
}
