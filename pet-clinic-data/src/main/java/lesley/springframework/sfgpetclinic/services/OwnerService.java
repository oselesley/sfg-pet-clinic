package lesley.springframework.sfgpetclinic.services;

import lesley.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends  CrudService<Owner, Long> {
    Owner findByLastName(String lastname);
}
