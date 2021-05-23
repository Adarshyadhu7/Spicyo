package net.javaguides.springbootsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.javaguides.springbootsecurity.entities.Register;

@Repository
public interface RegisterRepo extends JpaRepository<Register, Long>{
	
}
