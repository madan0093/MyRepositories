package controllers;

import models.Product;
import models.ShippingUnit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import service.ProductDAO;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;


public class VendorBusinessLogic extends Controller {
	public static Result  getDesigner(Long id) throws JsonProcessingException{
		 ShippingUnit shp=ShippingUnit.find.byId(id);
		 JsonNode jn=Json.toJson(shp);
		 ObjectMapper o=new ObjectMapper();
		 System.out.println("request Receive");
		  return ok(o.writerWithDefaultPrettyPrinter().writeValueAsString(jn)); 
		
	}
	
	

	public static Result createDesigner() throws JsonProcessingException{
		

		
			  JsonNode b=request().body().asJson();
			  System.out.println(b);
			 
			  if(b == null) {
				  System.out.println("hello"); 
				  return badRequest("Expecting Json data");
			  } else {
				  ProductDAO.create(b);
			      return ok("Hello hh ");
			    //}
			  }
			
	}

	public static Result getDesignerList() throws JsonProcessingException{
					
		ObjectMapper o=new ObjectMapper();
		return ok(o.writerWithDefaultPrettyPrinter().writeValueAsString(ProductDAO.readAll()));
		
	}
	



}
