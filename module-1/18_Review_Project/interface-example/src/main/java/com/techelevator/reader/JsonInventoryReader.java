package com.techelevator.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.techelevator.inventory.Candy;
import com.techelevator.inventory.Chips;
import com.techelevator.inventory.Drink;
import com.techelevator.inventory.Gum;
import com.techelevator.inventory.Item;
import com.techelevator.inventory.Slot;

public class JsonInventoryReader implements InventoryReader {

	private String filename;
	
	public JsonInventoryReader(String filename) {
		this.filename = filename;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Slot> load() throws FileNotFoundException {
		
		Map<String, Slot> inventory = new LinkedHashMap<String, Slot>();
		
		JSONParser jsonParser = new JSONParser();
		
	       try (FileReader reader = new FileReader(this.filename))
	        {
	            Object obj = jsonParser.parse(reader);
	 
	            JSONArray itemList = (JSONArray) obj;
	 
	           itemList.forEach( jsonItem -> {
	        	   JSONObject itemJsonObj = (JSONObject) jsonItem;
	        	   
	        	   JSONObject itemObj = (JSONObject) itemJsonObj.get("item");
	        	   
	        	   String key = (String) itemObj.get("key");
	        	   String type = (String) itemObj.get("type");
	        	   String name = (String) itemObj.get("name");
	        	   double price = Double.parseDouble((String) itemObj.get("price"));
	        	   Item item = null;
	    		
		    		if (type.equalsIgnoreCase("Chip")) {
		    			item = new Chips(name, price);
		    		}
		    		
		    		if ( type.equalsIgnoreCase( "Candy")) {
		    			item = new Candy(name, price);
		    		}
		    		
		    		if ( type.equalsIgnoreCase( "Gum")) {
		    			item = new Gum(name, price);
		    		}
		    		
		    		if ( type.equalsIgnoreCase( "Drink")) {
		    			item = new Drink(name, price);
		    		}
		    		
		    		inventory.put(key, new Slot( item ));

	           });
	            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }

		
		
		return inventory;
	}
	

}
