package jana60.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jana60.model.Degrees;
@Repository
public interface DegreesRepository extends CrudRepository<Degrees, Integer> {

}
