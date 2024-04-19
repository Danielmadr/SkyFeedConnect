package com.Ada.SkyFeedConnect.repository;

import com.Ada.SkyFeedConnect.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
