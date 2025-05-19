package ru.sso_server_real.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.sso_server_real.AuthUser;

public interface UserRepository extends JpaRepository<AuthUser, Long> {
	AuthUser findByUsername(String username);
	AuthUser findByEmail(String email);
}
