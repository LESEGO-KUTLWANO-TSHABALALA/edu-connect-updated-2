package za.ac.cput.repository;

import za.ac.cput.domain.UserAuth;
import za.ac.cput.repository.IUserAuthRepository;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * UserAuthRepositoryImpl.java
 * In-memory implementation of IUserAuthRepository, keyed by authId.
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 22/07/2026
 */
public class UserAuthRepositoryImpl implements IUserAuthRepository {

    private static UserAuthRepositoryImpl repository = null;
    private final Map<Long, UserAuth> database;

    private UserAuthRepositoryImpl() {
        database = new LinkedHashMap<>();
    }

    public static UserAuthRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new UserAuthRepositoryImpl();
        }
        return repository;
    }

    @Override
    public UserAuth create(UserAuth userAuth) {
        if (userAuth == null || userAuth.getAuthId() == null) {
            return null;
        }
        database.put(userAuth.getAuthId(), userAuth);
        return userAuth;
    }

    @Override
    public UserAuth read(Long id) {
        if (id == null) {
            return null;
        }
        return database.get(id);
    }

    @Override
    public UserAuth update(UserAuth userAuth) {
        if (userAuth == null || userAuth.getAuthId() == null || !database.containsKey(userAuth.getAuthId())) {
            return null;
        }
        database.put(userAuth.getAuthId(), userAuth);
        return userAuth;
    }

    @Override
    public boolean delete(Long id) {
        if (id == null || !database.containsKey(id)) {
            return false;
        }
        database.remove(id);
        return true;
    }

    @Override
    public Set<UserAuth> getAll() {
        return new LinkedHashSet<>(database.values());
    }
}