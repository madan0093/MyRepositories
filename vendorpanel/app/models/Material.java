package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.db.ebean.Model;

@Entity
public class Material extends Model{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	private String name;

	@OneToMany(cascade=CascadeType.ALL,mappedBy="material")
	private List<Product> reference;
	
	

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
	
	
	public static Finder<Long,Material> find = new Finder<Long,Material>(Long.class, Material.class); 
}
