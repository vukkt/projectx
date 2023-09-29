package com.projectx.services;

import com.projectx.models.User;

import java.util.List;

/**
 * @author vuktopalovic
 * @created 28/09/2023 - 16:35
 * @project projectx
 */
public interface UserService {
    User createUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(Long id, User updatedUser);

    void deleteUser(Long id);

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    boolean isUsernameAvailable(String username);

    boolean isEmailAvailable(String email);

    List<User> searchUsers(String keyword);

    User updateProfile(Long id, UserProfile userProfile);

    boolean changePassword(Long id, String currentPassword, String newPassword);
}
