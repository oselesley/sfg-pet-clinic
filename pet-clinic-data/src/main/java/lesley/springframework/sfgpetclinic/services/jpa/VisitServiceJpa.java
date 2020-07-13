package lesley.springframework.sfgpetclinic.services.jpa;

import lesley.springframework.sfgpetclinic.model.Visit;
import lesley.springframework.sfgpetclinic.repositories.VisitRepository;
import lesley.springframework.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile(value = "springdatajpa")
public class VisitServiceJpa implements VisitService {
    private final VisitRepository visitRepository;

    public VisitServiceJpa(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }
}
