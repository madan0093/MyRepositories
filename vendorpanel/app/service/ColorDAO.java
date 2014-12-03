package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;

import models.Color;


public class ColorDAO extends Color{
	private static final long serialVersionUID = 1L;
	public static List<Color> all() {
		return Color.find.all();		
	    
	  } 
	  
	  public static void create(JsonNode node) {
		  Color d=Json.fromJson(node,Color.class);
		  d.save();
		  
		 
		  }
	  
	  public static void delete(Long id) {
		  Color.find.byId(id).delete();
	  }
	  public static  Color read(Long id){
		 return  Color.find.byId(id);
	  }
	 public static void update(long id,JsonNode node){
		 Color d= Color.find.byId(id);
		d=Json.fromJson(node, Color.class);
		d.save();
	}
	 
	 public static ArrayList<String> readAll(){
		 ArrayList<String> names=new ArrayList<String>();
		 //List<Designer> ds=Designer.find.all();
		 List< Color> ds= Color.find.findList();
		 
		 Iterator iter=ds.iterator();
		 
		 while(iter.hasNext()){
			 Color dd=( Color) iter.next();
			 names.add(dd.getName());
			 
		 }

		 System.out.println(names);
		 
		 return names;
		  
	 }



}
