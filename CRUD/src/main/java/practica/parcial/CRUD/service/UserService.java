package practica.parcial.CRUD.service;

import practica.parcial.CRUD.dto.UserDTO;

public interface UserService {

    void createUser(UserDTO userDTO);

    void deleteUser(String name);

    void updateUser(UserDTO userDTO);

    UserDTO queryUsers(String name);
}
