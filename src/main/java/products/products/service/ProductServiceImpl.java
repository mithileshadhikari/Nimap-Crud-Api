package products.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import products.products.dao.ProductDao;

import products.products.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;
	
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		Optional<Product>prodOp = productDao.findById(id);
		return prodOp.get();
	}

	@Override
	public Product saveProducts(Product product) {
		// TODO Auto-generated method stub
		return productDao.save(product);
	}
/*
	@Override
	public Product updateProduct(int id, Product product) {
		// TODO Auto-generated method stub
		Optional<Product>prodOp =productDao.findById(product.)
		Product prodFromDB = prodOp.get();
        
        prodFromDB.setCatname(product.getClass());
        
        
        Product savedc = productDao.save(prodFromDB);
		return savedc;
	}
*/
	

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		Optional<Product>prodOp = productDao.findById(id);
		if (prodOp.isPresent()) {
			productDao.delete(prodOp.get());
			return true;
		}

		return false;
	}
	

}
