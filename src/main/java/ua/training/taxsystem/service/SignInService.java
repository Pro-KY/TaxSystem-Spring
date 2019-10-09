package ua.training.taxsystem.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.training.taxsystem.persistence.dao.IUserDao;
import ua.training.taxsystem.persistence.entities.User;

import java.util.Optional;
@Log4j2
@Service
@AllArgsConstructor
public class SignInService {
    private final IUserDao userDao;

    @Transactional(readOnly = true)
    public Optional<User> getAuthorizedUser(String email, String password) {
        final Optional<User> foundUser = userDao.findByEmailAndPassword(email, password);
        foundUser.ifPresent(user -> user.setPassword(null));
        return foundUser;
    }
}
