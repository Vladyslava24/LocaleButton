package ua.testing.locale.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.testing.locale.MessagesConstants;
import ua.testing.locale.dto.UsersDTO;
import ua.testing.locale.repository.UserRepository;

import java.util.Locale;
import java.util.ResourceBundle;

@Slf4j
@Service
public class LocaleService {
    private final UserRepository userRepository;
    private ResourceBundle bundle;
    private Locale locale;
    static String BUNDLE_NAME = "message";

    @Autowired
    public LocaleService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.bundle = ResourceBundle.getBundle(BUNDLE_NAME, new Locale("en"));
    }

    public void setLocale(Locale locale) {
        this.bundle = ResourceBundle.getBundle(
                BUNDLE_NAME, locale);
    }

    public void print() {
        System.out.println(bundle.getString(MessagesConstants.LOCALE_DATA));
    }

    public UsersDTO getAllUsers() {
        return new UsersDTO(userRepository.findAll());
    }

    /*public void saveNewUser (User user){
        //TODO inform the user about the replay email
        // TODO exception to endpoint
        userRepository.save(user);
    }*/

    /*public Optional<User> findByUserId (User user){
        return userRepository.findById(user.getId());
    }*/
}