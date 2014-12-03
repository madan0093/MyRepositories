package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;

import play.db.ebean.Model;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Color extends Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	private String name;
	

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="product_color")
	@JsonBackReference
	List<Product> products;
	
	
	

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	
	public static Finder<Long,Color> find = new Finder<Long,Color>(Long.class, Color.class); 
}
