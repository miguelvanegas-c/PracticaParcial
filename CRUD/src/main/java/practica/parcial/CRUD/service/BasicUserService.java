package practica.parcial.CRUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practica.parcial.CRUD.dto.UserDTO;
import practica.parcial.CRUD.model.User;
import practica.parcial.CRUD.repository.UserRepository;

@Service
public class BasicUserService implements UserService {
    @Autowired
    private UserRepository userRepoository;

    public void createUser(UserDTO userDTO){
        String name = userDTO.getName();
        String role = userDTO.getRole();
        User userExist = userRepoository.findByName(name);
        if(userExist != null){
            throw new IllegalArgumentException("El usuario ya existe");
        }
        User user = new User();
        user.setRole(role);
        user.setName(name);
        userRepoository.save(user);
    }

    public void deleteUser(String name){
        User user = userRepoository.findByName(name);
        valideUserExist(user);
        userRepoository.deleteByName(name);
    }

    public void updateUser(UserDTO userDTO){
        String name = userDTO.getName();
        String role = userDTO.getRole();
        User user = userRepoository.findByName(name);
        valideUserExist(user);
        user.setRole(role);
        userRepoository.save(user);

    }

    public UserDTO queryUsers(String name){
        User user = userRepoository.findByName(name);
        valideUserExist(user);
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setRole(user.getRole());
        return userDTO;
    }

    private void valideUserExist(User user){
        if(user == null){
            throw new IllegalArgumentException("El usuario no existe");
        }
    }
}
