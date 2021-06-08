
package net.javaguides.springbootsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springbootsecurity.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{
	
}
