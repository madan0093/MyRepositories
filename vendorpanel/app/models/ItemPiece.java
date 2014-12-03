package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.ebean.Model;


@Entity
public class ItemPiece extends Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	private String name;
	
	@ManyToOne
	private ItemPiece piece;
	
	@ManyToOne
	private Product reference;
	
	

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
	
	
	

	public void setReference(Product reference) {
		this.reference = reference;
	}

	public Product getReference() {
		return reference;
	}
	
	
	
	public static Finder<Long,ItemPiece> find = new Finder<Long,ItemPiece>(Long.class, ItemPiece.class); 
	
}
