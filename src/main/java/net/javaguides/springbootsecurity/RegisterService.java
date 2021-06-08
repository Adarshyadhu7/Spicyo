package net.javaguides.springbootsecurity;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import net.javaguides.springbootsecurity.entities.Register;
import net.javaguides.springbootsecurity.entities.Role;
import net.javaguides.springbootsecurity.repositories.RegisterRepo;
import net.javaguides.springbootsecurity.repositories.RoleRepo;

@Service
public class RegisterService{
	@Autowired
	private RegisterRepo repo;
//	@Autowired
//	private RoleRepo rolerepo;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public List<Register> listAll(){
		return repo.findAll();
	}
	public void save(Register reg)
	{
		reg.setPassword(this.passwordEncoder.encode(reg.getPassword()));
		/*
		 * List<Role> role = new ArrayList<Role>(); reg.setRoles(1));
		 */
		repo.save(reg);
	}
	public Register get(Long id)
	{
		return repo.findById(id).get();
	}
	public void delete(Long id)
	{
		repo.deleteById(id);
	}
}
