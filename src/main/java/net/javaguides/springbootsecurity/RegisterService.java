package net.javaguides.springbootsecurity;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.javaguides.springbootsecurity.entities.Register;
import net.javaguides.springbootsecurity.repositories.RegisterRepo;

@Service
public class RegisterService {
	@Autowired
	private RegisterRepo repo;
	
	public List<Register> listAll(){
		return repo.findAll();
	}
	public void save(Register reg)
	{
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
