package project.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.model.Elements;

import java.util.List;

@Repository
public interface ElementsRepository extends CrudRepository<Elements, Long> {

    @Query("from Elements")
    List<Elements> getAll();

}
