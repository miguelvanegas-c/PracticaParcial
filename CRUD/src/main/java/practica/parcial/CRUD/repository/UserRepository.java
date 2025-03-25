package practica.parcial.CRUD.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import practica.parcial.CRUD.model.User;

public interface UserRepository extends MongoRepository<User,String> {
    void deleteByName(String username);
    User findByName(String username);
}
