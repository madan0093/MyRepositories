package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import play.db.ebean.Model;

@Entity
public class Product extends Model{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	private String productcode;
	
	private String name;
	
	private String description;
	
	private float cost;
	
	private String image_path;
	
	
	@ManyToOne	
	private Category category;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="product_color")
	private List<Color> color;
	
	
	@ManyToOne
	private SizeGroup sizes;
	
	
	
	
	@ManyToOne
	private Material material;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="reference")
	@JsonBackReference
	private List<ItemPiece> pieces;

	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="reference")
	private Vendor vendor;
	
	
	
	

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	
	

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	
	public String getProductcode() {
		return productcode;
	}
	
	

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	

	

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	

	public void setCost(float cost) {
		this.cost = cost;
	}

	public float getCost() {
		return cost;
	}
	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = (Category) category;
	}

	public List<Color> getColor() {
		return color;
	}

	public void setColor(List<Color> color) {
		this.color = color;
	}

	public SizeGroup getSizes() {
		return sizes;
	}

	
	public void setSizes(SizeGroup sizes) {
		this.sizes = (SizeGroup) sizes;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public List<Material> getMaterial() {
		return (List<Material>) material;
	}

	public void setMaterial(Material material) {
		this.material = (Material) material;
	}

	public List<ItemPiece> getPieces() {
		return pieces;
	}

	public void setPieces(List<ItemPiece> pieces) {
		this.pieces = pieces;
	}

	
	
	
	public static Finder<Long,Product> find = new Finder<Long,Product>(Long.class, Product.class); 

}
