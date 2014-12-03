package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



import play.db.ebean.Model;

@Entity
public class Vendor extends Model{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String name;
	private String address;
	private Long phone;
	private String email;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Catalog> catalogs;
	
	
	@ManyToOne
	private Product refrence;
	
	public List<Catalog> getCatalogs() {
		return catalogs;
	}
	
	public void setCatalogs(List<Catalog> catalogs) {
		this.catalogs = catalogs;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public static Finder<Long,Vendor> find = new Finder<Long,Vendor>(Long.class, Vendor.class); 
	

}
