package jana60.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import jana60.model.University;

@Repository
public interface UniversityRepository extends CrudRepository <University, Integer> {
	List<University> findAllByOrderByName();
}