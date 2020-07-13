package lesley.springframework.sfgpetclinic.bootstrap;

import lesley.springframework.sfgpetclinic.model.*;
import lesley.springframework.sfgpetclinic.services.*;
import lesley.springframework.sfgpetclinic.services.map.PetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private OwnerService ownerService;
    private VetService vetService;
    private PetService petService;
    private PetTypeService petTypeService;
    private SpecialtyService specialtyService;
    private VisitService visitService;


    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetService petService,
                      PetTypeService petTypeService,
                      SpecialtyService specialtyService,
                      VisitService visitService)
    {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) loadData();

    }

    private void loadData() {
        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        System.out.println("Loaded PetTypes");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Owner micheal = new Owner();
        micheal.setFirstName("Micheal");
        micheal.setLastName("Weston");
        micheal.setAddress("123 Brickerel");
        micheal.setCity("miami");
        micheal.setTelephone("123-456-775");
        micheal = ownerService.save(micheal);
        System.out.println(micheal.getId());


        Pet mikesPet = new Pet();
        mikesPet.setPetType(dog);
        mikesPet.setName("Rosco");
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setOwner(micheal);
        micheal.getPets().add(mikesPet);

        ownerService.save(micheal);

        Owner fiona = new Owner();
        fiona.setFirstName("Fiona");
        fiona.setLastName("Glenanne");
        fiona.setAddress("43 Glendale Ave");
        fiona.setTelephone("123-454-766");
        fiona.setCity("Philadelphia");
        ownerService.save(fiona);

        Pet fionasPet = new Pet();
        fionasPet.setPetType(cat);
        fionasPet.setName("chipper");
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet = petService.save(fionasPet);
        fiona.getPets().add(fionasPet);
        fionasPet.setOwner(fiona);
        fiona = ownerService.save(fiona);

        Visit dogVisit = new Visit();
        dogVisit.setPet(fionasPet);
        dogVisit.setDescription("Sneezy Doggy");
        dogVisit.setDate(LocalDate.now());
        visitService.save(dogVisit);


        System.out.println("Loaded Owners......");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axxe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Thomas");
        vet2.setLastName("Blachett");
        vet2.getSpecialities().add(savedDentistry);

        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Jessica");
        vet3.setLastName("Porta");
        vet3.getSpecialities().add(savedSurgery);

        vetService.save(vet3);

        System.out.println("Loaded Vets...");
    }
}
