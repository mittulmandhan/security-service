package com.liquorstore.client.repository;

import com.liquorstore.client.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
