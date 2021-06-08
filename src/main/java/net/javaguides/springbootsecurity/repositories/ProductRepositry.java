package net.javaguides.springbootsecurity.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springbootsecurity.entities.Product;


@Repository
public interface ProductRepositry extends JpaRepository<Product, Long> {

	//List<Product> findAllByCategoryId(Long id);

}
