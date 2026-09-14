package za.ac.cput.controller;

import za.ac.cput.domain.UserAuth;
import za.ac.cput.service.IUserAuthService;
import za.ac.cput.service.UserAuthService;

import java.util.Set;

/**
 * UserAuthController.java
 * Controller layer exposing CRUD operations for UserAuth to callers (e.g. a UI
 * or a future web layer). Plain Java singleton - no web framework on the classpath.
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 22/07/2026
 */
public class UserAuthController {

    private static UserAuthController controller = null;
    private final IUserAuthService userAuthService;

    private UserAuthController() {
        this.userAuthService = UserAuthService.getService();
    }

    public static UserAuthController getController() {
        if (controller == null) {
            controller = new UserAuthController();
        }
        return controller;
    }

    public UserAuth create(UserAuth userAuth) {
        return userAuthService.create(userAuth);
    }

    public UserAuth read(Long id) {
        return userAuthService.read(id);
    }

    public UserAuth update(UserAuth userAuth) {
        return userAuthService.update(userAuth);
    }

    public boolean delete(Long id) {
        return userAuthService.delete(id);
    }

    public Set<UserAuth> getAll() {
        return userAuthService.getAll();
    }

    public boolean login(Long authId, String rawPassword) {
        return ((UserAuthService) userAuthService).login(authId, rawPassword);
    }
}
