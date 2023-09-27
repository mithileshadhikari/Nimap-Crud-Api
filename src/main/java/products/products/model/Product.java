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
@Table(name="productdata")
public class Product implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
	
	@Column
	private String name;
	

	@Column
	private double amount;
	
	
	 @ManyToOne
	 @JoinColumn
	 private Category category;
	 
	  public Product() {
		// TODO Auto-generated constructor stub
	}

	
	public Product(String name, double amount, Category category) {
		
		this.name = name;
		this.amount = amount;
		this.category = category;
	}



	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", amount=" + amount + ", category=" + category
				+ "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(amount, category, name, productId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(category, other.category) && Objects.equals(name, other.name)
				&& productId == other.productId;
	}


	public void setCatname(Class<? extends Product> class1) {
		// TODO Auto-generated method stub
		
	}




	
	  
	  

	
}
