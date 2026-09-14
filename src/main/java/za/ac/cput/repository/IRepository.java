package za.ac.cput.repository;

import java.util.Set;

/**
 * IRepository.java
 * Generic repository contract shared by all repositories in the system.
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 22/07/2026
 */
public interface IRepository<T, ID> {

    T create(T t);

    T read(ID id);

    T update(T t);

    boolean delete(ID id);

    Set<T> getAll();
}
