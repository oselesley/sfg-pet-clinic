package lesley.springframework.sfgpetclinic.services;

import lesley.springframework.sfgpetclinic.model.Vet;
import org.springframework.stereotype.Service;

@Service
public interface VetService extends CrudService<Vet, Long>{
    Vet findByLastName(String lastname);
}
