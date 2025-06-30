package tn.esprit.spring.servicems.service;

import tn.esprit.spring.servicems.entity.ServiceOffer;
import tn.esprit.spring.servicems.entity.ServiceClient;
import java.util.List;

public interface IServiceService {
    ServiceOffer createService(ServiceOffer service);
    List<ServiceOffer> getAllServices();
    ServiceOffer getServiceById(Long id);
    ServiceOffer updateService(Long id, ServiceOffer updated);
    void deleteService(Long id);
    double calculerTauxOccupation(Long id);
    ServiceOffer reserveSlot(Long serviceId);
    ServiceOffer decrement(Long serviceId);
}