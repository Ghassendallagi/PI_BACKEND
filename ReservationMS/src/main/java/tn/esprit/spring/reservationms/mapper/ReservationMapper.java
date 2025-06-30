package tn.esprit.spring.reservationms.mapper;
import tn.starter.mongoShared.dto.auteurDTO;
import tn.esprit.spring.reservationms.entity.Reservation;
import tn.starter.mongoShared.mapper.GenericMapper;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")

public interface ReservationMapper extends GenericMapper<auteurDTO, Reservation> {

}