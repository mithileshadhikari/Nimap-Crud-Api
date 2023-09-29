package products.products.service;

import java.util.List;

import products.products.model.Category;


public interface CategoryService {


List<Category> getAllCategories();
	
Category getCategory(int id);
	
Category saveCategory(Category category);
	
Category updateCategory(int id,Category category);
	
	boolean deleteCategory(int id);

		Page<Category> getCatpaging(Integer pageNumber, Integer pageSize){
		
		Pageable pageable = PageRequest.of(pageNumber,pageSize);
		return CategoryDao.findAll(pageable);
	}

}
