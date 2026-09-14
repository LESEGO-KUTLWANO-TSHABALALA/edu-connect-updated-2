package za.ac.cput.factory;

import org.apache.commons.validator.routines.EmailValidator;
import za.ac.cput.domain.User;

import java.time.LocalDateTime;

/**
 * UserFactory.java
 * Factory class responsible for creating validated User objects.
 * Author: Lesego Kutlwano Tshabalala (240263952)
 * Date: 22/07/2026
 */
public class UserFactory {

    private UserFactory() {
        // static factory, no instances
    }

    public static User createUser(Long userId,
                                  String name,
                                  String surname,
                                  String studentNumber,
                                  String email,
                                  String contactNumber,
                                  Boolean isTutor,
                                  Boolean isStudent) {

        if (isNullOrEmpty(name) || isNullOrEmpty(surname)) {
            return null;
        }
        if (isNullOrEmpty(email) || !EmailValidator.getInstance().isValid(email)) {
            return null;
        }

        return new User.Builder()
                .setUserId(userId)
                .setName(name)
                .setSurname(surname)
                .setStudentNumber(studentNumber)
                .setEmail(email)
                .setContactNumber(contactNumber)
                .setCreatedAt(LocalDateTime.now())
                .setIsTutor(isTutor != null && isTutor)
                .setIsStudent(isStudent != null && isStudent)
                .build();
    }

    private static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}