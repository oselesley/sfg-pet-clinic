package lesley.springframework.sfgpetclinic.services.jpa;

import lesley.springframework.sfgpetclinic.model.Owner;
import lesley.springframework.sfgpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.mockito.ArgumentMatchers.any;

import java.util.*;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {
    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerServiceJpa ownerServiceJpa;

    Map<Long, Owner> owners = new HashMap<>();

    @BeforeEach
    void setUp() {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("John");
        owner.setLastName("Thompson");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Chad");
        owner2.setLastName("Darby");

        owners.put(owner.getId(), owner);
        owners.put(owner2.getId(), owner2);
    }

    @Test
    void findByLastName() {
        Optional<Owner> opOwner = Optional.of(owners.get(1L));
        Optional<Owner> opOwner2 = Optional.of(owners.get(2L));

        ArgumentCaptor<String> ac = ArgumentCaptor.forClass(String.class);

        when(ownerRepository.findOwnerByLastName(any())).thenReturn(opOwner, opOwner2);

        Owner foundOwner = ownerServiceJpa.findByLastName("Thompson");
        assertEquals(1L, foundOwner.getId());
        assertEquals("John", foundOwner.getFirstName());
        verify(ownerRepository).findOwnerByLastName(ac.capture());
        assertEquals("Thompson", ac.getValue());

        foundOwner = ownerServiceJpa.findByLastName("Darby");
        assertEquals(2L, foundOwner.getId());
        assertEquals("Chad", foundOwner.getFirstName());
        verify(ownerRepository, times(2)).findOwnerByLastName(ac.capture());
        assertEquals("Darby", ac.getValue());
    }

    @Test
    void findById() {
        Optional<Owner> opOwner = Optional.of(owners.get(1L));
        Optional<Owner> opOwner2 = Optional.of(owners.get(2L));

        ArgumentCaptor<Long> ac = ArgumentCaptor.forClass(Long.class);
        when(ownerRepository.findById(anyLong())).thenReturn(opOwner);

        Owner foundOwner = ownerServiceJpa.findById(1L);
        assertNotNull(foundOwner);
        assertEquals("John", foundOwner.getFirstName());
        assertEquals("Thompson", foundOwner.getLastName());

        verify(ownerRepository, times(2)).findById(ac.capture());
        assertEquals(1L, ac.getValue().longValue());


    }

    @Test
    void save() {
        Owner owner3 = new Owner();
        owner3.setId(3L);
        owner3.setFirstName("Leslie");
        owner3.setLastName("Okoduwa");

        when(ownerRepository.save(any())).thenReturn(owner3);

        ArgumentCaptor<Owner> acOwner = ArgumentCaptor.forClass(Owner.class);
        Owner savedOwner = ownerServiceJpa.save(owner3);

        assertNotNull(savedOwner);
        assertEquals("Leslie", savedOwner.getFirstName());
        assertEquals("Okoduwa", savedOwner.getLastName());
        assertEquals(3L, savedOwner.getId());

        verify(ownerRepository).save(acOwner.capture());

        assertEquals("Leslie", acOwner.getValue().getFirstName());
        assertEquals(3L, acOwner.getValue().getId());

    }

    @Test
    void findAll() {
        when(ownerRepository.findAll()).thenReturn(owners.values());
        assertEquals(2, ownerServiceJpa.findAll().size());
    }
}