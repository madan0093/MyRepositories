package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.ebean.Model;

@Entity
public class ShippingUnit extends Model {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	public String customer_firstname;
	public String customer_lastname;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="piece")
	List<ItemPiece> items;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ItemPiece> getItems() {
		return items;
	}

	public void setItems(List<ItemPiece> items) {
		this.items = items;
	}
	public static Finder<Long,ShippingUnit> find = new Finder<Long,ShippingUnit>(Long.class, ShippingUnit.class);

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	} 

	

}
