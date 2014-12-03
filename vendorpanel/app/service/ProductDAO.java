package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;

import models.Product;

public class ProductDAO extends Product{

	private static final long serialVersionUID = 1L;
	public static List<Product> all() {
		return Product.find.all();		
	    
	  } 
	  
	  public static void create(JsonNode node) {
		  Product d=Json.fromJson(node,Product.class);
		  d.save();
	  }
	  
	  public static void delete(Long id) {
		  Product.find.byId(id).delete();
	  }
	  public static  Product read(Long id){
		 return  Product.find.byId(id);
	  }
	 public static void update(long id,JsonNode node){
		 Product d= Product.find.byId(id);
		d=Json.fromJson(node, Product.class);
		d.save();
	}
	 
	 public static ArrayList<String> readAll(){
		 ArrayList<String> names=new ArrayList<String>();
		 //List<Designer> ds=Designer.find.all();
		 List< Product> ds= Product.find.findList();
		 
		 Iterator iter=ds.iterator();
		 
		 while(iter.hasNext()){
			 Product dd=( Product) iter.next();
			 names.add(dd.getName());
			 
		 }

		 System.out.println(names);
		 
		 return names;
		  
	 }

}
