package tn.starter.mysqlShared.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository <T,ID> extends JpaRepository<T, ID> {
}
