package com.Jvnyor.bds04.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Jvnyor.bds04.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long > {

}
