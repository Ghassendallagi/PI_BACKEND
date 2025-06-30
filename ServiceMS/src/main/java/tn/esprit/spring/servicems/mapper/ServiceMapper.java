package tn.esprit.spring.servicems.mapper;

import org.mapstruct.Mapper;
import tn.esprit.spring.servicems.dto.ServiceOfferDTO;
import tn.esprit.spring.servicems.entity.ServiceOffer;

@Mapper(componentModel = "spring")
public interface ServiceMapper {
    ServiceOfferDTO toDto(ServiceOffer service);
    ServiceOffer toEntity(ServiceOfferDTO serviceDTO);
}