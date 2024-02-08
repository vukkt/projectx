package com.projectx.repository;

import com.projectx.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author vuktopalovic
 * @created 29/09/2023 - 17:12
 * @project projectx
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Create (Save) a User
    User save(User user);

    // Read (Retrieve) a User by ID
    Optional<User> findById(Long id);

    // Read (Retrieve) all Users
    List<User> findAll();

    // Delete a User by ID
    void deleteById(Long id);

    User findByEmail(String email);

    User findByUsername(String username);
}
