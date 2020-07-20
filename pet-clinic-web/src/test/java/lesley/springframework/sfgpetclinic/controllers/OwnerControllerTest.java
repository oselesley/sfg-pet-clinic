package lesley.springframework.sfgpetclinic.controllers;

import lesley.springframework.sfgpetclinic.model.Owner;
import lesley.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.eq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
    @Mock
    OwnerService ownerService;

    @Mock
    Model model;

    @InjectMocks // we use inject mocks on OwnerController since it is the class we inted to test
    OwnerController ownerController;

    Set<Owner> owners = new HashSet<>();
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();

        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("John");
        owner.setLastName("Thompson");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Chad");
        owner2.setLastName("Darby");

        owners.add(owner);
        owners.add(owner2);

    }

    @Test
    void ownersMVCTest() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(get("/owners"))
                .andExpect(status().is(200))
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)))
                .andExpect(content().string(""));
    }

    @Test
    void ownersPage() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);
        ArgumentCaptor<Set<Owner>> acOwners = ArgumentCaptor.forClass(Set.class);
        assertEquals("owners/index", ownerController.ownersPage(model));

        verify(ownerService).findAll();
        verify(model, times(1)).addAttribute(eq("owners"), acOwners.capture());

        Set<Owner> ownersCapture = acOwners.getValue();

        assertEquals(2, ownersCapture.size());
    }

    @Test
    void find() throws Exception{
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notimplemented"));

        verifyNoInteractions(ownerService); // ensures that ownerservice wasn't invoked or called in find() method
    }
}