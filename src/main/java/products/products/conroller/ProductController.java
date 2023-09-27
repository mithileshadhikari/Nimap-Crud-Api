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
import products.products.model.Product;
import products.products.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Product>> getAllProducts()
	{
		List<Product> prodList = productService .getAllProducts();
		ResponseEntity<List<Product>> response =
				new ResponseEntity<List<Product>>(prodList,HttpStatusCode.valueOf(200));
		return response;
	}
	
	@PostMapping(produces = "application/json")
	public ResponseEntity <Product> saveProducts(@RequestBody Product product)
	{
		Product prod =productService.saveProducts(product);
		ResponseEntity <Product> response = 
		new ResponseEntity <Product>(prod,HttpStatusCode.valueOf(200));
		return response;
		    
	}
	
	@GetMapping(value = "/{id}",produces = "application/json")
	public ResponseEntity<Product> getProduct(@PathVariable("id")Integer id)
	{
		Product prod=productService.getProduct(id);
		ResponseEntity<Product> response =
		new ResponseEntity<Product>(prod, HttpStatusCode.valueOf(200));
		return response;
		
	}
	
	@PutMapping(value = "/{id}",produces = "application/json")
	public ResponseEntity<Product> updateProduct(@PathVariable("id")Integer id, @RequestBody Product product)
	{
		Product prod=productService.updateProduct(id, product);
		ResponseEntity<Product> response =
		new ResponseEntity<Product>(prod,HttpStatusCode.valueOf(200));
		return response;
		
	}
	

	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer id)
	{
		boolean res = productService.deleteProduct(id);
		String message;
		int status;
		if(res == true)
		{
		message = "product deleted!";
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
