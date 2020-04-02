package com.store.springwebapp.repository;

import com.store.springwebapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @SuppressWarnings("unchecked")
    User save(User user);

    @Query("FROM User WHERE username = :username")
    Optional<User> findByUsername(String username);
}
