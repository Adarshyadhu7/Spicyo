package net.javaguides.springbootsecurity.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.javaguides.springbootsecurity.CategoryService;
import net.javaguides.springbootsecurity.GlobalData;
import net.javaguides.springbootsecurity.ProductService;


@Controller
public class UserController {
	@Autowired
	CategoryService category;
	@Autowired
	ProductService product;
	
	@GetMapping("/shop")
	public String shop(Model model)
	{
		model.addAttribute("cartcount",GlobalData.cart.size());
		model.addAttribute("categories", category.getAllCategory());
		model.addAttribute("products",product.getAllProduct());
		return "shop";
	}
	
	@GetMapping("/shop/category/{id}")
	public String itemByCategory(Model model,@PathVariable long id)
	{		
		model.addAttribute("cartcount",GlobalData.cart.size());
		model.addAttribute("categories", category.getAllCategory());
	//	model.addAttribute("products",product.getAllProductsByCategoryId(id));
		return "shop";
	}
//	@GetMapping("/shop/category/{id}")
//	public String itemById(Model model,@PathVariable long id)
//	{		
//		model.addAttribute("cartcount",GlobalData.cart.size());
////		model.addAttribute("product",product.getProductsById(id).get());
//		return "shop";
//	}
	@GetMapping("/shop/viewproduct/{id}")
	public String viewProd(Model model,@PathVariable long id)
	{
//		model.addAttribute("cartcount",GlobalData.cart.size());
//		model.addAttribute("categories", category.getAllCategory());
//		model.addAttribute("products",product.getAllProduct());
		return "viewProduct";
	}

}
