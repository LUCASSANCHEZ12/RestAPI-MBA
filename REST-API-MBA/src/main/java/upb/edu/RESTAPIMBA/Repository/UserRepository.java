package upb.edu.RESTAPIMBA.Repository;

import org.springframework.stereotype.Repository;
import upb.edu.RESTAPIMBA.Models.User;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}