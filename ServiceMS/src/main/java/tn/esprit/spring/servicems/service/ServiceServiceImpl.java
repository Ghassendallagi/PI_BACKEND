package tn.esprit.spring.servicems.service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.servicems.entity.ServiceOffer;
import tn.esprit.spring.servicems.entity.ServiceClient;
import tn.esprit.spring.servicems.feignClients.ClientClient;
import tn.esprit.spring.servicems.repository.ServiceRepository;

import java.util.List;

@Service

public class ServiceServiceImpl implements IServiceService {

    private final ServiceRepository repository;
    @Autowired(required = false)
    private ClientClient clientClient;

    @Autowired
    public ServiceServiceImpl(ServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public ServiceOffer createService(ServiceOffer service) {
        return repository.save(service);
    }

    @Override
    public List<ServiceOffer> getAllServices() {
        return repository.findAll();
    }

    @Override
    public ServiceOffer getServiceById(Long id) {
        return repository.findById(id).orElse(null);
    }
    @Override
    public ServiceOffer updateService(Long id, ServiceOffer updated) {
        ServiceOffer existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Service non trouvé"));
        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        existing.setPrice(updated.getPrice());
        existing.setDuration(updated.getDuration());
        existing.setClientId(updated.getClientId());
        existing.setCapacity(updated.getCapacity());
        existing.setReservedSlots(updated.getReservedSlots());
        return repository.save(existing);
    }
    @Override
    public void deleteService(Long id) {
        repository.deleteById(id);
    }
    @Override
    public double calculerTauxOccupation(Long id) {
        ServiceOffer service = repository.findById(id).orElseThrow(() -> new RuntimeException("Service non trouvé"));
        if (service.getCapacity() == null || service.getCapacity() == 0) return 0.0;
        return ((double) service.getReservedSlots() / service.getCapacity()) * 100;
    }
    // ServiceServiceImpl.java
    @Override
    public ServiceOffer reserveSlot(Long serviceId) {
        ServiceOffer service = repository.findById(serviceId).orElse(null);
        if (service == null) {
            throw new RuntimeException("Service not found");
        }

        if (service.getReservedSlots() >= service.getCapacity()) {
            throw new RuntimeException("No available slots for this service");
        }

        service.setReservedSlots(service.getReservedSlots() + 1);
        return repository.save(service);
    }
    public ServiceOffer decrement(Long serviceId) {
        ServiceOffer service = repository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        if (service.getReservedSlots() <= 0) {
            throw new RuntimeException("No reserved slots to decrement");
        }

        service.setReservedSlots(service.getReservedSlots() - 1);
        return repository.save(service);
    }



}