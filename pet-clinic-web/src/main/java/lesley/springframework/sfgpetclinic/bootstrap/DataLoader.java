package lesley.springframework.sfgpetclinic.bootstrap;

import lesley.springframework.sfgpetclinic.model.Owner;
import lesley.springframework.sfgpetclinic.model.PetType;
import lesley.springframework.sfgpetclinic.model.Vet;
import lesley.springframework.sfgpetclinic.services.OwnerService;
import lesley.springframework.sfgpetclinic.services.PetTypeService;
import lesley.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private OwnerService ownerServiceMap;
    private VetService vetServiceMap;
    private PetTypeService petTypeServiceMap;

    public DataLoader(OwnerService ownerServiceMap, VetService vetServiceMap, PetTypeService petTypeServiceMap) {
        this.ownerServiceMap = ownerServiceMap;
        this.vetServiceMap = vetServiceMap;
        this.petTypeServiceMap = petTypeServiceMap;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeServiceMap.save(cat);

        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeServiceMap.save(dog);

        System.out.println("Loaded PetTypes");

        Owner micheal = new Owner();
        micheal.setFirstName("Micheal");
        micheal.setLastName("Weston");

        ownerServiceMap.save(micheal);

        Owner fiona = new Owner();
        fiona.setFirstName("Fiona");
        fiona.setLastName("Glenanne");
        ownerServiceMap.save(fiona);

        System.out.println("Loaded Owners......");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axxe");

        vetServiceMap.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Thomas");
        vet2.setLastName("Blachett");

        vetServiceMap.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Jessica");
        vet3.setLastName("Porta");

        vetServiceMap.save(vet3);

        System.out.println("Loaded Vets......");

    }
}
