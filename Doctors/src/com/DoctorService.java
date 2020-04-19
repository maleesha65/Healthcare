package com;

import model.Doctor;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Doctor")
public class DoctorService {
	Doctor DoctorObj = new Doctor();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems()
	 {
	 return DoctorObj.readDoctorDetails();
	 }
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertItem(@FormParam("DocPhone") String Phone,
	 @FormParam("DocAddress") String Address,
	 @FormParam("DocSpecialization") String Specialization,
	 @FormParam("DocEmail") String Email,
	 @FormParam("DocName") String Name)
	
	{
		 String output = DoctorObj.insertDoctorDetails(Phone, Address, Specialization, Email, Name);
		return output;
	}
		
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String update(String item)
	{
		 //Convert the input string to a JSON object
		 JsonObject DoctorObj1 = new JsonParser().parse(item).getAsJsonObject();
		// //Read the values from the JSON object
		 String ID = DoctorObj1.get("DocID").getAsString();
		 String Phone = DoctorObj1.get("DocPhone").getAsString();
		 String Address = DoctorObj1.get("DocAddress").getAsString();
		 String Specialization = DoctorObj1.get("DocSpecialization").getAsString();
		 String Email = DoctorObj1.get("DocEmail").getAsString();
		 String Name = DoctorObj1.get("DocName").getAsString();
		 String output = DoctorObj.updateDoctorDetails(ID,Phone,Address,Specialization,Email,Name);
			return output;
			
	}


	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem(String itemData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(itemData, " ", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String ID = doc.select("DocID").text();
	 String output = DoctorObj.deleteDoctorDetails(ID);
	return output;
	}
	

}
