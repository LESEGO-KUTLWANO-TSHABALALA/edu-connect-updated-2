package za.ac.cput.service;

import za.ac.cput.domain.UserAuth;
import za.ac.cput.repository.IRepository;

/**
 * IUserAuthService.java
 * Service contract for UserAuth business logic, mirrors the repository contract.
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 22/07/2026
 */
public interface IUserAuthService extends IRepository<UserAuth, Long> {
}
