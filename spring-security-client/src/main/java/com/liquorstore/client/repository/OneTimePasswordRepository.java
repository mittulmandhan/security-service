package com.liquorstore.client.repository;

import com.liquorstore.client.entity.OneTimePassword;
import com.liquorstore.client.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OneTimePasswordRepository extends JpaRepository<OneTimePassword, Long> {
    OneTimePassword findByOtp(String userInputOtp);

    OneTimePassword findByUser(User byEmail);
}
