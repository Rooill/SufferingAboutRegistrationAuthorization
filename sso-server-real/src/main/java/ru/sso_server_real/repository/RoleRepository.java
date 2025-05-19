package ru.sso_server_real.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.sso_server_real.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
