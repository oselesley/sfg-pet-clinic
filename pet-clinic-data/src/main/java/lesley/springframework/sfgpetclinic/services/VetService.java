package lesley.springframework.sfgpetclinic.services;

import lesley.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findByLastName(String lastname);

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
