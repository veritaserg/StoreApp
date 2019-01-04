package com.store.springwebapp.repository;

import com.store.springwebapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @SuppressWarnings("unchecked")
    User save(User user);

    Optional<User> findByUsername(String username);
}
