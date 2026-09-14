package za.ac.cput.service;

import za.ac.cput.domain.User;
import za.ac.cput.repository.IRepository;

/**
 * IUserService.java
 * Service contract for User business logic, mirrors the repository contract.
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 22/07/2026
 */
public interface IUserService extends IRepository<User, Long> {
}
