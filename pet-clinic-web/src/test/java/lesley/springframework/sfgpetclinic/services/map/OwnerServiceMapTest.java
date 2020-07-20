package lesley.springframework.sfgpetclinic.services.map;

import lesley.springframework.sfgpetclinic.model.Owner;
import lesley.springframework.sfgpetclinic.services.PetService;
import lesley.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OwnerServiceMapTest {
    @Mock
    PetService petService;

    @Mock
    PetTypeService petTypeService;

    @Mock
    AbstractMapService<Long, Owner> abstractMapService;

    OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ownerServiceMap = new OwnerServiceMap(petService, petTypeService);

        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("John");
        owner.setLastName("Thompson");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Chad");
        owner2.setLastName("Darby");

        ownerServiceMap.save(owner);
        ownerServiceMap.save(owner2);
    }

    @Test
    void findByLastName() {
        Owner foundOwner = ownerServiceMap.findByLastName("Darby");
        assertEquals("Darby", foundOwner.getLastName());
    }

    @Test
    void save() {
        Owner owner = new Owner();
        owner.setId(3L);
        owner.setFirstName("Leslie");
        owner.setLastName("Okoduwa");

        Owner savedOwner = ownerServiceMap.save(owner);

        assertEquals(3, ownerServiceMap.findAll().size());
        assertEquals("Leslie", savedOwner.getFirstName());
        assertEquals("Okoduwa", savedOwner.getLastName());
    }

    @Test
    void findByID() {
        Owner chad = ownerServiceMap.findById(2L);
        assertEquals("Chad", chad.getFirstName());
        assertEquals("Darby", chad.getLastName());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(2, owners.size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(1L);
        Set<Owner> owners = ownerServiceMap.findAll();
        Owner john = ownerServiceMap.findById(1L);
        assertEquals(1, owners.size());
        assertNull(john);
    }

    @Test
    void deleteByObject() {
        Owner owner = new Owner();
        owner.setId(3L);
        owner.setFirstName("Samurai");
        owner.setLastName("Shamploo");

        ownerServiceMap.save(owner);
        ownerServiceMap.deleteByObject(owner);

        assertEquals(2, ownerServiceMap.findAll().size());
        assertEquals(null, ownerServiceMap.findById(3L));
        assertEquals(null, ownerServiceMap.findByLastName("Shamploo"));
    }
}