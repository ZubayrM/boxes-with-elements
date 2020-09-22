package project.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.model.Element;

@Repository
public interface ElementRepository extends CrudRepository<Element, Long> {

}
