package lesley.springframework.sfgpetclinic.services;

import lesley.springframework.sfgpetclinic.model.Owner;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService extends  CrudService<Long, Owner> {
    Owner findByLastName(String lastname);
}
