package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;

import models.Material;


public class MaterialDAO extends Material {
	
	private static final long serialVersionUID = 1L;
	public static List<Material> all() {
		return Material.find.all();		
	    
	  } 
	  
	  public static void create(JsonNode node) {
		  Material d=Json.fromJson(node,Material.class);
		  d.save();
	  }
	  
	  public static void delete(Long id) {
		  Material.find.byId(id).delete();
	  }
	  public static  Material read(Long id){
		 return  Material.find.byId(id);
	  }
	 public static void update(long id,JsonNode node){
		 Material d= Material.find.byId(id);
		d=Json.fromJson(node, Material.class);
		d.save();
	}
	 
	 public static ArrayList<String> readAll(){
		 ArrayList<String> names=new ArrayList<String>();
		 //List<Designer> ds=Designer.find.all();
		 List<Material> ds= Material.find.findList();
		 
		 Iterator iter=ds.iterator();
		 
		 while(iter.hasNext()){
			 Material dd=(Material) iter.next();
			 names.add(dd.getName());
			 
		 }

		 System.out.println(names);
		 
		 return names;
		  
	 }



}
