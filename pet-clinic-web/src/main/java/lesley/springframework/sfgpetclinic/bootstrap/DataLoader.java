package lesley.springframework.sfgpetclinic.bootstrap;

import lesley.springframework.sfgpetclinic.model.*;
import lesley.springframework.sfgpetclinic.services.OwnerService;
import lesley.springframework.sfgpetclinic.services.PetTypeService;
import lesley.springframework.sfgpetclinic.services.SpecialtyService;
import lesley.springframework.sfgpetclinic.services.VetService;
import lesley.springframework.sfgpetclinic.services.map.PetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private OwnerService ownerServiceMap;
    private VetService vetServiceMap;
    private PetServiceMap petServiceMap;
    private PetTypeService petTypeServiceMap;
    private SpecialtyService specialtyServiceMap;


    public DataLoader(OwnerService ownerServiceMap,
                      VetService vetServiceMap,
                      PetServiceMap petServiceMap,
                      PetTypeService petTypeServiceMap,
                      SpecialtyService specialtyServiceMap)
    {
        this.ownerServiceMap = ownerServiceMap;
        this.vetServiceMap = vetServiceMap;
        this.petServiceMap = petServiceMap;
        this.petTypeServiceMap = petTypeServiceMap;
        this.specialtyServiceMap = specialtyServiceMap;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeServiceMap.findAll().size();
        if (count == 0) loadData();

    }

    private void loadData() {
        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeServiceMap.save(cat);

        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeServiceMap.save(dog);

        System.out.println("Loaded PetTypes");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyServiceMap.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtyServiceMap.save(dentistry);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyServiceMap.save(surgery);

        Owner micheal = new Owner();
        micheal.setFirstName("Micheal");
        micheal.setLastName("Weston");
        micheal.setAddress("123 Brickerel");
        micheal.setCity("miami");
        micheal.setTelephone("123-456-775");
        ownerServiceMap.save(micheal);
        System.out.println(micheal.getId());


        Pet mikesPet = new Pet();
        mikesPet.setPetType(dog);
        mikesPet.setName("Rosco");
        mikesPet.setBirthDate(LocalDate.now());
//        mikesPet.setOwner(micheal);
        micheal.getPets().add(mikesPet);

        ownerServiceMap.save(micheal);

        Owner fiona = new Owner();
        fiona.setFirstName("Fiona");
        fiona.setLastName("Glenanne");
        fiona.setAddress("43 Glendale Ave");
        fiona.setTelephone("123-454-766");
        fiona.setCity("Philadelphia");
        ownerServiceMap.save(fiona);

        Pet fionasPet = new Pet();
        fionasPet.setPetType(dog);
//        fionasPet.setOwner(micheal);
        fionasPet.setName("Rosco");
        fionasPet.setBirthDate(LocalDate.now());
        fiona.getPets().add(fionasPet);
//        fionasPet.setOwner(fiona);
        fiona = ownerServiceMap.save(fiona);


        System.out.println("Loaded Owners......");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axxe");
        vet1.getSpecialities().add(savedRadiology);

        vetServiceMap.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Thomas");
        vet2.setLastName("Blachett");
        vet2.getSpecialities().add(savedDentistry);

        vetServiceMap.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Jessica");
        vet3.setLastName("Porta");
        vet3.getSpecialities().add(savedSurgery);

        vetServiceMap.save(vet3);

        System.out.println("Loaded Vets...");
    }
}
