package net.javaguides.springbootsecurity.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.javaguides.springbootsecurity.CategoryService;
import net.javaguides.springbootsecurity.ProductService;
import net.javaguides.springbootsecurity.entities.Category;
import net.javaguides.springbootsecurity.entities.Product;


@Controller
public class AdminProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService cat;
	
	//Product Controllers
	@GetMapping("/Admin/index")
	public String showExampleView(Model model)
	{
		List<Product> products = productService.getAllProduct();
		model.addAttribute("products", products);
		return "Admin/index";
	}
    @GetMapping("/Admin/product")
    public String showAddProduct(Model m)
    {
    	m.addAttribute("categories",cat.getAllCategory());
    	return "Admin/product";
    }
    
    @PostMapping("/Admin/addP")
    public String saveProduct(@RequestParam("file") MultipartFile file,
    		@RequestParam("pname") String name,
    		@RequestParam("price") int price,
    		@RequestParam("desc") String desc,
    		@RequestParam("categoryId") Long categoryId)
    {
    	productService.saveProductToDB(file, name, desc, price, categoryId);
    	return "redirect:/Admin/index?inserted";
    }
    
    @GetMapping("/Admin/deleteProd/{id}")
    public String delProduct(@PathVariable long id)
    {
    	productService.deleteProdById(id);
    	return "redirect:/Admin/index?updated";
    }    
    
    @PostMapping("/Admin/changeName")
    public String changePname(@RequestParam("id") long id,
    		@RequestParam("newPname") String name)
    {
    	productService.changeProductName(id, name);
    	return "redirect:/Admin/index?updated";
    }
    @PostMapping("/Admin/changeDescription")
    public String changeDescription(@RequestParam("id") Long id ,
    		@RequestParam("newDescription") String description)
    {
    	productService.changeProductDescription(id, description);
    	return "redirect:/Admin/index?updated";
    }
    
    @PostMapping("/Admin/changePrice")
    public String changePrice(@RequestParam("id") Long id ,
    		@RequestParam("newPrice") int price)
    {
    	productService.changeProductPrice(id, price);
    	return "redirect:/Admin/index?updated";
    }
    
    
    //Category Controllers
    @GetMapping("Admin/categories")
    public String getCat(Model m)
    {
    	m.addAttribute("categories",cat.getAllCategory());
    	return "categories";
    }
    
    @GetMapping("Admin/categories/add")
    public String getCatAdd(Model m)
    {
    	m.addAttribute("category",new Category());
    	return "categoriesAdd";
    }
    
    @PostMapping("Admin/categories/add")
    public String AddCat(@ModelAttribute("category")Category category)
    {
    	cat.addCategory(category);
    	return "redirect:/Admin/categories?success";
    }
    
    @GetMapping("/Admin/categories/delete/{id}")
    public String CatDel(@PathVariable long id)
    {
    	cat.removeCatById(id);
    	return "redirect:/Admin/categories?success";
    }
    
    @GetMapping("/Admin/categories/update/{id}")
    public String CatUpdate(@PathVariable long id,Model m)
    {
    	Optional<Category> category =cat.getCatById(id);
    	if(category.isPresent())
    	{
    		m.addAttribute("category",category.get());
    		return "categoriesAdd";
    	}
    	else
    	{
    		return "403";
    	}
    	
    }
}
