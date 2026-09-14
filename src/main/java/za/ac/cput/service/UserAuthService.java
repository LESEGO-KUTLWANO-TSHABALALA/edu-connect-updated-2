package za.ac.cput.service;

import za.ac.cput.domain.UserAuth;
import za.ac.cput.factory.UserAuthFactory;
import za.ac.cput.repository.IUserAuthRepository;
import za.ac.cput.repository.UserAuthRepositoryImpl;
import za.ac.cput.service.IUserAuthService;

import java.util.Set;

/**
 * UserAuthServiceImpl.java
 * Service implementation for UserAuth, delegates persistence to IUserAuthRepository.
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 22/07/2026
 */
public class UserAuthService implements IUserAuthService {

    private static UserAuthService service = null;
    private final IUserAuthRepository userAuthRepository;

    private UserAuthService() {
        this.userAuthRepository = UserAuthRepositoryImpl.getRepository();
    }

    public static UserAuthService getService() {
        if (service == null) {
            service = new UserAuthService();
        }
        return service;
    }

    @Override
    public UserAuth create(UserAuth userAuth) {
        return userAuthRepository.create(userAuth);
    }

    @Override
    public UserAuth read(Long id) {
        return userAuthRepository.read(id);
    }

    @Override
    public UserAuth update(UserAuth userAuth) {
        return userAuthRepository.update(userAuth);
    }

    @Override
    public boolean delete(Long id) {
        return userAuthRepository.delete(id);
    }

    @Override
    public Set<UserAuth> getAll() {
        return userAuthRepository.getAll();
    }

    /**
     * Checks a raw login password against the stored hash for the given UserAuth.
     */
    public boolean login(Long authId, String rawPassword) {
        UserAuth userAuth = userAuthRepository.read(authId);
        if (userAuth == null) {
            return false;
        }
        return UserAuthFactory.matches(rawPassword, userAuth.getPasswordHash());
    }
}