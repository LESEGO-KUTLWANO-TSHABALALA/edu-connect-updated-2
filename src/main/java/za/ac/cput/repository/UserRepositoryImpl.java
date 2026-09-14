package za.ac.cput.repository;

import za.ac.cput.domain.User;
import za.ac.cput.repository.IUserRepository;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * UserRepositoryImpl.java
 * In-memory implementation of IUserRepository, keyed by userId.
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 22/07/2026
 */
public class UserRepositoryImpl implements IUserRepository {

    private static UserRepositoryImpl repository = null;
    private final Map<Long, User> database;

    private UserRepositoryImpl() {
        database = new LinkedHashMap<>();
    }

    public static UserRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new UserRepositoryImpl();
        }
        return repository;
    }

    @Override
    public User create(User user) {
        if (user == null || user.getUserId() == null) {
            return null;
        }
        database.put(user.getUserId(), user);
        return user;
    }

    @Override
    public User read(Long id) {
        if (id == null) {
            return null;
        }
        return database.get(id);
    }

    @Override
    public User update(User user) {
        if (user == null || user.getUserId() == null || !database.containsKey(user.getUserId())) {
            return null;
        }
        database.put(user.getUserId(), user);
        return user;
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
    public Set<User> getAll() {
        return new LinkedHashSet<>(database.values());
    }
}