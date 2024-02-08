package com.projectx.service;

import com.projectx.model.User;
import com.projectx.model.UserProfile;
import com.projectx.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author vuktopalovic
 * @created 28/09/2023 - 16:36
 * @project projectx
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        if (userRepository.existsById(id)) {
            updatedUser.setId(id); // Ensure the ID of the updated user matches the provided ID
            return userRepository.save(updatedUser);
        }
        return null; // User with the given ID doesn't exist
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean isUsernameAvailable(String username) {
        User existingUser = userRepository.findByUsername(username);
        return existingUser == null;
    }

    @Override
    public boolean isEmailAvailable(String email) {
        User existingUser = userRepository.findByEmail(email);
        return existingUser == null;
    }

    @Override
    public List<User> searchUsers(String keyword) {
        return null;
    }

    @Override
    public User updateProfile(Long id, UserProfile userProfile) {
        return null;
    }

    @Override
    public boolean changePassword(Long id, String currentPassword, String newPassword) {
        return false;
    }


}
