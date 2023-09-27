package products.products.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import products.products.model.Category;
import products.products.service.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Category>> getAllCategories()
	{
		List<Category> catList = categoryService .getAllCategories();
		ResponseEntity<List<Category>> response =
				new ResponseEntity<List<Category>>(catList,HttpStatusCode.valueOf(200));
		return response;
	}
	
	@PostMapping(produces = "application/json")
	public ResponseEntity <Category> saveCategory(@RequestBody Category category)
	{
		Category cat =categoryService.saveCategory(category);
		ResponseEntity <Category> response = 
		new ResponseEntity <Category>(cat,HttpStatusCode.valueOf(200));
		return response;
		    
	}
	
	@GetMapping(value = "/{id}",produces = "application/json")
	public ResponseEntity<Category> getCategory(@PathVariable("id")Integer id)
	{
		Category cat=categoryService.getCategory(id);
		ResponseEntity<Category> response =
		new ResponseEntity<Category>(cat, HttpStatusCode.valueOf(200));
		return response;
		
	}
	
	@PutMapping(value = "/{id}",produces = "application/json")
	public ResponseEntity<Category> updateCategory(@PathVariable("id")Integer id, @RequestBody Category category)
	{
		Category cat=categoryService.updateCategory(id, category);
		ResponseEntity<Category> response =
		new ResponseEntity<Category>(cat,HttpStatusCode.valueOf(200));
		return response;
		
	}
	

	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<String> deleteCategory(@PathVariable("id") Integer id)
	{
		boolean res = categoryService.deleteCategory(id);
		String message;
		int status;
		if(res == true)
		{
		message = "category deleted!";
		status = 200;
		
		} else {
			message = "unable to delete!";
			status = 400;
		}
		ResponseEntity<String> response = 
				new ResponseEntity<String>(message, HttpStatusCode.valueOf(status));
		return response;
		
	}

	
}
