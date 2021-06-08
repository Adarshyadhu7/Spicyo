package net.javaguides.springbootsecurity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springbootsecurity.entities.Category;
import net.javaguides.springbootsecurity.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository cat;

	public List<Category> getAllCategory()
	{
		return cat.findAll();
	}
	public void addCategory(Category category)
	{
		cat.save(category);
	}
	public void removeCatById(long id)
	{
		cat.deleteById(id);
	}
	public Optional<Category> getCatById(long id)
	{
		return cat.findById(id);
	}
}
