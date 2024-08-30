package de.ait.shop43.security;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    public Role findRoleByTitle (String title);

}
