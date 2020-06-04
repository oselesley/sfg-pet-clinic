package lesley.springframework.sfgpetclinic.services;

import lesley.springframework.sfgpetclinic.model.Vet;

public interface VetService extends CrudService<Vet, Long>{
    Vet findByLastName(String lastname);
}
