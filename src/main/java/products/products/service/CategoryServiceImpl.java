package products.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import products.products.dao.CategoryDao;

import products.products.model.Category;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

	@Override
	public Category getCategory(int id) {
		// TODO Auto-generated method stub
		Optional<Category>catOp = categoryDao.findById(id);
		return catOp.get();
	}

	@Override
	public Category saveCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.save(category);
	}

	@Override
	public Category updateCategory(int id, Category category) {
		// TODO Auto-generated method stub
		Optional<Category>catOp = categoryDao.findById(category.getCategoryId());
		Category catFromDB = catOp.get();
        
        catFromDB.setCatname(category.getCatname());
        
        
        Category savedc = categoryDao.save(catFromDB);
		return savedc;
	}

	@Override
	public boolean deleteCategory(int id) {
		// TODO Auto-generated method stub
		Optional<Category>catOp = categoryDao.findById(id);
		if (catOp.isPresent()) {
			categoryDao.delete(catOp.get());
			return true;
		}

		return false;
	}

	

}
