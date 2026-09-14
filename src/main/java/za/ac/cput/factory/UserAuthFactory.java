package za.ac.cput.factory;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import za.ac.cput.domain.User;
import za.ac.cput.domain.UserAuth;

import java.time.LocalDateTime;

/**
 * UserAuthFactory.java
 * Factory class responsible for creating validated UserAuth objects.
 * Raw passwords are hashed with BCrypt before the UserAuth is built, so a
 * plain-text password is never stored on the domain object.
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 22/07/2026
 */
public class UserAuthFactory {

    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    private UserAuthFactory() {
        // static factory, no instances
    }

    /**
     * @param authId       primary key
     * @param rawPassword  the plain-text password supplied by the user; this
     *                     method hashes it before it ever reaches the domain object
     * @param user         the User this credential belongs to
     */
    public static UserAuth createUserAuth(Long authId,
                                          String rawPassword,
                                          User user) {

        if (rawPassword == null || rawPassword.trim().isEmpty()) {
            return null;
        }
        if (user == null) {
            return null;
        }

        String hashed = ENCODER.encode(rawPassword);

        return new UserAuth.Builder()
                .setAuthId(authId)
                .passwordHash(hashed)
                .setLastLogin(LocalDateTime.now())
                .setUser(user)
                .build();
    }

    /**
     * Verifies a raw password against a previously hashed one.
     */
    public static boolean matches(String rawPassword, String hashedPassword) {
        if (rawPassword == null || hashedPassword == null) {
            return false;
        }
        return ENCODER.matches(rawPassword, hashedPassword);
    }
}