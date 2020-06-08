package lesley.springframework.sfgpetclinic.services;

import lesley.springframework.sfgpetclinic.model.Owner;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService extends  CrudService<Owner, Long> {
    Owner findByLastName(String lastname);
}
