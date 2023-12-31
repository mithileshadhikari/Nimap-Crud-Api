package products.products.service;

import java.util.List;

import products.products.model.Category;
import products.products.model.Product;



public interface ProductService {


List<Product> getAllProducts();
	
Product getProduct(int id);
	
Product saveProducts(Product product);
	
Product updateProduct(int id,Product product);
	
	boolean deleteProduct(int id);

	Page<Product> getProdpaging(Integer pageNumber, Integer pageSize){
		
		Pageable pageable = PageRequest.of(pageNumber,pageSize);
		return ProductDao.findAll(pageable);
	}




}
