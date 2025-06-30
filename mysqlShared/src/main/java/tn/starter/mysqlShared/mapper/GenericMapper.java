package tn.starter.mysqlShared.mapper;
import java.util.List;

public interface GenericMapper<DTO,T> {
    T toEntity(DTO source);
    DTO toDto(T source);
    List<DTO> toListDto(List<T> source);
    void updateEntityFromDto(DTO dto, T entity); // ✅ Retourne l'objet mis à jour

}