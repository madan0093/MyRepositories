package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;


import models.SizeGroup;

public class SizeGroupDAO extends SizeGroup{
	
	private static final long serialVersionUID = 1L;
	public static List<SizeGroup> all() {
		return SizeGroup.find.all();		
	    
	  } 
	  
	  public static void create(JsonNode node) {
		  SizeGroup d=Json.fromJson(node,SizeGroup.class);
		  d.save();
	  }
	  
	  public static void delete(Long id) {
		  SizeGroup.find.byId(id).delete();
	  }
	  public static  SizeGroup read(Long id){
		 return  SizeGroup.find.byId(id);
	  }
	 public static void update(long id,JsonNode node){
		 SizeGroup d= SizeGroup.find.byId(id);
		d=Json.fromJson(node, SizeGroup.class);
		d.save();
	}
	 
	 public static ArrayList<String> readAll(){
		 ArrayList<String> names=new ArrayList<String>();
		 //List<Designer> ds=Designer.find.all();
		 List<SizeGroup> ds= SizeGroup.find.findList();
		 
		 Iterator iter=ds.iterator();
		 
		 while(iter.hasNext()){
			 SizeGroup dd=(SizeGroup) iter.next();
			 names.add(dd.getName());
			 
		 }

		 System.out.println(names);
		 
		 return names;
		  
	 }



}
