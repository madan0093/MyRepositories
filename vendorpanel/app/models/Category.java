package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.db.ebean.Model;
import scala.Product;

@Entity
public class Category extends Model{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	private String name;
	
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="category")
	private Product reference;
	
	
	@OneToMany
	private Catalog catalog;
	
	
	
	
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
	
	

	public static Finder<Long,Category> find = new Finder<Long,Category>(Long.class, Category.class); 
}
