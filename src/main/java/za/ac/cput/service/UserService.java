package za.ac.cput.service;

import za.ac.cput.domain.User;
import za.ac.cput.repository.IUserRepository;
import za.ac.cput.repository.UserRepositoryImpl;
import za.ac.cput.service.IUserService;

import java.util.Set;

/**
 * UserServiceImpl.java
 * Service implementation for User, delegates persistence to IUserRepository.
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 22/07/2026
 */
public class UserService implements IUserService {

    private static UserService service = null;
    private final IUserRepository userRepository;

    private UserService() {
        this.userRepository = UserRepositoryImpl.getRepository();
    }

    public static UserService getService() {
        if (service == null) {
            service = new UserService();
        }
        return service;
    }

    @Override
    public User create(User user) {
        return userRepository.create(user);
    }

    @Override
    public User read(Long id) {
        return userRepository.read(id);
    }

    @Override
    public User update(User user) {
        return userRepository.update(user);
    }

    @Override
    public boolean delete(Long id) {
        return userRepository.delete(id);
    }

    @Override
    public Set<User> getAll() {
        return userRepository.getAll();
    }
}
