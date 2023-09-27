package products.products.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="categorydata")
public class Category  implements Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;
	
	@Column
	private String catname;
	
	
	  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	    private List<Product> products;
	  
	 
	 public Category() {
		// TODO Auto-generated constructor stub
	}

	

	
	public Category(String catname, List<Product> products) {
		this.catname = catname;
		this.products = products;
	}





	public int getCategoryId() {
		return categoryId;
	}




	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}




	public String getCatname() {
		return catname;
	}




	public void setCatname(String catname) {
		this.catname = catname;
	}




	public List<Product> getProducts() {
		return products;
	}




	public void setProducts(List<Product> products) {
		this.products = products;
	}




	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", catname=" + catname + ", products=" + products + "]";
	}




	@Override
	public int hashCode() {
		return Objects.hash(categoryId, catname, products);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return categoryId == other.categoryId && Objects.equals(catname, other.catname)
				&& Objects.equals(products, other.products);
	}










	
	
		 
	

}
