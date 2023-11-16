package upb.edu.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upb.edu.api.models.UserModel;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long>
{

}
