package products.products.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import products.products.model.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {

}
