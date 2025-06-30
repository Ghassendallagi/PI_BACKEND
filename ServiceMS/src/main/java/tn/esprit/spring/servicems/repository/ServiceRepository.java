package tn.esprit.spring.servicems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.servicems.entity.ServiceOffer;

public interface ServiceRepository extends JpaRepository<ServiceOffer, Long> {

}