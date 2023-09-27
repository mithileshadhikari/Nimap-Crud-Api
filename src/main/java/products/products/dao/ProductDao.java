package products.products.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import products.products.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {


}
