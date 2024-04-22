package com.Ada.SFCAuthenticator.repository;

import com.Ada.SFCAuthenticator.model.UserVerifier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserVerifierRepository extends JpaRepository<UserVerifier, Long> {
}
