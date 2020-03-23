package ua.testing.locale.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.testing.locale.dto.UserDTO;
import ua.testing.locale.dto.UsersDTO;
import ua.testing.locale.entity.User;
import ua.testing.locale.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public UsersDTO getAllUsers(){
        return new UsersDTO(userRepository.findAll());
    }

    public Optional<User> findByUserId (UserDTO userDTO){
        return userRepository.findById(userDTO.getId());
    }

    public void saveNewUser (User user){
        //TODO inform the user about the replay email
        // TODO exception to endpoint
        userRepository.save(user);
    }

    /*@PostConstruct
    public void init(){
        if (!userRepository.findById(8L).isPresent()){
            userRepository.save(User.builder()
                    .nameEng("Billy")
                    .nameUkr("Андрій")
                    .build());
        }
    }*/
}
