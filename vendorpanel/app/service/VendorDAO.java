package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;


import models.Vendor;

public class VendorDAO extends Vendor{
	
	private static final long serialVersionUID = 1L;
	public static List<Vendor> all() {
		return Vendor.find.all();		
	    
	  } 
	  
	  public static void create(JsonNode node) {
		  Vendor d=Json.fromJson(node,Vendor.class);
		  d.save();
	  }
	  
	  public static void delete(Long id) {
		  Vendor.find.byId(id).delete();
	  }
	  public static  Vendor read(Long id){
		 return  Vendor.find.byId(id);
	  }
	 public static void update(long id,JsonNode node){
		 Vendor d= Vendor.find.byId(id);
		d=Json.fromJson(node, Vendor.class);
		d.save();
	}
	 
	 public static ArrayList<String> readAll(){
		 ArrayList<String> names=new ArrayList<String>();
		 //List<Designer> ds=Designer.find.all();
		 List<Vendor> ds= Vendor.find.findList();
		 
		 Iterator iter=ds.iterator();
		 
		 while(iter.hasNext()){
			 Vendor dd=(Vendor) iter.next();
			 names.add(dd.getName());
			 
		 }

		 System.out.println(names);
		 
		 return names;
		  
	 }



}
