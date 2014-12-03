package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;

import models.Product;
import models.ShippingUnit;

public class ShippingUnitDAO extends ShippingUnit{

	private static final long serialVersionUID = 1L;
	public static List<ShippingUnit> all() {
		return ShippingUnit.find.all();		
	    
	  } 
	  
	  public static void create(JsonNode node) {
		  ShippingUnit d=Json.fromJson(node,ShippingUnit.class);
		  d.save();
	  }
	  
	  public static void delete(Long id) {
		  ShippingUnit.find.byId(id).delete();
	  }
	  public static  ShippingUnit read(Long id){
		 return  ShippingUnit.find.byId(id);
	  }
	 public static void update(long id,JsonNode node){
		 ShippingUnit d= ShippingUnit.find.byId(id);
		d=Json.fromJson(node, ShippingUnit.class);
		d.save();
	}
	 
	 public static ArrayList<String> readAll(){
		 ArrayList<String> names=new ArrayList<String>();
		 //List<Designer> ds=Designer.find.all();
		 List<ShippingUnit> ds= ShippingUnit.find.findList();
		 
		 Iterator iter=ds.iterator();
		 
		 while(iter.hasNext()){
			 ShippingUnit dd=(ShippingUnit) iter.next();
			 names.add(dd.getName());
			 
		 }

		 System.out.println(names);
		 
		 return names;
		  
	 }


}
