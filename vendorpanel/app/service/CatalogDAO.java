package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;

import models.Catalog;


public class CatalogDAO extends Catalog{
	
	
	private static final long serialVersionUID = 1L;
	public static List<Catalog> all() {
		return Catalog.find.all();		
	    
	  } 
	  
	  public static void create(JsonNode node) {
		  Catalog d=Json.fromJson(node,Catalog.class);
		  d.save();
	  }
	  
	  public static void delete(Long id) {
		  Catalog.find.byId(id).delete();
	  }
	  public static  Catalog read(Long id){
		 return  Catalog.find.byId(id);
	  }
	 public static void update(long id,JsonNode node){
		 Catalog d= Catalog.find.byId(id);
		d=Json.fromJson(node, Catalog.class);
		d.save();
	}
	 
	 public static ArrayList<String> readAll(){
		 ArrayList<String> names=new ArrayList<String>();
		 //List<Designer> ds=Designer.find.all();
		 List<Catalog> ds= Catalog.find.findList();
		 
		 Iterator iter=ds.iterator();
		 
		 while(iter.hasNext()){
			 Catalog dd=(Catalog) iter.next();
			 names.add(dd.getName());
			 
		 }

		 System.out.println(names);
		 
		 return names;
		  
	 }



}
