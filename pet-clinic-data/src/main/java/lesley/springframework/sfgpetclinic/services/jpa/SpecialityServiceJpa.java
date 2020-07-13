package lesley.springframework.sfgpetclinic.services.jpa;

import lesley.springframework.sfgpetclinic.model.Speciality;
import lesley.springframework.sfgpetclinic.services.SpecialtyService;

import java.util.Set;

public class SpecialityServiceJpa implements SpecialtyService {
    private SpecialtyService specialtyService;

    public SpecialityServiceJpa(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialtyService.findById(aLong);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialtyService.save(object);
    }

    @Override
    public Set<Speciality> findAll() {
        return specialtyService.findAll();
    }
}
