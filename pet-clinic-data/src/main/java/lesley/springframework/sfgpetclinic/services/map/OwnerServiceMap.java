package lesley.springframework.sfgpetclinic.services.map;

import lesley.springframework.sfgpetclinic.model.Owner;
import lesley.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceMap extends AbstractMapService<Long, Owner> implements OwnerService {

    @Override
    public Owner findByLastName(String lastname) {
        List<Owner> mapIterator = (List) getAbstMap().values();

        for (Owner owner : mapIterator) {
            if (owner.getLastName().equalsIgnoreCase(lastname)) return  owner;
        }

        return  null;
    }

}