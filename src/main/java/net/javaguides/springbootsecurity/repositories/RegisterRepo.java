package net.javaguides.springbootsecurity.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.javaguides.springbootsecurity.entities.Register;
import net.javaguides.springbootsecurity.entities.User;

@Repository
public interface RegisterRepo extends JpaRepository<Register, Long>{
	Optional<User> findByEmail(String email);
}
