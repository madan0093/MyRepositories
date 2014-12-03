package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;

import models.Category;


public class CategoryDAO extends Category{

	
	private static final long serialVersionUID = 1L;
	public static List<Category> all() {
		return Category.find.all();		
	    
	  } 
	  
	  public static void create(JsonNode node) {
		  Category d=Json.fromJson(node,Category.class);
		  d.save();
	  }
	  
	  public static void delete(Long id) {
		  Category.find.byId(id).delete();
	  }
	  public static  Category read(Long id){
		 return  Category.find.byId(id);
	  }
	 public static void update(long id,JsonNode node){
		 Category d= Category.find.byId(id);
		d=Json.fromJson(node, Category.class);
		d.save();
	}
	 
	 public static ArrayList<String> readAll(){
		 ArrayList<String> names=new ArrayList<String>();
		 //List<Designer> ds=Designer.find.all();
		 List<Category> ds= Category.find.findList();
		 
		 Iterator iter=ds.iterator();
		 
		 while(iter.hasNext()){
			 Category dd=(Category) iter.next();
			 names.add(dd.getName());
			 
		 }

		 System.out.println(names);
		 
		 return names;
		  
	 }

}
