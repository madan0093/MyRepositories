package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import play.db.ebean.Model;

@Entity
public class SizeGroup extends Model{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="sizes")
	@JsonBackReference
	private  Product product;
	
	private List<String> sizes;
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSizes() {
		return (List<String>) sizes;
	}

	public void setSizes(List<String> sizes) {
		this.sizes = sizes;
	}
	
	public static Finder<Long,SizeGroup> find = new Finder<Long,SizeGroup>(Long.class,SizeGroup.class); 
}
