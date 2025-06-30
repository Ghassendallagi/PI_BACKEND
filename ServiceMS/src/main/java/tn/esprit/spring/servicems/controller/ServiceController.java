package tn.esprit.spring.servicems.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.servicems.entity.ServiceOffer;
import tn.esprit.spring.servicems.service.IServiceService;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private final IServiceService service;

    public ServiceController(IServiceService service) {
        this.service = service;
    }

    @PostMapping
    public ServiceOffer create(@RequestBody ServiceOffer serviceOffer) {
        return service.createService(serviceOffer);
    }

    @GetMapping
    public List<ServiceOffer> getAll() {
        return service.getAllServices();
    }

    @GetMapping("/{id}")
    public ServiceOffer getById(@PathVariable Long id) {
        return service.getServiceById(id);
    }

    @PutMapping("/{id}")
    public ServiceOffer update(@PathVariable Long id, @RequestBody ServiceOffer updated) {
        return service.updateService(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteService(id);
    }

    @GetMapping("/{id}/occupation-rate")
    public double getOccupationRate(@PathVariable Long id) {
        return service.calculerTauxOccupation(id);
    }
    @PostMapping("/{id}/reserve")
    public ServiceOffer reserveSlot(@PathVariable Long id) {
        return service.reserveSlot(id);
    }
    @PostMapping("/{id}/decrement")
    public ServiceOffer decrement(@PathVariable Long id) {
        return service.decrement(id);
    }

}