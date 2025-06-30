package tn.starter.mysqlShared.service;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.starter.mysqlShared.mapper.GenericMapper;
import java.util.List;

@Slf4j
public class IGenericServiceImpl <DTO,T,ID> implements IGenericService<DTO,ID> {

    @Autowired
    JpaRepository<T, ID> repository;
    @Autowired
    GenericMapper<DTO, T> mapper;

    @Override
    public DTO add(DTO dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    @Transactional
    public DTO update(DTO dto) {
        ID id = getIdFromDto(dto); // Extract the ID from DTO (method to be implemented)

        T existingEntity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Entity not found with ID: " + id));

        mapper.updateEntityFromDto(dto, existingEntity); // Update fields on the existing entity

        return mapper.toDto(repository.save(existingEntity));
    }
    private ID getIdFromDto(DTO dto) {
        try {
            var method = dto.getClass().getMethod("id"); // Assuming "id" is the field name
            return (ID) method.invoke(dto);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to extract ID from DTO", e);
        }
    }

    @Override
    public DTO retrieveById(ID id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(new StringBuilder("No ")
                                .append(this.getClass().getSimpleName())
                                .append(" found with this id").toString()
                        )));
    }

    @Override
    public List<DTO> retrieveAll() {
        return mapper.toListDto(repository.findAll()) ;
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }

}