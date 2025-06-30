package tn.esprit.spring.servicems.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import tn.esprit.spring.servicems.entity.ServiceOffer;
import tn.esprit.spring.servicems.repository.ServiceRepository;

import java.util.Optional;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServiceServiceImplTest {

    @Mock
    private ServiceRepository repository;

    @InjectMocks
    private ServiceServiceImpl service;

    private ServiceOffer serviceOffer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        serviceOffer = new ServiceOffer();
        serviceOffer.setId(1L);
        serviceOffer.setName("Service Test");
        serviceOffer.setCapacity(10);
        serviceOffer.setReservedSlots(5);
    }

    @Test
    void testCreateService() {
        when(repository.save(any())).thenReturn(serviceOffer);

        ServiceOffer created = service.createService(serviceOffer);

        assertNotNull(created);
        assertEquals("Service Test", created.getName());
        verify(repository, times(1)).save(serviceOffer);
    }

    @Test
    void testGetServiceById_found() {
        when(repository.findById(1L)).thenReturn(Optional.of(serviceOffer));

        ServiceOffer result = service.getServiceById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void testGetAllServices() {
        List<ServiceOffer> list = Arrays.asList(serviceOffer);
        when(repository.findAll()).thenReturn(list);

        List<ServiceOffer> result = service.getAllServices();

        assertEquals(1, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testReserveSlot_success() {
        when(repository.findById(1L)).thenReturn(Optional.of(serviceOffer));
        when(repository.save(any())).thenReturn(serviceOffer);

        ServiceOffer reserved = service.reserveSlot(1L);

        assertEquals(6, reserved.getReservedSlots());
        verify(repository, times(1)).save(any());
    }

    @Test
    void testReserveSlot_fullCapacity() {
        serviceOffer.setReservedSlots(10);
        when(repository.findById(1L)).thenReturn(Optional.of(serviceOffer));

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> service.reserveSlot(1L));

        assertEquals("No available slots for this service", exception.getMessage());
    }

    @Test
    void testCalculerTauxOccupation() {
        when(repository.findById(1L)).thenReturn(Optional.of(serviceOffer));

        double taux = service.calculerTauxOccupation(1L);

        assertEquals(50.0, taux);
    }

    @Test
    void testDecrement_success() {
        when(repository.findById(1L)).thenReturn(Optional.of(serviceOffer));
        when(repository.save(any())).thenReturn(serviceOffer);

        ServiceOffer decremented = service.decrement(1L);

        assertEquals(4, decremented.getReservedSlots());
    }

    @Test
    void testDecrement_zeroReserved() {
        serviceOffer.setReservedSlots(0);
        when(repository.findById(1L)).thenReturn(Optional.of(serviceOffer));

        assertThrows(RuntimeException.class, () -> service.decrement(1L));
    }
}
