package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.ItemPiece;

import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;

public class ItemPieceDAO extends ItemPiece{

	
	private static final long serialVersionUID = 1L;
	public static List<ItemPiece> all() {
		return ItemPiece.find.all();		
	    
	  } 
	  
	  public static void create(JsonNode node) {
		  ItemPiece d=Json.fromJson(node,ItemPiece.class);
		  d.save();
	  }
	  
	  public static void delete(Long id) {
		  ItemPiece.find.byId(id).delete();
	  }
	  public static  ItemPiece read(Long id){
		 return  ItemPiece.find.byId(id);
	  }
	 public static void update(long id,JsonNode node){
		 ItemPiece d= ItemPiece.find.byId(id);
		d=Json.fromJson(node, ItemPiece.class);
		d.save();
	}
	 
	 public static ArrayList<String> readAll(){
		 ArrayList<String> names=new ArrayList<String>();
		 //List<Designer> ds=Designer.find.all();
		 List<ItemPiece> ds= ItemPiece.find.findList();
		 
		 Iterator iter=ds.iterator();
		 
		 while(iter.hasNext()){
			 ItemPiece dd=(ItemPiece) iter.next();
			 names.add(dd.getName());
			 
		 }

		 System.out.println(names);
		 
		 return names;
		  
	 }


}
