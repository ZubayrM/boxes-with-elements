package project.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.model.Elements;

@Repository
public interface ElementsRepository extends CrudRepository<Elements, Long> {
}
