package za.ac.cput.controller;

import za.ac.cput.domain.User;
import za.ac.cput.service.IUserService;
import za.ac.cput.service.UserService;

import java.util.Set;

/**
 * UserController.java
 * Controller layer exposing CRUD operations for User to callers (e.g. a UI or
 * a future web layer). Plain Java singleton - no web framework on the classpath.
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 22/07/2026
 */
public class UserController {

    private static UserController controller = null;
    private final IUserService userService;

    private UserController() {
        this.userService = UserService.getService();
    }

    public static UserController getController() {
        if (controller == null) {
            controller = new UserController();
        }
        return controller;
    }

    public User create(User user) {
        return userService.create(user);
    }

    public User read(Long id) {
        return userService.read(id);
    }

    public User update(User user) {
        return userService.update(user);
    }

    public boolean delete(Long id) {
        return userService.delete(id);
    }

    public Set<User> getAll() {
        return userService.getAll();
    }
}
