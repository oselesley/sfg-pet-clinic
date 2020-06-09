package lesley.springframework.sfgpetclinic.bootstrap;

import lesley.springframework.sfgpetclinic.model.Owner;
import lesley.springframework.sfgpetclinic.model.Vet;
import lesley.springframework.sfgpetclinic.services.OwnerService;
import lesley.springframework.sfgpetclinic.services.VetService;
import lesley.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import lesley.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private OwnerService ownerServiceMap;
    private VetService vetServiceMap;

    public DataLoader() {
        this.ownerServiceMap = new OwnerServiceMap();
        this.vetServiceMap = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner micheal = new Owner();
        micheal.setFirstName("Micheal");
        micheal.setLastName("Weston");
        micheal.setId(1L);
        ownerServiceMap.save(micheal);

        Owner fiona = new Owner();
        fiona.setFirstName("Fiona");
        fiona.setLastName("Glenanne");
        fiona.setId(2L);
        ownerServiceMap.save(fiona);

        System.out.println("Loaded Owners......");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axxe");
        vet1.setId(1L);

        vetServiceMap.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Thomas");
        vet2.setLastName("Blachett");
        vet2.setId(2L);

        vetServiceMap.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Jessica");
        vet3.setLastName("Porta");
        vet3.setId(2L);

        vetServiceMap.save(vet3);

        System.out.println("Loaded Vets......");

    }
}
